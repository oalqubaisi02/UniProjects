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
public interface IProductService {
    List<Product> getAllProducts();
    void writeProducts(List<Product> products);
    List<Product> search(String productName,List<Product> products);
    
}
