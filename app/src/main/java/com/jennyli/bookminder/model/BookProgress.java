package com.jennyli.bookminder.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jennyli on 1/6/2016.
 */

@NoArgsConstructor
@Data
public class BookProgress
{
    private int _id;
    private String title;
    private int progress;
    private int deleted;
}
