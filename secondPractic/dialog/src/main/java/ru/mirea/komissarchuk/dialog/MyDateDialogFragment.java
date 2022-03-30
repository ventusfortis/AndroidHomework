package ru.mirea.komissarchuk.dialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class MyDateDialogFragment extends DatePickerDialog {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public MyDateDialogFragment(@NonNull Context context) {
        super(context);
    }
}
