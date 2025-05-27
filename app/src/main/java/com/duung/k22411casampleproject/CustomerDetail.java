package com.duung.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.duung.model.Customer;

public class CustomerDetail extends AppCompatActivity {
    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_phone;
    EditText edt_customer_username;
    EditText edt_customer_password;

    Button btnNew;
    Button btnSave;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);  // <-- Sử dụng layout mới

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        edt_customer_id = findViewById(R.id.edtProductID);
        edt_customer_name = findViewById(R.id.edtProductName);
        edt_customer_email = findViewById(R.id.edtProductDesc);
        edt_customer_phone = findViewById(R.id.edtProductPrice);
        edt_customer_username = findViewById(R.id.edtProductLink);
        edt_customer_password = findViewById(R.id.edtProductCateID);

        btnNew = findViewById(R.id.btnNew);
        btnSave = findViewById(R.id.btnSave);
        btnRemove = findViewById(R.id.btnRemove);

        display_customer_details();
    }

    private void addEvents() {
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_new();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_save();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_remove();
            }
        });
    }

    private void display_customer_details() {
        Intent intent = getIntent();
        Customer c = (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");
        if (c == null) return;

        edt_customer_id.setText(String.valueOf(c.getId()));
        edt_customer_name.setText(c.getName());
        edt_customer_email.setText(c.getEmail());
        edt_customer_phone.setText(c.getPhone());
        edt_customer_username.setText(c.getUsername());
        edt_customer_password.setText(c.getPassword());
    }

    private void do_new() {
        // Xóa nội dung các trường nhập liệu để tạo mới
        clearFields();
    }

    private void do_remove() {
        // Gửi ID khách hàng về màn hình gọi để xử lý xoá
        int id = Integer.parseInt(edt_customer_id.getText().toString());
        Intent intent = getIntent();
        intent.putExtra("REMOVE_CUSTOMER_ID", id);
        setResult(2, intent);  // resultCode = 2 để phân biệt là hành động xoá
        finish();
    }

    private void do_save() {
        // Lưu thông tin khách hàng từ form
        Customer c = new Customer();
        c.setId(Integer.parseInt(edt_customer_id.getText().toString()));
        c.setName(edt_customer_name.getText().toString());
        c.setEmail(edt_customer_email.getText().toString());
        c.setPhone(edt_customer_phone.getText().toString());
        c.setUsername(edt_customer_username.getText().toString());
        c.setPassword(edt_customer_password.getText().toString());

        Intent intent = getIntent();
        intent.putExtra("NEW_CUSTOMER", c);
        setResult(1, intent);  // resultCode = 1 là hành động lưu
        finish();
    }

    private void clearFields() {
        edt_customer_id.setText("");
        edt_customer_name.setText("");
        edt_customer_email.setText("");
        edt_customer_phone.setText("");
        edt_customer_username.setText("");
        edt_customer_password.setText("");
    }
}