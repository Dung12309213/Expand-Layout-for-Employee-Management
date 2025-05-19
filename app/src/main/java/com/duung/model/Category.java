package com.duung.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private int image_id;
    private ArrayList<Product> products;


    public Category() {
        products = new ArrayList<>();
    }

    public Category(int id, String name, int image_id) {
        this.id = id;
        this.name = name;
        this.image_id = image_id;
        this.imageUrl = "";
        this.products = new ArrayList<>();
    }


    public Category(int id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.products = new ArrayList<>();
    }


    public Category(int id, String name, String description, String imageUrl, ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.products = products;
    }

    // Getter & Setter
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

    public String getDescription() {
        return description != null ? description : "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public ArrayList<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    public void removeProduct(int id) {
        Product p = null;
        for (Product item : products) {
            if (item.getId() == id) {
                p = item;
                break;
            }
        }
        if (p != null) {
            products.remove(p);
        }
    }

    @NonNull
    @Override
    public String toString() {
        return id + " - " + name + "\n" + (description != null ? description : "");
    }
}
