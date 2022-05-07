package ru.mirea.komissarchuk.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String fileName;
    private EditText editTextName;
    private EditText editTextInside;
    private SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextFileName);
        editTextInside = findViewById(R.id.TextMultiLine);
        fileName = editTextName.getText().toString() + ".txt";
        preferences = getPreferences(MODE_PRIVATE);

    }

    public void onSaveText(View view) {
        fileName = editTextName.getText().toString() + ".txt";
        SharedPreferences.Editor editor = preferences.edit();

        String string = editTextInside.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Сохранение значения по ключу SAVED_TEXT
        editor.putString(SAVED_TEXT, fileName);
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void onLoadText(View view) {
        // Загрузка значения по ключу SAVED_TEXT
        String text = preferences.getString(SAVED_TEXT, "Empty");
        editTextName.setText(text);
        new Thread(() -> {
            editTextInside.post(() -> editTextInside.setText(getTextFromFile(text)));
        }).start();
    }

    // открытие файла
    public String getTextFromFile(String fileName) {
        FileInputStream fin = null;
        try {
            fin = openFileInput(fileName);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            return text;
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }
}