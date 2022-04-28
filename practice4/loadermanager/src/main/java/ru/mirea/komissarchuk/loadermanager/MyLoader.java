package ru.mirea.komissarchuk.loadermanager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

public class MyLoader extends AsyncTaskLoader<String> {
    private String firstName;
    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            firstName = args.getString(ARG_WORD);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        return shuffleString(firstName);
    }

    private String shuffleString(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int random = (int) (Math.random() * chars.length);
            char temp = chars[i];
            chars[i] = chars[random];
            chars[random] = temp;
        }
        return new String(chars);
    }
}
