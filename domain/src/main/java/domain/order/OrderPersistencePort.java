package domain.order;

import domain.item.Item;

import java.util.Map;

public interface OrderPersistencePort {
    void saveOrder(String orderInfo, Map<Item, Integer> basketItems);
}
