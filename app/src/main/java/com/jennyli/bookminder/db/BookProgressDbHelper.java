package com.jennyli.bookminder.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jennyli.bookminder.db.BookProgressContract.ProgressTable;
import com.jennyli.bookminder.model.BookProgress;

import java.util.ArrayList;
import java.util.List;

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
        String CREATE_TABLE_SQL = "CREATE TABLE " + ProgressTable.TABLE_NAME +
                "(" + ProgressTable._ID + " INTEGER PRIMARY KEY," +
                ProgressTable.COLUMN_TITLE + " TEXT," +
                ProgressTable.COLUMN_PROGRESS + " INTEGER," +
                ProgressTable.COLUMN_DELETED + " INTEGER" +
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

    public List<BookProgress> getAllBooks()
    {
        List<BookProgress> books = new ArrayList<>();

        String SELECT_ALL_QUERY = "SELECT * FROM " + ProgressTable.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL_QUERY, null);
        if (cursor.moveToFirst())
        {
            do
            {
                BookProgress book = new BookProgress();
                book.set_id(cursor.getInt(cursor.getColumnIndex(ProgressTable._ID)));
                book.setTitle(cursor.getString(cursor.getColumnIndex(ProgressTable.COLUMN_TITLE)));
                book.setProgress(cursor.getInt(cursor.getColumnIndex(ProgressTable.COLUMN_PROGRESS)));
                book.setDeleted(cursor.getInt(cursor.getColumnIndex(ProgressTable.COLUMN_DELETED)));
                books.add(book);
            }
            while (cursor.moveToNext());
        }
        return books;
    }

    public int getBooksCount()
    {
        String COUNT_QUERY = "SELECT * FROM " + ProgressTable.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(COUNT_QUERY, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}
