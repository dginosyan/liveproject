package com.manning.liveproject.dg.liveproject.controllers;

import com.manning.liveproject.dg.liveproject.controllers.catalog.PastriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    private PastriesService pastriesService;

    HomeController(PastriesService pastriesService) {
        this.pastriesService = pastriesService;
    }

    @GetMapping("/")
    String home(ModelMap model) {
        model.addAttribute("pastries", pastriesService.getPastries());
        return "index";
    }
}
