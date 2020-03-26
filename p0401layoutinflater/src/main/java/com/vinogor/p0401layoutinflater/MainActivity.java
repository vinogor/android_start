package com.vinogor.p0401layoutinflater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LayoutInflater ltInflater = getLayoutInflater();

        LinearLayout linLayout = findViewById(R.id.linLayout);
//        View view1 = ltInflater.inflate(R.layout.text, linLayout, false);
        View view1 = ltInflater.inflate(R.layout.text, linLayout, true);
        LayoutParams lp1 = view1.getLayoutParams();

        Log.d(LOG_TAG, "Class of view1: " + view1.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view1: " + lp1.getClass().toString());

        // java.lang.ClassCastException: android.widget.LinearLayout cannot be cast to android.widget.TextView
//        Log.d(LOG_TAG, "Text of view1: " + ((TextView) view1).getText());



        RelativeLayout relLayout = findViewById(R.id.relLayout);
//        View view2 = ltInflater.inflate(R.layout.text, relLayout, false);
        View view2 = ltInflater.inflate(R.layout.text, relLayout, true);
        LayoutParams lp2 = view2.getLayoutParams();

        Log.d(LOG_TAG, "Class of view2: " + view2.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view2: " + lp2.getClass().toString());
//        Log.d(LOG_TAG, "Text of view2: " + ((TextView) view2).getText());
    }
}