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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.duung.model.Customer;
import com.duung.model.ListCustomer;

public class CustomerManagementActivity extends AppCompatActivity {
    ListView lvCustomer;
    ArrayAdapter<Customer> Adapter;
    ListCustomer lc = new ListCustomer();

    final int ID_CREATE_NEW_CUSTOMER = 1;
    final int ID_UPDATE_CUSTOMER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvent();
    }

    private void addViews() {
        lvCustomer = findViewById(R.id.lvCustomer);
        Adapter = new ArrayAdapter<>(
                CustomerManagementActivity.this,
                android.R.layout.simple_list_item_1);

        lc.generate_sample_dataset();
        Adapter.addAll(lc.getCustomers());
        lvCustomer.setAdapter(Adapter);
    }

    private void addEvent() {
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customer c = Adapter.getItem(position);
                OpenCustomerDetailActivity(c);
            }
        });
    }

    private void OpenCustomerDetailActivity(Customer c) {
        Intent intent = new Intent(CustomerManagementActivity.this,
                CustomerDetail.class);
        intent.putExtra("SELECTED_CUSTOMER", c);
        startActivityForResult(intent, ID_UPDATE_CUSTOMER);
    }

    private void openNewCustomerActivity() {
        Intent intent = new Intent(CustomerManagementActivity.this,
                CustomerDetail.class);
        startActivityForResult(intent, ID_CREATE_NEW_CUSTOMER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_new_customer) {
            Toast.makeText(CustomerManagementActivity.this,
                    "Mở màn hình thêm khách hàng mới", Toast.LENGTH_LONG).show();
            openNewCustomerActivity();
        } else if (item.getItemId() == R.id.menu_ads) {
            Toast.makeText(CustomerManagementActivity.this,
                    "Bắn tia quảng cáo tới hàng loạt khách hàng", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.menu_help) {
            Toast.makeText(CustomerManagementActivity.this,
                    "Chuyển tới màn hình hỗ trợ", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1 && data != null) { // 1 = RESULT_OK cho save
            Customer c = (Customer) data.getSerializableExtra("NEW_CUSTOMER");
            if (requestCode == ID_CREATE_NEW_CUSTOMER) {
                process_save_customer(c); // dùng hàm riêng
            } else if (requestCode == ID_UPDATE_CUSTOMER) {
                Toast.makeText(this, "Đã cập nhật thông tin khách hàng", Toast.LENGTH_SHORT).show();
                Adapter.notifyDataSetChanged(); // đơn giản hoá, nếu cần update đúng thì code thêm
            }
        } else if (resultCode == 2 && data != null) { // 2 = RESULT_OK cho delete
            int removeId = data.getIntExtra("REMOVE_CUSTOMER_ID", -1);
            if (removeId != -1) {
                for (Customer cust : lc.getCustomers()) {
                    if (cust.getId() == removeId) {
                        lc.getCustomers().remove(cust);
                        Adapter.clear();
                        Adapter.addAll(lc.getCustomers());
                        Toast.makeText(this, "Đã xoá khách hàng", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        }
    }

    private void process_save_customer(Customer c) {
        if (lc.isExisting(c)) {
            Toast.makeText(this, "Khách hàng đã tồn tại!", Toast.LENGTH_SHORT).show();
            return;
        }

        lc.addCustomer(c);
        Adapter.clear();
        Adapter.addAll(lc.getCustomers());
        Toast.makeText(this, "Thêm khách hàng thành công", Toast.LENGTH_SHORT).show();
    }
}
