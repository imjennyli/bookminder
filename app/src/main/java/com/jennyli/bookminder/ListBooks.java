package com.jennyli.bookminder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.jennyli.bookminder.db.BookProgressDbHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jennyli on 1/6/2016.
 */
public class ListBooks extends Activity
{
    @Bind(R.id.book_list)
    ListView bookList;

    @Bind(R.id.book_count)
    TextView bookCount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_books);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        bookCount.setText(BookProgressDbHelper.getInstance(this).getBooksCount()+ " books being tracked.");
    }
}
