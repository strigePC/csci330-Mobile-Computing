package com.example.strig.mobilecomputingclass.le180201_Persistence;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FIFA18PlayersDatabaseHelper extends SQLiteOpenHelper {

    FIFA18PlayersDatabaseHelper(Context context) {
        super(context, "FIFA18PlayersDatabase", null, 1);
    }

    public FIFA18PlayersDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public FIFA18PlayersDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PLAYERS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FULLNAME TEXT," +
                "COUNTRY TEXT," +
                "AGE INTEGER," +
                "SKILL INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
