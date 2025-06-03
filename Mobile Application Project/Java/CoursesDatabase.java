package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CoursesDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "courses.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "courses";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COURSE_NAME = "courseName";
    public static final String COLUMN_CREDIT = "credit";
    public static final String COLUMN_QUALITY_POINT = "qualityPoint";

    public CoursesDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COURSE_NAME + " TEXT, " +
                COLUMN_CREDIT + " INTEGER, " +
                COLUMN_QUALITY_POINT + " REAL);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}