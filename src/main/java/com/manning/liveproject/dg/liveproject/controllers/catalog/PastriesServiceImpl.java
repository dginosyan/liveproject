package com.manning.liveproject.dg.liveproject.controllers.catalog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastriesServiceImpl implements PastriesService {
    @Override
    public List<Pastry> getPastries() {
        return List.of(
                new Pastry("abcr", "All Butter Croissant", 0.75),
                new Pastry("ccr", "Chocolate Croissant", 0.95),
                new Pastry("b", "Fresh Baguette", 1.60),
                new Pastry("rv", "Red Velvet", 3.95),
                new Pastry("vs", "Victoria Sponge", 5.45),
                new Pastry("cc", "Carrot Cake", 3.45)
        );
    }
}
