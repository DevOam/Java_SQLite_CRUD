package com.example.sql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_BODY = "body";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_BODY + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public long insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, user.getId());
        values.put(COLUMN_TITLE, user.getTitle());
        values.put(COLUMN_BODY, user.getBody());
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public User getUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        User user = null;
        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") int userId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            @SuppressLint("Range") String body = cursor.getString(cursor.getColumnIndex(COLUMN_BODY));
            user = new User();
            user.setId(userId);
            user.setTitle(title);
            user.setBody(body);
            cursor.close();
        }
        db.close();
        return user;
    }

    public int updateUser(int oldId, User newUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, newUser.getId());
        values.put(COLUMN_TITLE, newUser.getTitle());
        values.put(COLUMN_BODY, newUser.getBody());
        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(oldId)});
        db.close();
        return rowsAffected;
    }

    public int deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsAffected = db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
        return rowsAffected;
    }
}


