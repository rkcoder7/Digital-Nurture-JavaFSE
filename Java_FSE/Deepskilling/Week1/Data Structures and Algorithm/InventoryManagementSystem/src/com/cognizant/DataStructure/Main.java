package com.cognizant.DataStructure;

public class Main {

    public static void main(String[] args) {

        Inventory inventory =
                new Inventory();

        inventory.addProduct(
                new Product(101,
                        "Laptop",
                        10,
                        50000));

        inventory.addProduct(
                new Product(102,
                        "Mouse",
                        50,
                        500));

        inventory.displayProducts();

        inventory.updateProduct(
                101,
                15,
                52000);

        System.out.println("\nAfter Update");

        inventory.displayProducts();

        inventory.deleteProduct(102);

        System.out.println("\nAfter Delete");

        inventory.displayProducts();
    }
}
