package com.example.personalhealthrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance;

    private static final String TAG = "DatabaseHelper";

    private static final String tableName = "register";

    public DatabaseHelper(Context context) {
        super(context, tableName, null, 1);
    }

//    public static synchronized DatabaseHelper getInstance(Context context) {
//
//        if (instance == null) {
//            instance = new DatabaseHelper(context.getApplicationContext());
//        }
//        return instance;
//    }

    //create the tables in the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + tableName +
                "(first_name TEXT ,last_name TEXT ,username TEXT, password TEXT, phoneNumber TEXT ,email TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);

        onCreate(sqLiteDatabase);
    }

    public boolean addData(String firstName, String lastName, String username, String password, int phone, String email) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", firstName);
        contentValues.put("last_name", lastName);
        contentValues.put("username_name", username);
        contentValues.put("password", password);
        contentValues.put("phoneNumber", phone);
        contentValues.put("email", email);

        Log.d(TAG, "addData: Adding" + firstName + "to" + tableName);
        Log.d(TAG, "addData: Adding" + lastName + "to" + tableName);
        Log.d(TAG, "addData: Adding" + username + "to" + tableName);
        Log.d(TAG, "addData: Adding" + password + "to" + tableName);
        Log.d(TAG, "addData: Adding" + phone + "to" + tableName);
        Log.d(TAG, "addData: Adding" + email + "to" + tableName);

        long result = db.insert(tableName, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " SELECT * FROM " + tableName;
        Cursor data = db.rawQuery(query, null);
        return data;

    }
}

