package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Transfer extends AppCompatActivity {

    TextView userdata;
    Button transfer_btn;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        userdata=findViewById(R.id.userdata);
        back_btn=findViewById(R.id.back_btn);
        transfer_btn=findViewById(R.id.transfer_btn);


        Intent itn=getIntent();
        userdata.setText(itn.getStringExtra("select"));
    }




    public void back_btn(View view) {
        Intent i;
        i=new Intent(Transfer.this,ViewAll.class);
        startActivity(i);
    }

    public void transfer_btn(View view) {
        Intent it;
        it=new Intent(Transfer.this,TransferDetial.class);
        startActivity(it);
    }
}