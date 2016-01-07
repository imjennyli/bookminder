package com.jennyli.bookminder.db;

import android.provider.BaseColumns;

import lombok.NoArgsConstructor;

/**
 * Created by jennyli on 1/6/2016.
 */
@NoArgsConstructor
public final class BookProgressContract
{
    public static abstract class ProgressTable implements BaseColumns
    {
        public static final String TABLE_NAME = "progress";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_PROGRESS = "progress";
        public static final String COLUMN_DELETED = "deleted";
    }
}
