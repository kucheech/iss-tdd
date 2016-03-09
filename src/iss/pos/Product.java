package iss.pos;

public class Product {

    private String name;
    private String sku;
    private double price;

    public Product(String sku, String name, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    public Boolean hasSameStyle(Product another) {
        return this.getStyle().equalsIgnoreCase(another.getStyle());
    }
    
    public String getStyle() {
        return sku.substring(0,4);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
