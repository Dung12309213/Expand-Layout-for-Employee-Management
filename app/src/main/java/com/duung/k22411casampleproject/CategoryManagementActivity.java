package com.duung.k22411casampleproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.duung.model.Category;
import com.duung.model.ListCategory;

public class CategoryManagementActivity extends AppCompatActivity {
    ListView lvCategory;
    ArrayAdapter<Category> Adapter;
    ListCategory lcate = new ListCategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_management);
        addViews();  //

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        lvCategory = findViewById(R.id.lvCategory);

        Adapter = new ArrayAdapter<>(
                CategoryManagementActivity.this,
                android.R.layout.simple_list_item_1);

        lcate.generateDataset();
        Adapter.addAll(lcate.getCategories());
        lvCategory.setAdapter(Adapter);
    }
}
