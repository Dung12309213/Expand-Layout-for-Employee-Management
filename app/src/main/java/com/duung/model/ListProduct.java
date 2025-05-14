package com.duung.model;

import java.util.ArrayList;
import java.util.List;

public class ListProduct {
    private List<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void generate_sample_dataset() {
        products.add(new Product(1, "Vitamin C Serum", "Brightening & anti-aging", 15.99, "https://example.com/vitaminc.jpg"));
        products.add(new Product(2, "Moisturizing Cream", "Hydrating face cream", 12.50, "https://example.com/moisture.jpg"));
        products.add(new Product(3, "Lipstick Matte Red", "Long-lasting color", 9.99, "https://example.com/lipstick.jpg"));
        products.add(new Product(4, "Shampoo Herbal", "Hair care solution", 8.75, "https://example.com/shampoo.jpg"));
        products.add(new Product(5, "Perfume Floral", "Fragrance for women", 29.90, "https://example.com/perfume.jpg"));
    }
}
