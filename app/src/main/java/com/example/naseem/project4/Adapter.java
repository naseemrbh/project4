package com.example.naseem.project4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fatimahalmohaimeed on 27‏/3‏/2016.
 */
public class Adapter extends ArrayAdapter<String> {

    String[] names = {};
    String [] topSizes = {};
    String [] bottomSizes = {};
    String [] shoesSizes = {};

    Context context;
    LayoutInflater inflater;

    public Adapter(Context context , String[]names ,String[] topSizes ,String [] bottomSizes,String [] shoesSizes)
    {
        super(context,R.layout.row,names);
        this.context = context;
        this.names = names;
        this.topSizes = topSizes;
        this.bottomSizes = bottomSizes;
        this.shoesSizes = shoesSizes;
        //this.imgs = imgs;
    }

    public class Viewholder
    {
        TextView nametv;
        TextView topSize , bottomSize , shoesSize;
        ImageView img;

        //TextView Description;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row,null);
        }

        final Viewholder viewholder = new Viewholder();

        viewholder.nametv=(TextView)convertView.findViewById(R.id.NameTv);
        viewholder.topSize=(TextView)convertView.findViewById(R.id.TopTv);
        viewholder.bottomSize=(TextView)convertView.findViewById(R.id.BottomTv);
       viewholder.shoesSize=(TextView)convertView.findViewById(R.id.ShoesTv);


        viewholder.nametv.setText(names[position]);
        viewholder.topSize.setText(topSizes[position]);
        viewholder.bottomSize.setText(bottomSizes[position]);
        viewholder.shoesSize.setText(shoesSizes[position]);


        return convertView;
    }
}
