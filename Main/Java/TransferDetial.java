package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TransferDetial extends AppCompatActivity {

    EditText transferAmount, transferAccount;
    Button ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_detial);
        transferAccount=findViewById(R.id.transfer_account);
        transferAmount=findViewById(R.id.transfer_amount);
        ok=findViewById(R.id.ok);

    }

    public void amount_Tranfer(View view) {

        ClientModel clientModel;

        try {
            clientModel=new ClientModel( transferAccount.getText().toString(),transferAmount.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(this, "transfer detial is wrong", Toast.LENGTH_SHORT).show();
            clientModel=new ClientModel("null","null");
        }

        DatabaseHelper databaseHelper=new DatabaseHelper(TransferDetial.this);
        boolean success = databaseHelper.addOne(clientModel);

        Toast.makeText(this, "Transfered Successfully", Toast.LENGTH_SHORT).show();
    }
}