package com.example.bscssectionabatch20.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

public class DbQueries extends SQLiteOpenHelper {
    public DbQueries (Context context)
    {
        super(context,"ContactsDB",null,1);
        Log.d("TAG","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SqlTableQuery = "CREATE TABLE CONTACTS("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"firstname TEXT, "+" lastname TEXT,"+"emailAddress TEXT,"+"homeAddress TEXT)";
                db.execSQL(SqlTableQuery);

        Log.d("TAG","Table Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertSingleContact(HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        //it understand content value datastructure
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("lastName",contact.get("lastName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        Long result  = db.insert("CONTACTS",null,contentValues);
        if (result !=-1)
        {
            Log.d("TAG","New Contact inserted with ID " + result);
        }
        else {
            Log.d("TAG","New Contact Insertion Failed");
        }
        db.close();

    }
}
