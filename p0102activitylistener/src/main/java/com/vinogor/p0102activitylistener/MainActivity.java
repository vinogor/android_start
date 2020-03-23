package com.vinogor.p0102activitylistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity implements OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;
    Button btnStart;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // найдем View-элементы
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnStart = findViewById(R.id.btnStart);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
//        btnStart.setOnClickListener(this); // не надо чтобы сработало через main.xml
    }



    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case R.id.btnOk:
                // кнопка ОК
                tvOut.setText("Нажата кнопка ОК");
                break;
            case R.id.btnCancel:
                // кнопка Cancel
                tvOut.setText("Нажата кнопка Cancel");
                break;
        }
    }

    public void onClickStart(View v) {
        // действия при нажатии на кнопку
        tvOut.setText("Start!!!!!!!!!!!!!");
    }
}
