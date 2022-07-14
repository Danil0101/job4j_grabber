package ru.job4j.design.lsp.store;

public interface Store {
    Store SHOP = new Shop();
    Store WAREHOUSE = new Warehouse();
    Store TRASH = new Trash();

    static Store getShop() {
        return SHOP;
    }

    static Store getWarehouse() {
        return WAREHOUSE;
    }

    static Store getTrash() {
        return TRASH;
    }
}
