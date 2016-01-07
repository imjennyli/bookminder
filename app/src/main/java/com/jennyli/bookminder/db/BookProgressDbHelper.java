package com.jennyli.bookminder.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jennyli on 1/6/2016.
 */
public class BookProgressDbHelper extends SQLiteOpenHelper
{
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "BookProgress.db";

    private static BookProgressDbHelper sInstance;

    public static synchronized BookProgressDbHelper getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new BookProgressDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private BookProgressDbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE_SQL = "CREATE TABLE " + BookProgressContract.ProgressTable.TABLE_NAME +
                "(" + BookProgressContract.ProgressTable._ID + " INTEGER PRIMARY KEY," +
                BookProgressContract.ProgressTable.COLUMN_TITLE + " TEXT," +
                BookProgressContract.ProgressTable.COLUMN_PROGRESS + " INTEGER," +
                BookProgressContract.ProgressTable.COLUMN_DELETED + " INTEGER" +
                ")";
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // I don't do anything yet!
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // I don't do anything yet!
    }
}
