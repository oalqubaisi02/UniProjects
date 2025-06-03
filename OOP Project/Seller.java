/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

import java.util.List;

/**
 *
 * @author HP
 */
public class Seller extends User{
    
    private List<Product> products;

    public Seller(int id, String name, String email, String address) {
        super(id, name, email, address);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }


    @Override
    public void displayInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
