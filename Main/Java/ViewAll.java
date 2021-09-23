package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    TextView textView;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.viwe);
        DatabaseHelper databaseHelper = new DatabaseHelper(ViewAll.this);
        final List<ClientModel> allUser = databaseHelper.getAllUser();
        ArrayAdapter clientArrayAdapter = new ArrayAdapter<ClientModel>(ViewAll.this, android.R.layout.simple_list_item_1, allUser);
        listView.setAdapter(clientArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String select=listView.getItemAtPosition(i).toString();
//                Toast.makeText(ViewAll.this, ""+Name, Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(ViewAll.this,Transfer.class);
                intent.putExtra("select",select);
                startActivity(intent);
            }
        });



    }


}
