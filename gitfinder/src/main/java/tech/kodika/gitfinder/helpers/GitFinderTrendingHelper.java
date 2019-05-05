package tech.kodika.gitfinder.helpers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.kodika.gitfinder.exceptions.GitFinderException;
import tech.kodika.gitfinder.persistence.entities.BuiltBy;
import tech.kodika.gitfinder.persistence.entities.Repo;
import tech.kodika.gitfinder.persistence.repositories.BuiltByRepository;
import tech.kodika.gitfinder.persistence.repositories.RepoRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

@Component
public class GitFinderTrendingHelper {

    @Autowired
    PropertiesHelper propertiesHelper;

    @Autowired
    RepoRepository repoRepository;

    @Autowired
    BuiltByRepository builtByRepository;

    public void getTrendingRepos(String period, String language) throws Throwable {

        try {

            String apiUrl = propertiesHelper.getProperty(PropertiesHelper.URL_TARGET_TRENDING);

            validate(period, language, apiUrl);

            StringBuffer json = gitFinder(period, language, apiUrl);

            save(parser(json));

        } catch (Throwable t) {

            throw new GitFinderException(t.getMessage(), t);
        }

    }

    private StringBuffer gitFinder(String period, String language, String apiUrl) throws Throwable {

        //prepare
        Map<String, String> parameters = new HashMap<>();

        parameters.put("language", language);

        parameters.put("since", period);

        URL url = new URL(apiUrl + "?" + getParamsString(parameters));

        //ask
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.setConnectTimeout(5000);

        con.setReadTimeout(5000);

        //and its given...
        int status = con.getResponseCode();

        if (status != 200) {
            throw new Exception("Something went wrong. Server answer with status: " + status + " for request: " + url + " with parmeters: " + parameters.toString());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {

            content.append(inputLine);
        }

        in.close();

        con.disconnect();

        return content;
    }


    //method below is a courtesy of https://www.baeldung.com/java-http-request
    // ps: I know it breaks OO but create a class just for it is too much, ok ?

    private String getParamsString(Map<String, String> params) throws Throwable {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));

            result.append("=");

            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));

            result.append("&");

        }

        String resultString = result.toString();

        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }


    private Repo[] parser(StringBuffer json) throws Throwable {


        Gson gson = new Gson();

        Repo[] arr = gson.fromJson(json.toString(), Repo[].class);

        return arr;

    }

    private void save(Repo[] repo) throws Throwable {

        for (Repo r : repo) {

            for (BuiltBy b : r.getBuiltBy()) {

                //maybe, it exists
                BuiltBy aux = builtByRepository.findByUsername(b.getUsername());

                if (aux != null) {//exists, let's update

                    b.setId(aux.getId());

                    builtByRepository.save(b);

                } else {//not found, let's  create

                    builtByRepository.save(b);

                }

            }

            Repo aux = repoRepository.findByName(r.getName());

            if (aux != null) {
                r.setId(aux.getId());
                repoRepository.save(r);
            } else {
                repoRepository.save(r);
            }

        }

    }

    private void validate(String period, String language, String apiUrl) throws Throwable {

        //ultrawide monitor: I can make long lines. Thanks LG.
        if (period == null || period.length() == 0 || language == null || language.length() == 0 || apiUrl == null || apiUrl.length() == 0) {

            throw new InvalidParameterException("Invalid Period or Language: |period:" + period + " language:" + language + ".");
        }

    }
}
