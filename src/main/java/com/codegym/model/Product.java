package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String detail;
    private String category;
    private int amount;

    public Product() {
    }

    public Product(int id, String name, String detail, String category, int amount) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.category = category;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
