package com.duung.model;

import java.util.ArrayList;
import java.util.List;

public class ListCategory {
    private List<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void generate_sample_dataset() {
        Category c1 = new Category();
        c1.setId(1);
        c1.setName("Skincare");
        c1.setDescription("Products for facial cleansing, moisturizing, and sun protection.");
        c1.setImageUrl("https://example.com/skincare.jpg");
        categories.add(c1);

        Category c2 = new Category();
        c2.setId(2);
        c2.setName("Makeup");
        c2.setDescription("Beauty products such as foundation, lipstick, and mascara.");
        c2.setImageUrl("https://example.com/makeup.jpg");
        categories.add(c2);

        Category c3 = new Category();
        c3.setId(3);
        c3.setName("Haircare");
        c3.setDescription("Shampoos, conditioners, and treatments for healthy hair.");
        c3.setImageUrl("https://example.com/haircare.jpg");
        categories.add(c3);

        Category c4 = new Category();
        c4.setId(4);
        c4.setName("Bodycare");
        c4.setDescription("Lotions, body wash, and scrubs for skin nourishment.");
        c4.setImageUrl("https://example.com/bodycare.jpg");
        categories.add(c4);

        Category c5 = new Category();
        c5.setId(5);
        c5.setName("Fragrances");
        c5.setDescription("Perfumes and body mists for men and women.");
        c5.setImageUrl("https://example.com/fragrances.jpg");
        categories.add(c5);
    }
}
