package model;

import java.util.Scanner;

public class ShoppingCart {
    private static int count = 1;
    private int shoppingCartID;
    private int productID;
    private int userID;
    private int orderQuantity;

    public ShoppingCart() {
    }

    public ShoppingCart(int shoppingCartID, int productID, int userID, int orderQuantity) {
        this.shoppingCartID = shoppingCartID;
        this.productID = productID;
        this.userID = userID;
        this.orderQuantity = orderQuantity;
    }

    public int getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void dataShoppingCart(int productID,int userID,int orderQuantity) {
        this.shoppingCartID = count++;
        this.productID = productID;
        this.userID = userID;
        this.orderQuantity = orderQuantity;
    }
}
