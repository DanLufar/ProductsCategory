package app;

public class Product {

    public String name;
    public String category;
    public double price;

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, String category, double price){
       this.name = name;
       this.category = category;
       this.price = price;
   }
}
