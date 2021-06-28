package com.manning.liveproject.dg.liveproject.basket;

import domain.basket.BasketServicePort;
import domain.pastries.PastryDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BasketController {

    BasketServicePort basketServicePort;

    BasketController(BasketServicePort basketServicePort) {
        this.basketServicePort = basketServicePort;
    }

    @GetMapping("/basket")
    String basket(ModelMap model) {
        model.addAttribute("basket", basketServicePort);
        return "basket";
    }

    @PostMapping("/basket")
    String removeFromBasket(@ModelAttribute PastryDto item) {
        basketServicePort.remove(item);
        return "redirect:/basket";
    }

    @PostMapping("/basket/increase")
    String increaseItemQty(@ModelAttribute PastryDto item) {
        basketServicePort.add(item);
        return "redirect:/basket";
    }

    @PostMapping("/basket/decrease")
    String decreaseItemQty(@ModelAttribute PastryDto item) {
        basketServicePort.decrease(item);
        return "redirect:/basket";
    }

}
