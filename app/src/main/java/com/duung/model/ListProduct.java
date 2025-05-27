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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void generate_sample_product() {
        products.add(new Product(1, "Facial Cleanser", "Sữa rửa mặt dịu nhẹ", 150000, "https://example.com/images/facial_cleanser.jpg"));
        products.add(new Product(2, "Moisturizer", "Kem dưỡng ẩm ban đêm", 250000, "https://example.com/images/moisturizer.jpg"));
        products.add(new Product(3, "Sunscreen", "Kem chống nắng SPF 50+", 199000, "https://example.com/images/sunscreen.jpg"));
        products.add(new Product(4, "Foundation", "Kem nền lâu trôi", 320000, "https://example.com/images/foundation.jpg"));
        products.add(new Product(5, "Lipstick", "Son đỏ lì", 180000, "https://example.com/images/lipstick.jpg"));
        products.add(new Product(6, "Mascara", "Mascara chống lem", 210000, "https://example.com/images/mascara.jpg"));
        products.add(new Product(7, "Shampoo", "Dầu gội phục hồi", 130000, "https://example.com/images/shampoo.jpg"));
        products.add(new Product(8, "Conditioner", "Dầu xả mềm mượt", 145000, "https://example.com/images/conditioner.jpg"));
        products.add(new Product(9, "Hair Serum", "Tinh dầu dưỡng tóc", 270000, "https://example.com/images/hair_serum.jpg"));
        products.add(new Product(10, "Body Wash", "Sữa tắm trắng da", 160000, "https://example.com/images/body_wash.jpg"));
        products.add(new Product(11, "Body Lotion", "Lotion dưỡng thể", 200000, "https://example.com/images/body_lotion.jpg"));
        products.add(new Product(12, "Body Scrub", "Tẩy tế bào chết toàn thân", 190000, "https://example.com/images/body_scrub.jpg"));
        products.add(new Product(13, "Perfume A", "Nước hoa nữ dịu nhẹ", 890000, "https://example.com/images/perfume_a.jpg"));
        products.add(new Product(14, "Perfume B", "Nước hoa nam mạnh mẽ", 990000, "https://example.com/images/perfume_b.jpg"));
        products.add(new Product(15, "Body Mist", "Xịt thơm toàn thân", 350000, "https://example.com/images/body_mist.jpg"));
    }
}
