/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

/**
 *
 * @author HP
 */
public class Product {

    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantityAvailable;
    
    public Product(){}

    public Product(int productId, String name, String description, double price, int quantityAvailable) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    // Other methods
    public void decreaseQuantity(int quantity) throws OutOfStockException {
        if (quantityAvailable >= quantity) {
            quantityAvailable -= quantity;
        } else {
            throw new OutOfStockException("Insufficient quantity available.");
        }
    }

    public void increaseQuantity(int quantity) {
        quantityAvailable += quantity;
    }
}
