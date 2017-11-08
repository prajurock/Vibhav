package com.vibhav2k17.android.vibhav2k17;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class technical extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView myGrid1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);

        myGrid1 = (GridView) findViewById(R.id.gridview1);
        myGrid1.setAdapter(new VivzAdapter1(technical.this));
        myGrid1.setOnItemClickListener(this);
    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i==0) {
            Intent intent = new Intent(this, poc.class);
            startActivity(intent);
        }
        else if (i==1) {
            Intent intent = new Intent(this,aavis.class);
            startActivity(intent);
        }
        else if (i==2) {
            Intent intent = new Intent(this, bor.class);
            startActivity(intent);
        }
        else if(i==3){
            Intent intent = new Intent(this, vitri.class);
            startActivity(intent);
        }



    }
}
class VivzAdapter1 extends BaseAdapter {
    ArrayList<events2> list1;
    Context context1;

    VivzAdapter1(Context context1) {
        this.context1 = context1;
        list1 = new ArrayList<events2>();
        Resources res = context1.getResources();
        String[] temp = res.getStringArray(R.array.tech);
        int[] image = {R.drawable.piratesofcircuit, R.drawable.aavishkar, R.drawable.brainoriddle, R.drawable.vitricitys};
        for (int ii = 0; ii < 4; ii++) {
            events2 tempevent1 = new events2(image[ii], temp[ii]);
            list1.add(tempevent1);
        }


    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int i) {
        return list1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class viewHolder1 {
        ImageView iv;
        TextView tv;

        viewHolder1(View v) {
            iv = (ImageView) v.findViewById(R.id.imageView);
            tv = (TextView) v.findViewById(R.id.textView);

        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        viewHolder1 holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.singlegrid, viewGroup, false);
            holder = new viewHolder1(row);
            row.setTag(holder);
        } else {
            holder = (viewHolder1) row.getTag();
        }
        events2 dummy = list1.get(i);
        holder.iv.setImageResource(dummy.imageid);
        holder.tv.setText(dummy.eventName);

        return row;
    }
}

class events2 {
    int imageid;
    String eventName;

    events2(int imageid, String eventName) {
        this.imageid = imageid;
        this.eventName = eventName;
    }

}