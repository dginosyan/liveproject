package domain.order;

import domain.item.Item;

import java.util.Map;

public interface OrderServicePort {
    void completeOrder(String orderInfo, Map<Item, Integer> basketItems);
}
