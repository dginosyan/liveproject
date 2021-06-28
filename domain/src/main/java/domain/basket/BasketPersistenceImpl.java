package domain.basket;

import domain.basket.BasketPersistencePort;
import domain.item.Item;

import java.util.HashMap;
import java.util.Map;

public class BasketPersistenceImpl implements BasketPersistencePort {
    private final Map<Item, Integer> basket = new HashMap<>();

    @Override
    public void add(Item item) {
        Item keyItem = findKey(item);
        if (keyItem == null) {
            basket.put(item, 1);
        } else {
            basket.put(keyItem, basket.get(keyItem) + 1);
        }
    }

    @Override
    public void remove(Item item) {
        Item keyItem = findKey(item);
        if (keyItem != null) {
            basket.remove(keyItem);
        }
    }

    @Override
    public void decrease(Item item) {
        Item keyItem = findKey(item);
        if (keyItem != null) {
            if (basket.get(keyItem) > 1) {
                basket.put(keyItem, basket.get(keyItem) - 1);
            } else {
                basket.remove(keyItem);
            }
        }
    }

    @Override
    public void clear() {
        basket.clear();
    }

    @Override
    public int getBasketItemCount() {
        return basket.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Map<Item, Integer> getBasketItems() {
        return this.basket;
    }

    private Item findKey(Item item) {
        return basket.keySet().stream().filter(it -> it.getTitle().equals(item.getTitle())).findFirst().orElse(null);
    }
}
