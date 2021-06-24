package com.hugesalt.springjokesapp.controllers;

import com.hugesalt.springjokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    //because i have a constructor i dont need autowired
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model){
        //model gets return to thymeleaf view
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
