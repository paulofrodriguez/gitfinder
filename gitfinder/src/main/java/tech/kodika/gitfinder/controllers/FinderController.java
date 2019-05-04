package tech.kodika.gitfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kodika.gitfinder.helpers.GitFinderHelper;

@RestController
public class FinderController {

    @Autowired
    GitFinderHelper gitFinderHelper;

    @RequestMapping("/oi")
    public String findAll() {
        try {
            gitFinderHelper.getTrendingRepos("weekly", "javascript");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "ma oi";

    }
}