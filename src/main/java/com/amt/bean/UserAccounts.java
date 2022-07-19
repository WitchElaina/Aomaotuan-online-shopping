package com.amt.bean;

public class UserAccounts {
    private int uid;
    private String username;
    private String password;
    private String cart;

    public UserAccounts() {
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public UserAccounts(int uid, String username, String password, String cart) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
