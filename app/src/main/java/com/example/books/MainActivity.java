package com.example.books;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Book> list;
    RecyclerViewAdabter adabter;
    RecyclerView recyclerView;
    Cursor cr;
    SqlConnection sqlConnection = new SqlConnection(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcyclerview_id);
        list = new ArrayList<>();
        cr = sqlConnection.showData();
        cr.moveToFirst();
        while(cr.isAfterLast() == false){
            list.add(new Book(cr.getString(1),"category",cr.getString(2),R.drawable.privacy));
            cr.moveToNext();
        }



        adabter = new RecyclerViewAdabter(this,list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adabter);
    }

}
