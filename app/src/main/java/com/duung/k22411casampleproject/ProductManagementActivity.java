package com.duung.k22411casampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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

        listCategory.generateDataset();

        addViews();
        addEvents();
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        lvProduct = findViewById(R.id.lvProduct);


        categoryAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listCategory.getCategories()
        );
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);


        productAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>()
        );
        lvProduct.setAdapter(productAdapter);
    }

    private void addEvents() {
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
    }
}
