/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;
import java.util.HashMap;
/**
 *
 * @author DELL
 */
public class CartP {
    HashMap<String,Integer> cartItems;
    
    public CartP(){
        cartItems = new HashMap<>();
    }
    
    public HashMap getCartItems(){
            return cartItems;
    }
    
    public void addToCart(String pname,int price ){
    
    cartItems.put(pname, price);
    
    }
    
    public void deleteFromCart(String pname){
        cartItems.remove(pname);
    }
}
