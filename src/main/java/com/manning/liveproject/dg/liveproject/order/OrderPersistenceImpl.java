package com.manning.liveproject.dg.liveproject.order;

import domain.item.Item;
import domain.order.OrderPersistencePort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class OrderPersistenceImpl implements OrderPersistencePort {
    @Override
    public void saveOrder(String orderInfo, Map<Item, Integer> basketItems) {
        File file = new File("order.txt");

        try(FileWriter fw = new FileWriter(file)) {
            fw.append("\n-------------------------------------------------------");
            fw.append(orderInfo);
            basketItems.entrySet().stream().forEach(it -> {
                try {
                    fw.append("\nTitle: ")
                            .append(it.getKey().getTitle())
                            .append("\nPrice: ")
                            .append(String.valueOf(it.getKey().getPrice()))
                            .append("\nQty: ")
                            .append(String.valueOf(it.getValue()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fw.append("\n-------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
