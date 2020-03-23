package com.vinogor.p0051layoutfiles;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override // запускается при запуске приложения
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // устанавливает содержимое Activity из layout-файла
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.myscreen);
//        LinearLayout
    }
}
