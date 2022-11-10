package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
 * As a support for a visual description of streams, the following
 * exercise will be implemented:
 *
 * Create a Product class:
 * - amount
 * - currentPrice
 * - previousPrices
 * ^ (Map<String, List<Double>> with keys:"recommendedPrices" and "actualPrices")
 * - name
 *
 * a) Validate the currentPrice, amount and previousPrices to be positive numbers
 * and the recommendedPrices and actualPrices to exist and have same lengths
 * b) Create a list of products and print it
 * c) Extract a list with products that are over a specified price
 * d) Print products on discount (below their average price over time)
 * e) Print the products that have the most changes of price over time
 * f) Print the total price of the list
 */

public class Main {
    public static void main(String args[]) {
        try {
            // b) Create a list of products and print it
            List<Product> products = createProductArrayList();
            System.out.println("Stored products:");
            printProductArrayList(products);

            // c) Extract a list with products that are over a specified price
            double specifiedPrice = 39.99;
            System.out.println("\nProducts over " + specifiedPrice + ":");
            printProductArrayList(extractProductsOver(products, specifiedPrice));

            // d) Create a method to check if a product is below it's average
            // price over time
            System.out.println("\nThe following products are on discount:");
            printDiscountProductsList(products);

            // e) Print the products that have the most changes of price over time
            System.out.println("\nThe products with the most changes of price:");
            printProductsWithMostChangesOfPrice(products);

            // f) Print the total price of the list
            System.out.println("\nThe total price of the list is:");
            printTotalPriceOfProductsList(products);
        } catch (ProductException e) {
            e.printStackTrace();
        }
    }

    private static void printTotalPriceOfProductsList(List<Product> products) {
        double totalSum = products.stream().mapToDouble(product -> product.amount * product.currentPrice).sum();
        System.out.println(totalSum);
    }

    private static void printProductsWithMostChangesOfPrice(List<Product> products) {
        int theMostChangesOfPrice = products.stream()
                .max(Comparator.comparing(product -> product.getPreviousPricesLength())).get()
                .getPreviousPricesLength();
        products.stream().filter(product -> product.getPreviousPricesLength() == theMostChangesOfPrice)
                .forEach(System.out::println);
        ;
    }

    private static void printDiscountProductsList(List<Product> products) {
        products.stream().filter(product -> product.isProductBelowAveragePrice())
                .forEach(discountedProduct -> System.out.println(discountedProduct));
    }

    private static ArrayList<Product> extractProductsOver(List<Product> products, double specifiedPrice) {
        return products.stream().filter(product -> product.currentPrice > specifiedPrice)
                .collect(Collectors.toCollection(ArrayList<Product>::new));
    }

    private static void printProductArrayList(List<Product> products) {
        products.stream().forEach(product -> System.out.println(product));
    }

    private static List<Product> createProductArrayList() throws ProductException {
        return new ArrayList<Product>(List.of(new Product(40, 30.99, new HashMap<String, List<Double>>() {
            {
                put("actualPrices", new ArrayList<Double>(List.of(31.99, 31.59, 30.59)));
                put("recommendedPrices", new ArrayList<Double>(List.of(31.59, 31.59, 30.0)));
            }
        }, "Wireless Mouse"), new Product(20, 50.99, new HashMap<String, List<Double>>() {
            {
                put("actualPrices", new ArrayList<Double>(List.of(59.49, 59.99, 55.49)));
                put("recommendedPrices", new ArrayList<Double>(List.of(59.0, 59.49, 55.0)));
            }
        }, "Wired Keyboard"), new Product(40, 30.99, new HashMap<String, List<Double>>() {
            {
                put("actualPrices", new ArrayList<Double>(List.of(31.99, 31.59)));
                put("recommendedPrices", new ArrayList<Double>(List.of(31.49, 31.49)));
            }
        }, "PC Case"), new Product(15, 115.0, new HashMap<String, List<Double>>() {
            {
                put("actualPrices", new ArrayList<Double>(List.of(110.0, 105.0, 120.0)));
                put("recommendedPrices", new ArrayList<Double>(List.of(110.0, 105.0, 120.0)));
            }
        }, "Headphones"), new Product(1000, 7.49, new HashMap<String, List<Double>>() {
            {
                put("actualPrices", new ArrayList<Double>(List.of(6.49, 7.99, 6.49, 4.49, 6.49)));
                put("recommendedPrices", new ArrayList<Double>(List.of(6.0, 7.49, 6.49, 4.0, 6.0)));
            }
        }, "Phone Case"), new Product(800, 7.0, new HashMap<String, List<Double>>() {
            {
                put("actualPrices", new ArrayList<Double>(List.of(5.49, 6.99, 5.49, 4.49, 5.49)));
                put("recommendedPrices", new ArrayList<Double>(List.of(5.0, 6.49, 5.49, 4.0, 5.0)));
            }
        }, "Phone Screen Protector")));
    }
}