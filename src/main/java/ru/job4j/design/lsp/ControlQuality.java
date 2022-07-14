package ru.job4j.design.lsp;

import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.store.Store;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ControlQuality {
    private static final Map<Food, Store> FOODS = new HashMap<>();

    private static LocalDate today = LocalDate.now();

    public static void redistributeFood(Food food) {
        int bestBeforeDate = food.getExpiryDate().compareTo(food.getCreateDate());
        int remainingShelfLife = food.getExpiryDate().compareTo(today);
        int remainingShelfLifePercent = 100 - (int) ((double) remainingShelfLife / bestBeforeDate * 100);
        if (remainingShelfLife < 0) {
            FOODS.put(food, Store.getTrash());
        } else if (remainingShelfLifePercent < 25) {
            FOODS.put(food, Store.getWarehouse());
        } else if (remainingShelfLifePercent <= 75) {
            FOODS.put(food, Store.getShop());
        } else {
            double newPrice = food.getPrice() - food.getPrice() / 100 * food.getDiscount();
            food.setPrice(newPrice);
            FOODS.put(food, Store.getShop());
        }
    }

    public static Store getStore(Food food) {
        return FOODS.get(food);
    }

    public static void setToday(LocalDate date) {
        today = date;
    }
}
