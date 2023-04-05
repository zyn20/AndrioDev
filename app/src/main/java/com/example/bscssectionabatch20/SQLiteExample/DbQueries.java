package com.example.bscssectionabatch20.SQLiteExample;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DbQueries extends SQLiteOpenHelper {
    public DbQueries (Context context)
    {
        super(context,"ContactDB",null,1);
        Log.d("TAG","Database Created");
    }

    public void InsertSingleContact(HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        //it understand content value datastructure
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstname"));
        contentValues.put("lastName",contact.get("lastname"));
        contentValues.put("phoneNumber",contact.get("phonenumber"));
        contentValues.put("emailAddress",contact.get("emailaddress"));
        contentValues.put("homeAddress",contact.get("homeaddress"));
        long result  = db.insert("CONTACTS",null,contentValues);
        if (result !=-1)
        {
            Log.d("TAG","New Contact inserted with ID " + result);
        }
        else {
            Log.d("TAG","New Contact Insertion Failed");
        }
        db.close();

    }
    public ArrayList<HashMap<String,String>> getAllContacts()
    {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String,String>> contactList = new ArrayList<HashMap<String,String>>();
        String Query = "SELECT * FROM CONTACTS";
        Cursor cursor = db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {
            do {
                HashMap<String,String> hashMap = new HashMap<String,String>();
                hashMap.put("_id",cursor.getString(0));
                hashMap.put("firstName",cursor.getString(1));
                hashMap.put("lastName",cursor.getString(2));
                hashMap.put("phoneNumber",cursor.getString(3));
                hashMap.put("emailAddress",cursor.getString(4));
                hashMap.put("homeAddress",cursor.getString(5));
                contactList.add(hashMap);
            } while (cursor.moveToNext());
        }
        return contactList;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SqlTableQuery = "CREATE TABLE CONTACTS("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"firstName TEXT, "
                +" lastName TEXT,"
                +"emailAddress TEXT,"
                +"homeAddress TEXT)";
                db.execSQL(SqlTableQuery);

        Log.d("TAG","Table Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public HashMap<String,String> getSingleContact(String id) {
        SQLiteDatabase db = getReadableDatabase();
        HashMap<String,String> hashMap = new HashMap<String,String>();
        String Query =  "SELECT * FROM CONTACTS WHERE  _id= " +id;
        Cursor cursor = db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {
                hashMap.put("_id",cursor.getString(0));
                hashMap.put("firstName",cursor.getString(1));
                hashMap.put("lastName",cursor.getString(2));
                hashMap.put("phoneNumber",cursor.getString(3));
                hashMap.put("emailAddress",cursor.getString(4));
                hashMap.put("homeAddress",cursor.getString(5));
        }
        return hashMap;


    }
}
