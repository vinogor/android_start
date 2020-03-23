package com.vinogor.p0081viewbyid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.myText);
        myTextView.setText("New text in TextView");

        Button myBtn = findViewById(R.id.button);
        myBtn.setText("My button");

        myBtn.setEnabled(false);

        CheckBox checkBox = findViewById(R.id.checkBox);

        checkBox.setChecked(true);


    }
}
