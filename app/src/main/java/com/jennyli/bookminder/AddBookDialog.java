package com.jennyli.bookminder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import lombok.Getter;

/**
 * A dialog that lets us add a new book to track.
 */
public class AddBookDialog extends DialogFragment
{
    public interface AddBookDialogListener
    {
        void onPositiveClick(AddBookDialog dialog);
    }
    private AddBookDialogListener listener;

    @Getter
    @Bind(R.id.book_title)
    EditText bookTitle;

    @Getter
    @Bind(R.id.progress)
    EditText bookProgress;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            listener = (AddBookDialogListener) activity;
        }
        catch (ClassCastException e)
        {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString() + " must implement AddBookDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_addbook_title);
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_addbook, null);
        builder.setView(v);
        ButterKnife.bind(this, v);
        builder.setPositiveButton(R.string.add, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                listener.onPositiveClick(AddBookDialog.this);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                AddBookDialog.this.getDialog().cancel();
            }
        });

        return builder.create();
    }
}
