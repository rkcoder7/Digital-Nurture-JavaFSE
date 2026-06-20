package com.cognizant.DataStructure;

public class LibrarySearch {

    public static Book linearSearch(
            Book[] books,
            String title) {

        for(Book b : books) {

            if(b.title.equalsIgnoreCase(title))
                return b;
        }

        return null;
    }

    public static Book binarySearch(
            Book[] books,
            String title) {

        int low = 0;
        int high = books.length - 1;

        while(low <= high) {

            int mid = (low + high)/2;

            int result =
                    books[mid].title
                            .compareToIgnoreCase(title);

            if(result == 0)
                return books[mid];

            if(result < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {

                new Book(
                        1,
                        "C",
                        "Dennis"),

                new Book(
                        2,
                        "Java",
                        "James"),

                new Book(
                        3,
                        "Python",
                        "Guido")
        };

        Book result =
                binarySearch(
                        books,
                        "Java");

        System.out.println(result);
    }
}