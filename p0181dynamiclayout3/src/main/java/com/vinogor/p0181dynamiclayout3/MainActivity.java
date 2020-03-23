package com.vinogor.p0181dynamiclayout3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sbWeight;
    Button btn1;
    Button btn2;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();



    }

    @Override //  срабатывает все время, пока значение меняется
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int leftValue = progress;
        int rightValue = seekBar.getMax() - progress;
        // настраиваем вес
        lParams1.weight = leftValue;
        lParams2.weight = rightValue;

        // иначе не прорисуется с новым весом
        btn1.requestLayout();
        btn2.requestLayout();

        // в текст кнопок пишем значения переменных, запрос на прорисовку уже внутри
//        btn1.setText(String.valueOf(leftValue));
//        btn2.setText(String.valueOf(rightValue));
    }

    @Override  // срабатывает, когда начинаем тащить ползунок
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override // срабатывает, когда отпускаем ползунок
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}