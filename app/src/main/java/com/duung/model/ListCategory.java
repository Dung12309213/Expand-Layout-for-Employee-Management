package com.duung.model;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void generateDataset() {
        // Danh mục 1: Skincare
        Category c1 = new Category(1, "Skincare", 0);
        c1.setDescription("Products for facial cleansing, moisturizing, and sun protection.");
        c1.addProduct(new Product(1, "Facial Cleanser", "Sữa rửa mặt dịu nhẹ", 150000, "https://example.com/images/facial_cleanser.jpg"));
        c1.addProduct(new Product(2, "Moisturizer", "Kem dưỡng ẩm ban đêm", 250000, "https://example.com/images/moisturizer.jpg"));
        c1.addProduct(new Product(3, "Sunscreen", "Kem chống nắng SPF 50+", 199000, "https://example.com/images/sunscreen.jpg"));
        categories.add(c1);

        // Danh mục 2: Makeup
        Category c2 = new Category(2, "Makeup", 0);
        c2.setDescription("Beauty products such as foundation, lipstick, and mascara.");
        c2.addProduct(new Product(4, "Foundation", "Kem nền lâu trôi", 320000, "https://example.com/images/foundation.jpg"));
        c2.addProduct(new Product(5, "Lipstick", "Son đỏ lì", 180000, "https://example.com/images/lipstick.jpg"));
        c2.addProduct(new Product(6, "Mascara", "Mascara chống lem", 210000, "https://example.com/images/mascara.jpg"));
        categories.add(c2);

        // Danh mục 3: Haircare
        Category c3 = new Category(3, "Haircare", 0);
        c3.setDescription("Shampoos, conditioners, and treatments for healthy hair.");
        c3.addProduct(new Product(7, "Shampoo", "Dầu gội phục hồi", 130000, "https://example.com/images/shampoo.jpg"));
        c3.addProduct(new Product(8, "Conditioner", "Dầu xả mềm mượt", 145000, "https://example.com/images/conditioner.jpg"));
        c3.addProduct(new Product(9, "Hair Serum", "Tinh dầu dưỡng tóc", 270000, "https://example.com/images/hair_serum.jpg"));
        categories.add(c3);

        // Danh mục 4: Bodycare
        Category c4 = new Category(4, "Bodycare", 0);
        c4.setDescription("Lotions, body wash, and scrubs for skin nourishment.");
        c4.addProduct(new Product(10, "Body Wash", "Sữa tắm trắng da", 160000, "https://example.com/images/body_wash.jpg"));
        c4.addProduct(new Product(11, "Body Lotion", "Lotion dưỡng thể", 200000, "https://example.com/images/body_lotion.jpg"));
        c4.addProduct(new Product(12, "Body Scrub", "Tẩy tế bào chết toàn thân", 190000, "https://example.com/images/body_scrub.jpg"));
        categories.add(c4);

        // Danh mục 5: Fragrances
        Category c5 = new Category(5, "Fragrances", 0);
        c5.setDescription("Perfumes and body mists for men and women.");
        c5.addProduct(new Product(13, "Perfume A", "Nước hoa nữ dịu nhẹ", 890000, "https://example.com/images/perfume_a.jpg"));
        c5.addProduct(new Product(14, "Perfume B", "Nước hoa nam mạnh mẽ", 990000, "https://example.com/images/perfume_b.jpg"));
        c5.addProduct(new Product(15, "Body Mist", "Xịt thơm toàn thân", 350000, "https://example.com/images/body_mist.jpg"));
        categories.add(c5);
    }
}
