package com.example.problemstatement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelperr extends SQLiteOpenHelper {
    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    // Filename of the database
    private static final String DATABASE_NAME = "revision.db";

    private static final String TABLE_REVISION = "revision";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STARS = "stars";




    public DBHelperr(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_REVISION +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_STARS + " REAL )";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVISION);
        // Create table(s) again
        onCreate(db);

    }

    public void insertRevision(String name, String stars){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_NAME, name);
        // Store the column name as key and the date as value
        values.put(COLUMN_STARS, stars);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_REVISION, null, values);
        // Close the database connection
        db.close();




    }

}
