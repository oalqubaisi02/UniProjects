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
public class InvalidProductException extends Exception{
    
    private String message;
    
    public InvalidProductException(String message){
        this.message = message;
    }
    
}
