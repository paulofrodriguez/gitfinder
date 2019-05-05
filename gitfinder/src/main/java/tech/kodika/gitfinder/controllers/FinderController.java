package tech.kodika.gitfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.kodika.gitfinder.helpers.GitFinderHelper;

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
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        model.addAttribute("name", name);

        return "main";
    }
}