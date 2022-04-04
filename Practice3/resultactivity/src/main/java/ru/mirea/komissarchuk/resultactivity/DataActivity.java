package ru.mirea.komissarchuk.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {

    private EditText editTextUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        editTextUniversity = findViewById(R.id.editTextUniversity);
    }

    public void sendResult(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", editTextUniversity.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}