package tech.kodika.gitfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tech.kodika.gitfinder.helpers.GitFinderHelper;
import tech.kodika.gitfinder.persistence.entities.SearchInfo;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FinderController {

    @Autowired
    GitFinderHelper gitFinderHelper;

    @RequestMapping("/oi")
    public String findAll() {
        try {
            gitFinderHelper.getTrendingRepos("tetris", "javascript");

        } catch (Throwable t) {

            t.printStackTrace();

        }

        return "ma oi";
    }

    @GetMapping({"/", "/hello"})
    public ModelAndView hello( @RequestParam Map<String,String> allParams) {

        Map<String, Object> params = new HashMap<>();

        params.put("name",allParams.get("name"));

        params.put("query",allParams.get("query"));
        
        ModelAndView m = new ModelAndView("main",params);

        return m;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam Map<String,String>allParams){

        ModelAndView result=null;

        try{

            SearchInfo s= gitFinderHelper.getTrendingRepos(allParams.get("query"),allParams.get("language"));

            Map<String, Object> response = new HashMap<>();

            response.put("data",s);

            response.put("name",allParams.get("name"));

            result = new ModelAndView("result", response);


        }catch (Throwable t){

            t.printStackTrace();

        }

        return result;
    }
}