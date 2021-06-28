package com.manning.liveproject.dg.liveproject.order;

import domain.basket.BasketServicePort;
import domain.order.OrderServicePort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class OrderController {

    final OrderServicePort orderServicePort;
    final BasketServicePort basketServicePort;

    OrderController(OrderServicePort orderServicePort, BasketServicePort basketServicePort) {
        this.orderServicePort = orderServicePort;
        this.basketServicePort = basketServicePort;
    }

    @PostMapping("/order")
    String completeOrder(@RequestPart("line1") String line1,
                         @RequestPart(name="line2", required = false) String line2,
                         @RequestPart("postcode") String postcode, ModelMap model) {


        if (line2 == null) {
            line2 = "";
        }


        String orderInfo = "Line1: " + line1 +
                "\nLine2: " + line2 +
                "\nPost: " + postcode;

        model.addAttribute("basket", basketServicePort);

        orderServicePort.completeOrder(orderInfo, basketServicePort.getBasketItems());
        basketServicePort.clear();

        return "order";
    }
}
