package ru.mirea.komissarchuk.viewmodel;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProgressViewModel extends ViewModel {
    private static final MutableLiveData<Boolean> progressState = new MutableLiveData<>();

    void showProgress() {
        progressState.setValue(true);
        new Handler().postDelayed(() -> progressState.setValue(false), 10000);
    }

    public MutableLiveData<Boolean> getProgressState() {
        return progressState;
    }
}