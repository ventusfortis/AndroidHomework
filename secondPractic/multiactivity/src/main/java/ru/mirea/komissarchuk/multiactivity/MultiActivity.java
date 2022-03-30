package ru.mirea.komissarchuk.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiActivity extends AppCompatActivity {

    private Button newActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        newActivity = findViewById(R.id.button);
    }

    public void onClickNewActivity (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", "MIREA - КОМИССАРЧУК АРКАДИЙ ВЛАДИСЛАВОВИЧ");
        startActivity(intent);
    }
}