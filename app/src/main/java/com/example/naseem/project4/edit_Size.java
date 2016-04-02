package com.example.naseem.project4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class edit_Size extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__size);
        int i = getIntent().getIntExtra("ID",0);

        final EditText name = (EditText) findViewById(R.id.Tname);
        final CheckBox checkTop = (CheckBox)findViewById(R.id.checkTop);
        final CheckBox checkBottom = (CheckBox)findViewById(R.id.checkBottom);
        final CheckBox checkShoes = (CheckBox)findViewById(R.id.checkShoes);

        final Spinner spinnerTop = (Spinner)findViewById(R.id.spinner_Top);
        final Spinner spinnerBottom =(Spinner)findViewById(R.id.spinner_Bottom);
        final Spinner spinnerShoes=(Spinner)findViewById(R.id.spinner_Shoes);
        final ArrayAdapter<CharSequence> topandbottomadapter , shoesAdabter;

        topandbottomadapter=ArrayAdapter.createFromResource(edit_Size.this,R.array.TopandBottomSize,android.R.layout.simple_spinner_item);
        topandbottomadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTop.setAdapter(topandbottomadapter);
        spinnerBottom.setAdapter(topandbottomadapter);

        shoesAdabter=ArrayAdapter.createFromResource(edit_Size.this,R.array.ShoesSize,android.R.layout.simple_spinner_item);
        shoesAdabter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShoes.setAdapter(shoesAdabter);

        final Realm realm = Realm.getInstance(getApplicationContext());
        List<Size> sizes = realm.allObjects(Size.class);
        final Size size = sizes.get(i);


        name.setText(size.getName());
        checkTop.setChecked(size.isChecked());
        checkBottom.setChecked(size.isChecked());
        checkShoes.setChecked(size.isChecked());
//        spinnerTop.getSelectedItem();
//        spinnerBottom.getSelectedItem();
//        spinnerShoes.getSelectedItem();


        Button delete = (Button) findViewById(R.id.mainAdd);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(edit_Size.this)
                        .setTitle("Delete Person")
                        .setMessage("Do u want for Del ")
                        .setPositiveButton("Yse", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                realm.beginTransaction();
                                size.removeFromRealm();
                                realm.commitTransaction();
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
        });

        Button update = (Button) findViewById(R.id.updatebtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(edit_Size.this)
                        .setTitle("Update Person")
                        .setMessage("Are u sure to update")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                realm.beginTransaction();
                                size.setName(name.getText().toString());
                                size.setChecked(checkTop.isChecked());
                                size.setChecked(checkBottom.isChecked());
                                size.setChecked(checkShoes.isChecked());

                                if(checkTop.isChecked()) {
                                    if ("XS".equals(spinnerTop.getSelectedItem().toString())) {
                                        size.setTopSize(" XS in UK = 10 , US = 6 and EUR = 36 ");
                                    } else if ("S".equals(spinnerTop.getSelectedItem().toString())) {
                                        size.setTopSize(" S in UK = 10 , US = 6 and EUR = 36 ");
                                    } else if ("M".equals(spinnerTop.getSelectedItem().toString())) {
                                        size.setTopSize(" M in UK = 12 , US = 8 and EUR = 38 ");
                                    } else if ("L".equals(spinnerTop.getSelectedItem().toString())) {
                                        size.setTopSize(" L in UK = 14 , US = 10 and EUR = 40 ");
                                    } else if ("XL".equals(spinnerTop.getSelectedItem().toString())) {
                                        size.setTopSize(" XL in UK = 16 , US = 12 and EUR = 42 ");
                                    }
                                }
                                if(checkBottom.isChecked()) {
                                    if ("XS".equals(spinnerBottom.getSelectedItem().toString())) {
                                        size.setTopSize(" XS in UK = 10 , US = 6 and EUR = 36 ");
                                    } else if ("S".equals(spinnerBottom.getSelectedItem().toString())) {
                                        size.setTopSize(" S in UK = 10 , US = 6 and EUR = 36 ");
                                    } else if ("M".equals(spinnerBottom.getSelectedItem().toString())) {
                                        size.setTopSize(" M in UK = 12 , US = 8 and EUR = 38 ");
                                    } else if ("L".equals(spinnerBottom.getSelectedItem().toString())) {
                                        size.setTopSize(" L in UK = 14 , US = 10 and EUR = 40 ");
                                    } else if ("XL".equals(spinnerBottom.getSelectedItem().toString())) {
                                        size.setTopSize(" XL in UK = 16 , US = 12 and EUR = 42 ");
                                    }
                                }

//                                size.setSelect(spinnerBottom.getSelectedItem().toString());
//                                size.setSelect(spinnerShoes.getSelectedItem().toString());

                                realm.copyToRealmOrUpdate(size);
                                realm.commitTransaction();
                                Toast.makeText(edit_Size.this,"Size Updated" , Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
        });




    }
}
