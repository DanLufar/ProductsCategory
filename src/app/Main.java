package app;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Orange", "Fruit", 1.56),
                new Product("Banana", "Fruit", 1.78),
                new Product("Kiwi", "Fruit", 2.00),
                new Product("Cabbage", "Vegetables", 0.56),
                new Product("Onion", "Vegetables", 0.23),
                new Product("Tomato", "Vegetables", 1.00),
                new Product("Cherry", "Berries", 1.24),
                new Product("Strawberry", "Berries", 1.76),
                new Product("Raspberry", "Berries", 1.67),
                new Product("Beef", "Meet", 2.56),
                new Product("Pork", "Meet", 2.45)
        );

        Map<String, Double> result = products.stream()
                .filter(map -> "Fruit".equals(map.getCategory()))
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getPrice));

        System.out.println("Products category:");
        System.out.println("- " + "Fruit" + ":");
        result.forEach((name, price) -> System.out.println("    * " + name + " - " + price));

        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));


        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));


        Map.Entry<String, Double> maxAverageCategory = averagePriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("Exception"));


        System.out.println("\nCategories all products:");
        grouped.forEach((category, productsList) -> {
            System.out.println("- " + category + ":");
            productsList.forEach(product ->
                    System.out.println("    * " + product.getName() + " - " + product.getPrice() + " USD")
            );
        });

        System.out.println("\nAverage price of products by category:");
        averagePriceByCategory.forEach((category, avgPrice) -> {
            System.out.printf("%s: %.2f%n", category, avgPrice);
        });

        System.out.println("\nCategory with the highest average price:");
        System.out.printf("%s -> %.2f%n", maxAverageCategory.getKey(), maxAverageCategory.getValue());
    }

}

