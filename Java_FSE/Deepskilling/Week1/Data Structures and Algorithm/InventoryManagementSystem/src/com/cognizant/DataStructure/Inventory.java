package com.cognizant.DataStructure;

import java.util.HashMap;

public class Inventory {

    HashMap<Integer, Product> products =
            new HashMap<>();

    public void addProduct(Product product) {

        products.put(product.getProductId(),
                product);
    }

    public void updateProduct(int id,
                              int quantity,
                              double price) {

        Product p = products.get(id);

        if(p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
        }
    }

    public void deleteProduct(int id) {

        products.remove(id);
    }

    public void displayProducts() {

        for(Product p : products.values()) {
            System.out.println(p);
        }
    }
}