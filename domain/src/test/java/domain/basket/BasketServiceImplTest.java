package domain.basket;

import domain.item.Item;
import domain.pastries.PastryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BasketServiceImplTest {

    BasketServicePort basketServicePort;

    @BeforeEach
    void setup() {
        this.basketServicePort = new BasketServiceImpl(new BasketPersistenceImpl());
    }

    @Test
    void add() {
        // Arrange
        List<Item> items = generateItemForBusket();
        // Act
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(1));
        this.basketServicePort.add(items.get(2));
        // Assert
        assertEquals(basketServicePort.getBasketItemCount(), 4);
    }

    @Test
    void remove() {
        // Arrange
        List<Item> items = generateItemForBusket();
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(1));
        // Act
        this.basketServicePort.remove(items.get(0));
        // Assert
        assertEquals(basketServicePort.getBasketItemCount(), 1);
    }

    @Test
    void decrease() {
        // Arrange
        List<Item> items = generateItemForBusket();
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(0));
        // Act
        this.basketServicePort.decrease(items.get(0));
        // Assert
        assertEquals(basketServicePort.getBasketItemCount(), 1);
    }

    @Test
    void clear() {
        // Arrange
        List<Item> items = generateItemForBusket();
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(0));
        // Act
        this.basketServicePort.clear();
        // Assert
        assertEquals(basketServicePort.getBasketItemCount(), 0);
    }

    @Test
    void getBasketItemCount() {

        // Arrange
        List<Item> items = generateItemForBusket();
        // Act
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(1));
        // Assert
        assertEquals(basketServicePort.getBasketItemCount(), 3);

    }

    @Test
    void getBasketItems() {
        // Arrange
        List<Item> items = generateItemForBusket();
        // Act
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(0));
        this.basketServicePort.add(items.get(1));
        // Assert
        Map<Item, Integer> basketMap = basketServicePort.getBasketItems();
        Set<Item> basketItems = basketMap.keySet();
        boolean isItem1ExistsInBasket = basketItems.stream().anyMatch(it -> Objects.equals(it.getTitle(), items.get(0).getTitle()));
        boolean isItem2ExistsInBasket = basketItems.stream().anyMatch(it -> Objects.equals(it.getTitle(), items.get(1).getTitle()));
        Item item = basketItems.stream().filter(it -> it.getTitle() == items.get(0).getTitle()).findFirst().orElse(null);
        assertAll(
                () -> { assertTrue(isItem1ExistsInBasket && isItem2ExistsInBasket); },
                () -> { assertEquals(basketMap.get(item), 2); },
                () -> { assertEquals(basketItems.size(), 2); }
        );
    }

    private List<Item> generateItemForBusket() {
        return List.of(
                new PastryDto(1L, "abcr", "All Butter Croissant",0.75),
                new PastryDto(2L, "ccr", "Chocolate Croissant", 0.95),
                new PastryDto(3L, "b", "Fresh Baguette",1.6)
        );
    }
}