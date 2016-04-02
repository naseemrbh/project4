package com.example.naseem.project4;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by fatimahalmohaimeed on 1‏/4‏/2016.
 */
public class otherAdapter  extends ArrayAdapter<String> {
    String[] othernames = {};
    String [] Descriptions = {};


    Context context;
    LayoutInflater inflater;

    public otherAdapter(Context context , String[]othernames ,String[] Descriptions)
    {
        super(context,R.layout.other_row,othernames);
        this.context = context;
        this.othernames = othernames;
        this.Descriptions = Descriptions;
    }

    public class Viewholder
    {
        TextView otherName;
        TextView otherDescription;

        //TextView Description;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.other_row,null);
        }

        final Viewholder viewholder = new Viewholder();

        viewholder.otherName=(TextView)convertView.findViewById(R.id.othersName);
        viewholder.otherDescription=(TextView)convertView.findViewById(R.id.OthersDesc);


        viewholder.otherName.setText(othernames[position]);
        viewholder.otherDescription.setText(Descriptions[position]);



        return convertView;
    }
}

