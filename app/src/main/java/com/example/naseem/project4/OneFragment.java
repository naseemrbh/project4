package com.example.naseem.project4;

/**
 * Created by Naseem on 27/03/16.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import io.realm.Realm;


public class OneFragment extends Fragment {


    Item item = new Item();
    Size size = new Size();
    //RadioGroup radioGroup;
    //RadioButton radioButton;
    Button addButton ,show;
    EditText name;
    CheckBox checkTop , checkBottom , checkShoes;
    Spinner spinnerTop , spinnerBottom, spinnerShoes;
    ArrayAdapter<CharSequence> topandbottomadapter , shoesAdabter;

    Button mainAdd;
    Context context = getContext();
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        App.activityResumed();
    }

    @Override
    public void onPause() {
        super.onPause();
        App.activityPaused();
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_one, container, false);




        mainAdd = (Button) view.findViewById(R.id.mainAdd);


        mainAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //custom dialog
              //  DialogFragment dialog = DialogFragment.instantiate(getActivity(), "Hello world");
              //  dialog.show(getFragmentManager(), "dialog");
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle("New person..");

                //set the Custom dialog component
                final EditText name = (EditText) dialog.findViewById(R.id.Tname);
                //  final TextView topSizeTv = (TextView) dialog.findViewById(R.id.TopTv); //<<<<<<<<<<<<<<<<<<<<< view naseem is added
                //radioGroup =(RadioGroup)dialog.findViewById(R.id.radioGroup);

                checkTop = (CheckBox) dialog.findViewById(R.id.checkTop);
                checkBottom = (CheckBox) dialog.findViewById(R.id.checkBottom);
                checkShoes = (CheckBox) dialog.findViewById(R.id.checkShoes);

                spinnerTop = (Spinner) dialog.findViewById(R.id.spinner_Top);
                spinnerBottom = (Spinner) dialog.findViewById(R.id.spinner_Bottom);
                spinnerShoes = (Spinner) dialog.findViewById(R.id.spinner_Shoes);


                topandbottomadapter = ArrayAdapter.createFromResource(context, R.array.TopandBottomSize, android.R.layout.simple_spinner_item);
                topandbottomadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTop.setAdapter(topandbottomadapter);
                spinnerBottom.setAdapter(topandbottomadapter);

                shoesAdabter = ArrayAdapter.createFromResource(context, R.array.ShoesSize, android.R.layout.simple_spinner_item);
                shoesAdabter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerShoes.setAdapter(shoesAdabter);

                checkTop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerTop.setVisibility(View.VISIBLE);


                        spinnerTop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }

                });

                checkBottom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerBottom.setVisibility(View.VISIBLE);
                        spinnerBottom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(context, parent.getItemAtPosition(position) + " selected", Toast.LENGTH_SHORT).show();
//                                if("XS".equals(spinnerBottom.getItemAtPosition(position).toString())) {
//                                    size.setBottomSize(" XS in UK = 8 , US = 4 and EUR = 34 ");
//                                }else if("S".equals(spinnerBottom.getItemAtPosition(position).toString())){
//                                    size.setBottomSize(" S in UK = 10 , US = 6 and EUR = 36 ");
//                                }else if("M".equals(spinnerBottom.getItemAtPosition(position).toString())){
//                                    size.setBottomSize(" M in UK = 12 , US = 8 and EUR = 38 ");
//                                }else if("L".equals(spinnerBottom.getItemAtPosition(position).toString())){
//                                    size.setBottomSize(" L in UK = 14 , US = 10 and EUR = 40 ");
//                                }else if("XL".equals(spinnerBottom.getItemAtPosition(position).toString())){
//                                    size.setBottomSize(" XL in UK = 16 , US = 12 and EUR = 42 ");
//                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }
                });
                checkShoes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinnerShoes.setVisibility(View.VISIBLE);
                        spinnerShoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();

                                // we need size for shoes
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                });

                Button dialogadd = (Button) dialog.findViewById(R.id.addbtn);
                dialogadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //int selected_id = radioGroup.getCheckedRadioButtonId();
                        // radioButton =(RadioButton)dialog.findViewById(selected_id);

                        size.setName(name.getText().toString());

                        if (checkTop.isChecked()) {
                            if ("XS".equals(spinnerTop.getSelectedItem().toString())) {
                                size.setTopSize(" XS in UK = 10 , US = 6 and EUR = 34 ");
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
                        if (checkBottom.isChecked()) {
                            if ("XS".equals(spinnerBottom.getSelectedItem().toString())) {
                                size.setBottomSize(" XS in UK = 10 , US = 6 and EUR = 34 ");
                            } else if ("S".equals(spinnerBottom.getSelectedItem().toString())) {
                                size.setBottomSize(" S in UK = 10 , US = 6 and EUR = 36 ");
                            } else if ("M".equals(spinnerBottom.getSelectedItem().toString())) {
                                size.setBottomSize(" M in UK = 12 , US = 8 and EUR = 38 ");
                            } else if ("L".equals(spinnerBottom.getSelectedItem().toString())) {
                                size.setBottomSize(" L in UK = 14 , US = 10 and EUR = 40 ");
                            } else if ("XL".equals(spinnerBottom.getSelectedItem().toString())) {
                                size.setBottomSize(" XL in UK = 16 , US = 12 and EUR = 42 ");
                            }
                        }
                        if (checkShoes.isChecked()) {
                            if ("5".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 5 in UK = 2 , US = 5 and EUR = 36 ");
                            } else if ("5.5".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 5.5 in UK = 2.5 , US = 5.5 and EUR = 36.5 ");
                            } else if ("6".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 6 in UK = 3 , US = 6 and EUR = 37 ");
                            } else if ("6.5".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 6.5 in UK = 3.5 , US = 6.5 and EUR = 37.5 ");
                            } else if ("7".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 7 in UK = 4 , US = 7 and EUR = 38 ");
                            } else if ("7.5".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 7.5 in UK = 4.5 , US = 7.5 and EUR = 38.5 ");
                            } else if ("8".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 8 in UK = 5 , US = 8 and EUR = 39 ");
                            } else if ("8.5".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 8.5 in UK = 5.5 , US = 8.5 and EUR = 39.5 ");
                            } else if ("9".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 9 in UK = 6 , US = 9 and EUR = 40 ");
                            } else if ("9.5".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 9.5 in UK = 6.5 , US = 9.5 and EUR = 40.5 ");
                            } else if ("10".equals(spinnerShoes.getSelectedItem().toString())) {
                                size.setShoesSize(" 10 in UK = 7 , US = 10 and EUR = 41 ");
                            }

                        }


                        //size.setSizeType(radioButton.getText().toString());
                        // size.setShoesSize(spinnerShoes.getSelectedItem().toString());

                        Realm realm = Realm.getInstance(context);
                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(size);
                        realm.commitTransaction();

                        Toast.makeText(context, "Size added", Toast.LENGTH_SHORT).show();
                        getActivity().finish();

                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        Button addOther = (Button) view.findViewById(R.id.addOtherbtn);
        addOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog otherDialog = new Dialog(context);
                otherDialog.setContentView(R.layout.other_dialog);
                otherDialog.setTitle("New Items..");

                final EditText otherName = (EditText) otherDialog.findViewById(R.id.othersName);
                final EditText description = (EditText) otherDialog.findViewById(R.id.otherDesc);


                Button addItem = (Button) otherDialog.findViewById(R.id.otherItem);
                addItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        item.setName(otherName.getText().toString());
                        item.setDescription(description.getText().toString());

                        Realm realm = Realm.getInstance(context);
                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(item);
                        realm.commitTransaction();

                        Toast.makeText(context, "item added", Toast.LENGTH_SHORT).show();
                        getActivity().finish();

                        otherDialog.dismiss();

                    }
                });
                otherDialog.show();
            }
        });

        Button show = (Button) view.findViewById(R.id.showbtn);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Show_all.class);
                startActivity(intent);
            }
        });


        return view;
    }



}
