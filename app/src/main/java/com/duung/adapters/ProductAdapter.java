package com.duung.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.duung.model.Product;
import com.duung.k22411casampleproject.R;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity context;
    int resource;
    List<Product> productList;

    public ProductAdapter(Activity context, int resource, List<Product> productList) {
        super(context, resource, productList);
        this.context = context;
        this.resource = resource;
        this.productList = productList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(resource, null);

        TextView txtName = row.findViewById(R.id.edtProductName);
        TextView txtDesc = row.findViewById(R.id.edtProductDesc);

        Product p = productList.get(position);
        txtName.setText(p.getName());
        txtDesc.setText(p.getDescription());

        return row;
    }
}
