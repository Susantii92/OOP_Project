package com.models;

public class Produk {
    private int id;
    private String name;
    private long price;
    private int stock;

    public Produk(int id, String name, long price, int stock ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public long getprice() {
        return price;
    }
    public void setprice(long price) {
        this.price = price;
    }

    public int getstock() {
        return stock;
    }
    public void setstock(int stock) {
        this.stock = stock;
    }
}