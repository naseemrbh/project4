package com.example.naseem.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;

public class Show_all extends AppCompatActivity {

   // ListView listView;
    //Spinner spinnertop , spinnerbottom;
    // CheckBox top , bottom , shoes;

    @Override
    protected void onResume() {
        super.onResume();
    Realm realm = Realm.getInstance(Show_all.this);
        //top = (CheckBox) findViewById(R.id.checkTop);
        //bottom = (CheckBox) findViewById(R.id.checkBottom);
        //spinnertop = (Spinner) findViewById(R.id.spinner_Top);
        //spinnerbottom = (Spinner) findViewById(R.id.spinner_Bottom);

        //realm.beginTransaction(); only when we want to write data ..
        List<Size> sizes = realm.allObjects(Size.class);
        String[] names = new String[sizes.size()];
        String[] topSizes = new String[sizes.size()];
        String[] bottomSize = new String[sizes.size()];
        String[] shoesSize = new String[sizes.size()];

        //int [] images = new int[sizes.size()];

        for (int i = 0; i < sizes.size(); i++) {
            names[i] = sizes.get(i).getName();
            topSizes[i]= sizes.get(i).getTopSize();
            bottomSize[i]= sizes.get(i).getBottomSize();
            shoesSize[i]=sizes.get(i).getShoesSize();

        }

       ListView listView = (ListView) findViewById(R.id.listView2);
        Adapter adapter = new Adapter(this,names ,topSizes,bottomSize,shoesSize );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Show_all.this, edit_Size.class);
                intent.putExtra("ID",position);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        Button other = (Button) findViewById(R.id.otherItem);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Show_all.this,show_others.class));

            }
        });

    }

}
