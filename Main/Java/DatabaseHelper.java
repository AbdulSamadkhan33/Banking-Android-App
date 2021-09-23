package com.example.bankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_CONTACT = "CONTACT";
    public static final String COLUMN_CURRENT_BALANCE = "CURRENT_BALANCE";
    public static final String COLUMN_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    //this is called the first time database is accessed. there should be a code to create new table ;
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTablesStatement = "CREATE TABLE " + CUSTOMER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT," + COLUMN_EMAIL + " TEXT," + COLUMN_CONTACT + " INTGER," + COLUMN_CURRENT_BALANCE + " INTGER," + COLUMN_ACCOUNT_NUMBER + " TEXT)";
        db.execSQL(createTablesStatement);

    }

    // this is called when the database version changed.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(ClientModel clientModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME, clientModel.getName());
        cv.put(COLUMN_EMAIL, clientModel.getEmail());
        cv.put(COLUMN_CONTACT, clientModel.getNumber());
        cv.put(COLUMN_CURRENT_BALANCE, clientModel.getCurrent_balance());
        cv.put(COLUMN_ACCOUNT_NUMBER, clientModel.getAccount_number());
        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert == -1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateTransfer(ClientModel clientModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CURRENT_BALANCE, clientModel.getCurrent_balance());
//        cv.put(COLUMN_ACCOUNT_NUMBER, clientModel.getAccount_number());
        Cursor cursor= db.rawQuery("SELECT COLUMN_CURRENT_BALANCE FROM CUSTOMER_TABLE WHERE COLUMN_ACCOUNT_NUMBER=?",new String[]{COLUMN_ACCOUNT_NUMBER});
        if (cursor.getCount()>0) {

            long transfer = db.update("CUSTOMER_TABLE", cv, "COLUMN_CURRENT_BALANCE=?", new String[]{COLUMN_CURRENT_BALANCE});
            if (transfer == -1) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
}
    
    public List<ClientModel> getAllUser()
    {
        List<ClientModel> returnlist=new ArrayList<>();

        // getting data from database
        String queryString= "SELECT * FROM " +CUSTOMER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            do {
                int customerID=cursor.getInt(0);
                String customerName=cursor.getString(1);
                String customerEmail=cursor.getString(2);
                String customerContact=cursor.getString(3);
                String currentBalance=cursor.getString(4);
                String accountNumber=cursor.getString(5);

                ClientModel newClient=new ClientModel(customerID,customerName,customerEmail,customerContact,currentBalance,accountNumber);
                returnlist.add(newClient);



            }while (cursor.moveToNext());

        }else
            {
                //failuer nothing added in list
            }
        //close the both cursor and database.
        cursor.close();
        db.close();

        return returnlist;
    }

}
