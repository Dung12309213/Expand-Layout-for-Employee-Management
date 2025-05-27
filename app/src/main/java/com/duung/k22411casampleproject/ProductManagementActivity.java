package com.duung.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.duung.model.Category;
import com.duung.model.ListCategory;
import com.duung.model.Product;

import java.util.ArrayList;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ListView lvProduct;

    ArrayAdapter<Category> categoryAdapter;
    ArrayAdapter<Product> productAdapter;

    ListCategory listCategory = new ListCategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);

        listCategory.generateDataset(); // Load sample categories + products

        addViews();
        addEvents();
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        lvProduct = findViewById(R.id.lvProduct);

        // Adapter for category spinner
        categoryAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listCategory.getCategories()
        );
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        // Adapter for product list
        productAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>()
        );
        lvProduct.setAdapter(productAdapter);
    }

    private void addEvents() {
        // Khi chọn category → load product
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = categoryAdapter.getItem(position);
                if (selectedCategory != null) {
                    productAdapter.clear();
                    productAdapter.addAll(selectedCategory.getProducts());
                    productAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                productAdapter.clear();
                productAdapter.notifyDataSetChanged();
            }
        });

        // Khi click vào sản phẩm → xem chi tiết
        lvProduct.setOnItemClickListener((parent, view, position, id) -> {
            Product selectedProduct = productAdapter.getItem(position);
            if (selectedProduct != null) {
                Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
                intent.putExtra("product", selectedProduct);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
