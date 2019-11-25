package com.example.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class database extends AppCompatActivity {
    EditText title, desc, img, id;
    SqlConnection sqlConnection = new SqlConnection(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        title = findViewById(R.id.gettitle_id);
        desc = findViewById(R.id.getdesc_id);
        img = findViewById(R.id.getimg_id);
        id = findViewById(R.id.getId_id);
    }



    public void addBook(View view) {
        String t = title.getText().toString();
        String d = desc.getText().toString();
        String i = img.getText().toString();

        if (sqlConnection.insertData(t, d, i))
            Toast.makeText(this, "data inserted successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "data did not insert", Toast.LENGTH_SHORT).show();
    }

    public void Library(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void updateData(View view) {
        String t = title.getText().toString();
        String d = desc.getText().toString();
        String Id = id.getText().toString();
        try{
            sqlConnection.update(Id,t,d);
            Toast.makeText(this, "data updated successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void deleteData(View view) {
        String Id = id.getText().toString();
        try{
            sqlConnection.delete(Id);
            Toast.makeText(this, "data Deleted successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
