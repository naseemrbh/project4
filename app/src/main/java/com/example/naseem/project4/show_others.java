package com.example.naseem.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;

public class show_others extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Realm realm = Realm.getInstance(show_others.this);
        //top = (CheckBox) findViewById(R.id.checkTop);
        //bottom = (CheckBox) findViewById(R.id.checkBottom);
        //spinnertop = (Spinner) findViewById(R.id.spinner_Top);
        //spinnerbottom = (Spinner) findViewById(R.id.spinner_Bottom);

        //realm.beginTransaction(); only when we want to write data ..
        List<Item> items = realm.allObjects(Item.class);
        String[] names = new String[items.size()];
        String[] Descriptions = new String[items.size()];

        //int [] images = new int[sizes.size()];

        for (int i = 0; i < items.size(); i++) {
            names[i] = items.get(i).getName();
            Descriptions[i]= items.get(i).getDescription();
        }

        ListView listView = (ListView) findViewById(R.id.otherLv);
        otherAdapter otherAdapter  = new otherAdapter(this,names ,Descriptions);
        listView.setAdapter(otherAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Show_all.this, edit_Size.class);
//                intent.putExtra("ID",position);
//                startActivity(intent);
//            }
//        });
//
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_others);
    }
}
