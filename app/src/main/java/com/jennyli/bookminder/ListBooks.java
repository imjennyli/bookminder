package com.jennyli.bookminder;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jennyli.bookminder.db.BookProgressDbHelper;
import com.jennyli.bookminder.model.BookProgress;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jennyli on 1/6/2016.
 */
public class ListBooks extends Activity implements AddBookDialog.AddBookDialogListener
{
    private static final String DIALOGFRAGMENT_ADDBOOK_KEY = "ADDBOOK_DIALOG_FRAGMENT";

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
        int count = BookProgressDbHelper.getInstance(this).getBooksCount();
        bookCount.setText(getResources().getQuantityString(R.plurals.book_count_text, count, count));
    }

    public void showAddBookDialog(View v)
    {
        DialogFragment dialog = new AddBookDialog();
        dialog.show(getFragmentManager(), DIALOGFRAGMENT_ADDBOOK_KEY);

    }

    @Override
    public void onPositiveClick(AddBookDialog dialog)
    {
        String bookTitle =  dialog.getBookTitle().getText().toString();
        String bookProgress = dialog.getBookProgress().getText().toString();
        Toast.makeText(this, bookTitle+": "+bookProgress, Toast.LENGTH_SHORT).show();

        BookProgress bp = new BookProgress();
        bp.setTitle(bookTitle);
        bp.setProgress(Integer.valueOf(bookProgress));
        BookProgressDbHelper.getInstance(this).addBookProgress(bp);
    }
}
