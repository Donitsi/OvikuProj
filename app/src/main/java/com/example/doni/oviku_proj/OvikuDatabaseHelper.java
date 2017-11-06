package com.example.doni.oviku_proj;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Doni on 11/6/2017.
 */

public class OvikuDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "oviku"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    OvikuDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE USER_OVIKU (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "EMAIL TEXT, "
                    + "PASSWORD TEXT ");
            insertUser(db, "heikki.heikkinen@gmail.com", "heikki");
            insertUser(db, "tuomas.tuominen@gmail.com", "tuomas, hot milk and steamed-milk foam");
        }
        insertUser(db, "paivi.paivinen@gmail.com", "paivi");
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE USER_OVIKU ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertUser(SQLiteDatabase db, String username,
                                    String password) {
        ContentValues userValues = new ContentValues();
        userValues.put("NAME", username);
        userValues.put("DESCRIPTION", password);
        db.insert("USER_OVIKU", null, userValues);
    }
}
