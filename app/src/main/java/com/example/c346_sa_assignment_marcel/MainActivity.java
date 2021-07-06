package com.example.c346_sa_assignment_marcel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView description;
    Button link;
    Button Item_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description=findViewById(R.id.description);
        link=findViewById(R.id.link);
        Item_link=findViewById(R.id.Item_link);


        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent();
                a.setAction(Intent.ACTION_VIEW);
                a.addCategory(Intent.CATEGORY_BROWSABLE);
                a.setData(Uri.parse("https://github.com/opshet?tab=repositories"));
                startActivity(a);

            }
        });

        Item_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, ItemListActivity.class );
                startActivity(a);

            }
        });




    }
}