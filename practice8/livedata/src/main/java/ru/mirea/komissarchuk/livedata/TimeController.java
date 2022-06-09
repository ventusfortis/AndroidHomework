package ru.mirea.komissarchuk.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeController extends ViewModel {
    static class TimeLiveData {
        private static final MutableLiveData<Long> time = new MutableLiveData<>();
        static LiveData<Long> getTime() {
            return time;
        }
        static void setTime() {
            TimeLiveData.time.setValue(System.currentTimeMillis());
        }

        private static final LiveData<String> getStringTime = Transformations.map(time, input -> {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(calendar.getTime());
        });
        static LiveData<String> getDateTime() {
            return getStringTime;
        }
    }
}
