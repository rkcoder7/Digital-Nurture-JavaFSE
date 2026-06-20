package com.cognizant.DataStructure;

public class SearchDemo {

    public static Product binarySearch(
            Product[] products,
            String name) {

        int low = 0;
        int high = products.length - 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            int result =
                    products[mid].productName
                            .compareToIgnoreCase(name);

            if(result == 0)
                return products[mid];

            else if(result < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101,"Laptop","Electronics"),
                new Product(102,"Mobile","Electronics"),
                new Product(103,"Mouse","Accessories"),
                new Product(104,"Printer","Electronics")
        };

        Product result =
                binarySearch(products,"Mouse");

        if(result != null)
            System.out.println("Found: " + result);
        else
            System.out.println("Not Found");
    }
}