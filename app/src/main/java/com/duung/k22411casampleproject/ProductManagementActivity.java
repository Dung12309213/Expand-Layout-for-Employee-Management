package com.duung.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    final int ID_CREATE_PRODUCT = 1;
    final int ID_UPDATE_PRODUCT = 2;

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

        lvProduct.setOnItemClickListener((parent, view, position, id) -> {
            Product p = productAdapter.getItem(position);
            openProductDetailActivity(p);
        });
    }

    private void openProductDetailActivity(Product p) {
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", p);
        startActivityForResult(intent, ID_UPDATE_PRODUCT);
    }

    private void openNewProductActivity() {
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        startActivityForResult(intent, ID_CREATE_PRODUCT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_new_product) {
            Toast.makeText(this, "Mở màn hình thêm sản phẩm mới", Toast.LENGTH_SHORT).show();
            openNewProductActivity();
        } else if (item.getItemId() == R.id.menu_promote_product) {
            Toast.makeText(this, "Chạy chương trình quảng bá sản phẩm", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_product_help) {
            Toast.makeText(this, "Mở trang hướng dẫn sản phẩm", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1 && data != null) {
            Product p = (Product) data.getSerializableExtra("NEW_PRODUCT");
            if (requestCode == ID_CREATE_PRODUCT) {
                processSaveProduct(p);
            } else if (requestCode == ID_UPDATE_PRODUCT) {
                Toast.makeText(this, "Cập nhật thông tin sản phẩm thành công", Toast.LENGTH_SHORT).show();
                productAdapter.notifyDataSetChanged();
            }
        } else if (resultCode == 2 && data != null) {
            int removeId = data.getIntExtra("REMOVE_PRODUCT_ID", -1);
            for (Category c : listCategory.getCategories()) {
                Product toRemove = null;
                for (Product p : c.getProducts()) {
                    if (p.getId() == removeId) {
                        toRemove = p;
                        break;
                    }
                }
                if (toRemove != null) {
                    c.getProducts().remove(toRemove);
                    productAdapter.clear();
                    productAdapter.addAll(c.getProducts());
                    Toast.makeText(this, "Đã xoá sản phẩm", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    private void processSaveProduct(Product p) {
        Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
        if (selectedCategory == null) return;

        for (Product prod : selectedCategory.getProducts()) {
            if (prod.getId() == p.getId()) {
                Toast.makeText(this, "Sản phẩm đã tồn tại!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        selectedCategory.addProduct(p);
        productAdapter.clear();
        productAdapter.addAll(selectedCategory.getProducts());
        Toast.makeText(this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
    }
}
