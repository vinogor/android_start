package com.vinogor.p0141menuadv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//                                AppCompatActivity - чтобы отображалось меню!!
public class MainActivity extends AppCompatActivity {
//public class MainActivity extends Activity {

    // Элементы экрана
    TextView tv;
    CheckBox chb;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // находим элементы
        tv = findViewById(R.id.textView);
        chb = findViewById(R.id.chbExtMenu);

    }

    // Создает меню и более не используется
    // вызывается только при первом показе меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // загрузка меню из xml
        getMenuInflater().inflate(R.menu.mymenu, menu);

        // добавляем пункты меню программно
//        menu.add(0, 1, 0, "add");
//        menu.add(0, 2, 0, "edit");
//        menu.add(0, 3, 3, "delete");
//        menu.add(1, 4, 1, "copy");
//        menu.add(1, 5, 2, "paste");
//        menu.add(1, 6, 4, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    //  вызывается каждый раз перед отображением меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

//        пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
//        menu.setGroupVisible(1, chb.isChecked());

        menu.setGroupVisible(R.id.group1, chb.isChecked());

        return super.onPrepareOptionsMenu(menu);
    }

    // вызывается при нажатии пункта меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: ").append(item.getGroupId());
        sb.append("\r\n itemId: ").append(item.getItemId());
        sb.append("\r\n order: ").append(item.getOrder());
        sb.append("\r\n title: ").append(item.getTitle());
        tv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }
}