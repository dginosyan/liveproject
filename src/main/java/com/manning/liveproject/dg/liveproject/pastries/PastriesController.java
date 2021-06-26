package com.manning.liveproject.dg.liveproject.pastries;

import domain.pastries.PastryServicePort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PastriesController {

    final PastryServicePort pastryServicePort;

    public PastriesController(PastryServicePort pastryServicePort) {
        this.pastryServicePort = pastryServicePort;
    }

    @GetMapping("/")
    String home(ModelMap model) {
        model.addAttribute("pastries", this.pastryServicePort.getPastries());
        return "index";
    }

}
