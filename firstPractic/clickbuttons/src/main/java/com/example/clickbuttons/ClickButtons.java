package com.example.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickButtons extends AppCompatActivity {
    private TextView textView;
    private Button buttonOk;
    private Button buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_buttons);
        textView = (TextView) findViewById(R.id.textView);
        buttonOk = (Button) findViewById(R.id.buttonOk);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);

        View.OnClickListener onClickOk = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Нажата кнопка OK");
            }
        };
        buttonOk.setOnClickListener(onClickOk);

        View.OnClickListener onClickCancel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Нажата кнопка Cancel");
            }
        };
        buttonCancel.setOnClickListener(onClickCancel);
    }
}