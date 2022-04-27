/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Lynn Wei
 */
public class Order {
    
    ArrayList<OrderItem>orderItemList;
    
    public Order(){
        
        this.orderItemList = new ArrayList<OrderItem>();
    
}

    public ArrayList<OrderItem>getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
     public void addNewOrderItem(Product product, double price, int quantity){
      OrderItem orderItem = new OrderItem(product, price, quantity);
      orderItemList.add(orderItem);     
    }    
}
    
