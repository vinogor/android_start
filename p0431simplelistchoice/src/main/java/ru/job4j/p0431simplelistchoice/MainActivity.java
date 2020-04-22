package ru.job4j.p0431simplelistchoice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // получаем ListView
        lvMain = findViewById(R.id.lvMain);

        // устанавливаем режим выбора пунктов списка
//        lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Создаем адаптер, используя массив из файла ресурсов
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                // для случая когда инфу для вставки берём из ресурсов
                .createFromResource(
                        this, // чтобы можно было надуть и иметь доступ к ресурсам (методы активити)
                        R.array.names, // массив имён из ресурсов
//                        android.R.layout.simple_list_item_single_choice); // системная заготовка
                        android.R.layout.simple_list_item_multiple_choice); // системная заготовка
        lvMain.setAdapter(adapter);

        Button btnChecked = findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);


    }

    public void onClick(View arg0) {
        // получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);

        // пишем в лог выделенный элемент

//        Log.d(LOG_TAG, "checked: " + names[lvMain.getCheckedItemPosition()]);

        Log.d(LOG_TAG, "checked: ");
        // SparseBooleanArray это типо Map(int, boolean).
        // Ключ (int) – это позиция элемента,
        // а значение (boolean) – это выделен пункт списка или нет.
        // хранит инфу не о всех пунктах, а только о тех, с которыми проводили действие
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for (int i = 0; i < sbArray.size(); i++) {
            int key = sbArray.keyAt(i);
            if (sbArray.get(key))
                Log.d(LOG_TAG, names[key]);
        }
    }
}