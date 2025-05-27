package com.duung.k22411casampleproject;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.duung.k22411casampleproject.R;
import com.duung.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    EditText edtProductID, edtProductName, edtProductDesc, edtProductPrice, edtProductLink, edtProductQuantity, edtProductCateID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);

        // Connect UI components
        edtProductID = findViewById(R.id.edtProductID);
        edtProductName = findViewById(R.id.edtProductName);
        edtProductDesc = findViewById(R.id.edtProductDesc);
        edtProductPrice = findViewById(R.id.edtProductPrice);
        edtProductLink = findViewById(R.id.edtProductLink);
        edtProductQuantity = findViewById(R.id.edtProductQuantity);
        edtProductCateID = findViewById(R.id.edtProductCateID);

        // Get product from intent
        Product product = (Product) getIntent().getSerializableExtra("product");

        // Show product info
        if (product != null) {
            edtProductID.setText(String.valueOf(product.getId()));
            edtProductName.setText(product.getName());
            edtProductDesc.setText(product.getDescription());
            edtProductPrice.setText(String.valueOf(product.getPrice()));
            edtProductLink.setText(product.getImageUrl());
            edtProductQuantity.setText(String.valueOf(product.getQuantity()));
            edtProductCateID.setText(String.valueOf(product.getCateid()));
        }

        // Optionally: disable all EditTexts to make them read-only
        edtProductID.setEnabled(false);
        edtProductName.setEnabled(false);
        edtProductDesc.setEnabled(false);
        edtProductPrice.setEnabled(false);
        edtProductLink.setEnabled(false);
        edtProductQuantity.setEnabled(false);
        edtProductCateID.setEnabled(false);
    }
}
