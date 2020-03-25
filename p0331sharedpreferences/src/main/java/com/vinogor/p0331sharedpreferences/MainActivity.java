package com.vinogor.p0331sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    EditText etText;
    Button btnSave, btnLoad;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etText = findViewById(R.id.etText);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    void saveText() {
        //                     после сохранения, данные будут видны только этому приложению
        // MODE_PRIVATE - влияет на юниксовые rwx-права доступа к файлу.
        sPref = getPreferences(MODE_PRIVATE); // имя файла - дефолтное
        // sPref = getSharedPreferences("MyPref", MODE_PRIVATE); // заданное имя файла
        // нужен для внесение данных
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        // Здесь Editor мы не используем, т.к. нас интересует только чтение данных.
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}