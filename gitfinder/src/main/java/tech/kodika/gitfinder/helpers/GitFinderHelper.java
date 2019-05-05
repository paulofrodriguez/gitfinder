package tech.kodika.gitfinder.helpers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.kodika.gitfinder.exceptions.GitFinderException;
import tech.kodika.gitfinder.persistence.entities.Item;
import tech.kodika.gitfinder.persistence.entities.License;
import tech.kodika.gitfinder.persistence.entities.Owner;
import tech.kodika.gitfinder.persistence.entities.SearchInfo;
import tech.kodika.gitfinder.persistence.repositories.ItemRepository;
import tech.kodika.gitfinder.persistence.repositories.LicenseRepository;
import tech.kodika.gitfinder.persistence.repositories.OwnerRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GitFinderHelper {

    @Autowired
    PropertiesHelper propertiesHelper;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    LicenseRepository licenseRepository;

    public SearchInfo getTrendingRepos(String query, String language) throws Throwable {

        try {

            String apiUrl = propertiesHelper.getProperty(PropertiesHelper.URL_TARGET);

            validate(query, language, apiUrl);

            StringBuffer json = gitFinder(query, language, apiUrl);

            SearchInfo s = parser(json);

            save(s);

            return s;


        } catch (Throwable t) {

            throw new GitFinderException(t.getMessage(), t);
        }

    }

    private StringBuffer gitFinder(String query, String language, String apiUrl) throws Throwable {

        //prepare
        Map<String, String> parameters = new HashMap<>();

        parameters.put("language", language);

        parameters.put("q", query);

        parameters.put("order", "desc"); //hard coded only for the purpose of the test, bad practice

        parameters.put("sort", "stars"); //hard coded only for the purpose of the test, bad practice

        URL url = new URL(apiUrl + "?" + getParamsString(parameters));

        //ask...
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


    // I know it breaks OO but create a class just for it is too much, ok ?

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


    private SearchInfo parser(StringBuffer json) throws Throwable {


        Gson gson = new Gson();

        SearchInfo arr = gson.fromJson(json.toString(), SearchInfo.class);

        return arr;

    }

    private void save(SearchInfo searchInfo) throws Throwable {

        List<Item> items = searchInfo.getItems();
        for (Item i : items) {

            Owner o = i.getOwner();

            License l = i.getLicense();

            if (o != null) {

                ownerRepository.save(o);

            } else {

                throw new GitFinderException("There is a item with no owner: " + i.toString());
                }

            if (l != null) {

                licenseRepository.save(l);
            }

            itemRepository.save(i);
        }


    }

    private void validate(String query, String language, String apiUrl) throws Throwable {

        //ultrawide monitor: I can make long lines. Thanks LG.
        if (query == null || query.length() == 0 || language == null || language.length() == 0 || apiUrl == null || apiUrl.length() == 0) {

            throw new InvalidParameterException("Invalid query or Language: |query:" + query + " language:" + language + ".");
        }

    }
}
