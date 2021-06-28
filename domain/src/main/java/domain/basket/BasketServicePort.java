package domain.basket;

import domain.item.Item;

import java.util.Map;

public interface BasketServicePort {

    void add(Item item);
    void remove(Item item);
    void decrease(Item item);
    void clear();
    int getBasketItemCount();
    Map<Item, Integer> getBasketItems();

}
