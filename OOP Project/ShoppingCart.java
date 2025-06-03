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
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public void removeItem(Product item) {
        items.remove(item);
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Product item : items) {
            totalQuantity += item.getQuantityAvailable();
        }
        return totalQuantity;
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (Product item : items) {
            totalCost += item.getPrice() * item.getQuantityAvailable();
        }
        return totalCost;
    }

    public String displayCart() {
        String outPut = "";
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Items in your shopping cart:");
            for (Product item : items) {
                System.out.println(item.getName() + " -> $" + item.getPrice() + " x " + item.getQuantityAvailable());
                outPut = outPut + item.getName() + " -> $" + item.getPrice() + " x " + item.getQuantityAvailable() + "\n";
            }
            System.out.println("Total cost: $" + getTotalCost());
            outPut = outPut + "\nTotal cost: $" + getTotalCost();
        }
        return outPut;
    }
}
