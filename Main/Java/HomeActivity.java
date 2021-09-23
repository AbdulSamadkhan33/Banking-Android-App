package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Button add_btn, view_btn;
    TextView home;
    EditText name, email, current_balance, contact, account_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        add_btn = findViewById(R.id.add_btn);
        view_btn = findViewById(R.id.view_btn);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        current_balance = findViewById(R.id.current_balance);
        account_number = findViewById(R.id.account_number);

    }
        public void add_client (View view) {

        ClientModel clientModel;

       try {
            clientModel=new ClientModel(-1,name.getText().toString(),email.getText().toString(),contact.getText().toString(),current_balance.getText().toString(),account_number.getText().toString());
       }
       catch (Exception e){
           Toast.makeText(this, "Error creating customer", Toast.LENGTH_SHORT).show();
           clientModel=new ClientModel(-1,"error","null","error","null","null");
       }

            DatabaseHelper databaseHelper=new DatabaseHelper(HomeActivity.this);
            boolean success = databaseHelper.addOne(clientModel);
            Toast.makeText(this, "successfuly", Toast.LENGTH_SHORT).show();
        }

        public void view_client (View view){
//            Toast.makeText(this, "view all user", Toast.LENGTH_SHORT).show();

            //DatabaseHelper databaseHelper=new DatabaseHelper(ViewAll.this);
            //List<ClientModel> allUser=databaseHelper.getAllUser();
            Intent intent=new Intent(HomeActivity.this,ViewAll.class);
            startActivity(intent);

        }
    }
