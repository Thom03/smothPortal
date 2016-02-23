package com.smoothel.www.smothportal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WAINAH on 2/6/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //extsion table
    private static final String COLUMN_ID1 ="id";
    private static final String TABLE_EX ="extension";
    private static final String COLUMN_DEP ="dname";
    private static final String COLUMN_NAME ="pname";
    private static final String COLUMN_EX ="exno";




    //colums of registration table
    private static final int DATABASE_VERSION = 1;
    private static  final String DATABASE_NAME ="smoothel.db";
    private static final String TABLE_NAME ="employees";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_FNAME ="fname";
    private static final String COLUMN_LNAME ="lname";
    private static final String COLUMN_UNAME ="uname";
    private static final String COLUMN_PASS ="pass";
    private static final String COLUMN_PHONENO ="phoneno";
    private static final String COLUMN_EMAIL ="email";
    SQLiteDatabase db;


    private static final String TABLE_CREATE = "create table employees (id integer primary key not null  ," +
            "name text not null, uname text not null, pass text not null, idno not null, phoneno not null, email not null);";

    private static final String TABLE_CREATEEX = "create table extension (id integer primary key not null  ," +
            "dname text not null, pname text not null, exno not null);";

    private static final String EXINSERT = "create table extension (id integer primary key not null  ," +
            "dname text not null, pname text not null, exno not null);";




    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATEEX);
        this.db = db;

    }

    public void insertContact(contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from employees";
        Cursor cursor = db.rawQuery(query ,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, count);


        values.put(COLUMN_FNAME, c.getFname());
        values.put(COLUMN_LNAME, c.getLname());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());
        values.put(COLUMN_PHONENO, c.getPhoneno());
        values.put(COLUMN_EMAIL, c.getEmail());


        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query ="select uname, pass from employees";
        Cursor cursor = db.rawQuery(query , null);
        String a,b;
        b = "not found";

        if (cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if(a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;

                }

            }
            while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }

    public void insertEx(contact u)
    {
        db = this.getWritableDatabase();
        ContentValues insertValues = new ContentValues();

        String query = "select * from extension";
        Cursor cursor = db.rawQuery(query ,null);
        int count = cursor.getCount();
        insertValues.put(COLUMN_ID1, count);


        insertValues.put(COLUMN_DEP, u.getDname());
        insertValues.put(COLUMN_NAME, u.getPname());
        insertValues.put(COLUMN_EX, u.getExno());


        db.insert(TABLE_EX, null, insertValues);
        db.close();

    }


}
