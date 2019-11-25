package com.example.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView title,desc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title = findViewById(R.id.title_id);
        desc = findViewById(R.id.desc_id);
        img = findViewById(R.id.img_id);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("title");
        String description = intent.getExtras().getString("decription");
        int image = intent.getExtras().getInt("thumbnail");

        title.setText(name);
        desc.setText(description);
        img.setImageResource(image);
        img.setClipToOutline(true);

    }
}
