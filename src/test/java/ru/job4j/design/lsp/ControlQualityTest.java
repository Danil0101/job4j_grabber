package ru.job4j.design.lsp;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.design.lsp.model.Bread;
import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.store.Shop;
import ru.job4j.design.lsp.store.Trash;
import ru.job4j.design.lsp.store.Warehouse;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        ControlQuality.setToday(LocalDate.of(2022, 1, 10));
    }

    @Test
    public void whenExpirationLess25ThenSendToWarehouse() {
        Food bread = new Bread("bread",
                LocalDate.of(2022, 1, 9),
                LocalDate.of(2022, 1, 15), 50, 5);
        ControlQuality.redistributeFood(bread);
        assertTrue(ControlQuality.getStore(bread) instanceof Warehouse);
    }

    @Test
    public void whenExpirationMore25AndLess75ThenSendToShop() {
        Food bread = new Bread("bread",
                LocalDate.of(2022, 1, 9),
                LocalDate.of(2022, 1, 11), 50, 5);
        ControlQuality.redistributeFood(bread);
        assertTrue(ControlQuality.getStore(bread) instanceof Shop);
    }

    @Test
    public void whenExpirationMore75ThenSendToShopAndNewPrice() {
        Food bread = new Bread("bread",
                LocalDate.of(2022, 1, 6),
                LocalDate.of(2022, 1, 11), 50, 5);
        ControlQuality.redistributeFood(bread);
        assertTrue(ControlQuality.getStore(bread) instanceof Shop);
        assertThat(bread.getPrice(), is(47.5));
    }

    @Test
    public void whenExpirationHasPassedThenSendToTrash() {
        Food bread = new Bread("bread",
                LocalDate.of(2022, 1, 6),
                LocalDate.of(2022, 1, 9), 50, 5);
        ControlQuality.redistributeFood(bread);
        assertTrue(ControlQuality.getStore(bread) instanceof Trash);
    }
}