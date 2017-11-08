package com.vibhav2k17.android.vibhav2k17;

import android.app.ListFragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 27-10-2017.
 */

public class day1fragment extends ListFragment {
    ListView mylist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.day1,container,false);
        mylist = (ListView) rootView.findViewById(android.R.id.list);
        mylist.setAdapter(new VivzAdapter3(getActivity()));
        return rootView;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something with the data
    }
    class events3 {
        String eventName;
        String eventTime;
        String eventVenue;
        int imageresourcetimeid;
        int imageresourcevenueid;

        events3( String eventName, String eventTime,String eventVenue,int imageresourcetimeid, int imageresourcevenueid) {
            this.eventName = eventName;
            this.eventTime = eventTime;
            this.eventVenue = eventVenue;
            this.imageresourcetimeid=imageresourcetimeid;
            this.imageresourcevenueid=imageresourcevenueid;
        }

    }
    class VivzAdapter3 extends BaseAdapter {
        ArrayList<events3> list3;
        Context context3;

        VivzAdapter3(Context context3) {
            this.context3 = context3;
            list3 = new ArrayList<events3>();
            Resources res = context3.getResources();
            String[] temp = res.getStringArray(R.array.eventsname);
            String[] temp1 = res.getStringArray(R.array.eventstime);
            String[] temp2 = res.getStringArray(R.array.eventsvenue);
            int imageresourcetimeid=R.drawable.ic_access_alarms_black_24dp;
            int imageresourcevenueid=R.drawable.ic_place_black_24dp;
            for (int ii = 0; ii < 9; ii++) {
                events3 tempevent = new events3( temp[ii],temp1[ii],temp2[ii],imageresourcetimeid,imageresourcevenueid);
                list3.add(tempevent);
            }


        }

        @Override
        public int getCount() {
            return list3.size();
        }

        @Override
        public Object getItem(int i) {
            return list3.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        class viewHolder3 {
            TextView tv;
            TextView tv1;
            TextView tv2;
            ImageView iv;
            ImageView iv1;
            viewHolder3(View v3) {
                tv = (TextView) v3.findViewById(R.id.textView);
                tv1 = (TextView) v3.findViewById(R.id.textView1);
                tv2 = (TextView) v3.findViewById(R.id.textView2);
                iv =  (ImageView) v3.findViewById(R.id.image1);
                iv1 =  (ImageView) v3.findViewById(R.id.image2);
            }
        }

        @Override
        public View getView(int i, View view3, ViewGroup viewGroup) {
            View row3 = view3;
            viewHolder3 holder3 = null;
            if (row3 == null) {
                LayoutInflater inflater3 = (LayoutInflater) context3.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row3 = inflater3.inflate(R.layout.singlelist, viewGroup, false);
                holder3 = new viewHolder3(row3);
                row3.setTag(holder3);
            } else {
                holder3 = (viewHolder3) row3.getTag();
            }
            events3 dummy = list3.get(i);
            holder3.tv.setText(dummy.eventName);
            holder3.tv1.setText(dummy.eventTime);
            holder3.tv2.setText(dummy.eventVenue);
            holder3.iv.setImageResource(dummy.imageresourcetimeid);
            holder3.iv1.setImageResource(dummy.imageresourcevenueid);
            return row3;
        }
    }
}
