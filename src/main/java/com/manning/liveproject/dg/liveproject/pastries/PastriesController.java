package com.manning.liveproject.dg.liveproject.pastries;

import domain.basket.BasketServicePort;
import domain.pastries.PastryDto;
import domain.pastries.PastryServicePort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;

@Controller
public class PastriesController {

    final PastryServicePort pastryServicePort;
    final BasketServicePort basketServicePort;

    public PastriesController(PastryServicePort pastryServicePort, BasketServicePort basketServicePort) {
        this.pastryServicePort = pastryServicePort;
        this.basketServicePort = basketServicePort;
    }

    @GetMapping("/")
    String home(ModelMap model) {
        model.addAttribute("aaa", new PastryDto(1L, "a", "b", 1.1));
        model.addAttribute("pastries", this.pastryServicePort.getPastries());
        model.addAttribute("basket", this.basketServicePort);
        return "index";
    }

    @PostMapping("/")
    String addToBasket(@ModelAttribute PastryDto item) {
        this.basketServicePort.add(item);
        return "redirect:/";
    }

}
