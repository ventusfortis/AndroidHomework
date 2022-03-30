package ru.mirea.komissarchuk.dialog;

import android.app.TimePickerDialog;
import android.content.Context;

public class MyTimeDialogFragment extends TimePickerDialog {

    public MyTimeDialogFragment(Context context, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
    }
}
