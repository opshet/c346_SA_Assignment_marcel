package com.example.c346_sa_assignment_marcel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    Button add_product;
    Button update_product;
    Button delete_product;
    EditText index;
    EditText product_name;
    EditText edate_of_product;

    ArrayList<String> product_list;

    ArrayList<String> date_list;

    ArrayList<String> combine_list;
    ArrayAdapter<String> combine_adapter;
    ListView lvtodo_combine_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        add_product = findViewById(R.id.add_product);
        update_product = findViewById(R.id.update_product);
        delete_product = findViewById(R.id.delete_product);

        index = findViewById(R.id.index);
        product_name = findViewById(R.id.product_name);
        edate_of_product = findViewById(R.id.edate_of_product);


        product_list = new ArrayList<>();
        product_list.add("Logi mouse");
        product_list.add("Logi keyboard");
        product_list.add("Logi screen");
        product_list.add("Logi usb");
        product_list.add("Logi charger");

        date_list = new ArrayList<>();
        date_list.add("2021-8-6");
        date_list.add("2022-8-6");
        date_list.add("2023-8-6");
        date_list.add("2024-8-6");
        date_list.add("2025-8-6");


        combine_list = new ArrayList<>();
        for (int i = 0; i < product_list.size(); i++) {
            combine_list.add("Expiers" + date_list.get(i) + " " + product_list.get(i));
            combine_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combine_list);
            lvtodo_combine_list.setAdapter(combine_adapter);
        }


        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_product = product_name.getText().toString();
                String new_date = edate_of_product.getText().toString();

                combine_list.add("Expiers" + date_list.add(new_date) + " " + product_list.add(new_product));
                combine_adapter.notifyDataSetChanged();
                edate_of_product.setText(null);
                product_name.setText(null);

                Collections.sort(combine_list, String.CASE_INSENSITIVE_ORDER);
            }
        });

        update_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < combine_list.size(); i++) {
                    if (combine_list.get(i).equals(index.getText().toString())) {

                        String new_product = product_name.getText().toString();
                        String new_date = edate_of_product.getText().toString();

                        combine_list.add("Expiers " + date_list.set(i, new_date) + " " + product_list.set(i, new_product));

                        product_name.setText(null);
                        edate_of_product.setText(null);

                    } else if (product_name.getText().toString().isEmpty() && (combine_list.get(i).equals(index.getText().toString()))) {
                        String new_date = edate_of_product.getText().toString();

                        String new_product = product_list.get(i);
                        product_list.set(i, new_product);


                        combine_list.add("Expiers " + date_list.set(i, new_date) + " " + product_list.set(i, new_product));
                        edate_of_product.setText(null);

                    } else if (edate_of_product.getText().toString().isEmpty() && (combine_list.get(i).equals(index.getText().toString()))) {
                        String new_product = product_name.getText().toString();

                        String new_date = date_list.get(i);
                        date_list.set(i, new_date);

                        combine_list.add("Expiers " + date_list.set(i, new_date) + " " + product_list.set(i, new_product));
                        product_name.setText(null);

                    } else {
                        Toast.makeText(ItemListActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                    }
                }
                Collections.sort(combine_list, String.CASE_INSENSITIVE_ORDER);
            }


        });

        delete_product.setOnClickListener(v -> {

            if (combine_list.size() == 0) {
                Toast.makeText(ItemListActivity.this, "You don't have any products to remove", Toast.LENGTH_SHORT).show();

            } else {
                int indexx = Integer.parseInt(index.getText().toString());
                if (combine_list.size() <= indexx) {
                    Toast.makeText(ItemListActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    combine_list.remove(indexx);
                    combine_adapter.notifyDataSetChanged();
                    index.setText(null);
                }

            }


        });





    }
}