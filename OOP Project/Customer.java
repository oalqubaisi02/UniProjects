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
public class Customer extends User {
    
    private ShoppingCart shoppingCart;

    public Customer(int id, String name, String email, String address,ShoppingCart shoppingCart) {
        super(id, name, email, address);
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void displayInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
