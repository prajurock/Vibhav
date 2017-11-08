package com.vibhav2k17.android.vibhav2k17;

/**
 * Created by prajwal on 28/10/17.
 */
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

import static android.R.id.list;

/**
 * Created by user on 27-10-2017.
 */

public class day2fragment extends ListFragment {
    ListView mylist2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.day2,container,false);
        mylist2 = (ListView) rootView.findViewById(list);
        mylist2.setAdapter(new VivzAdapter4(getActivity()));
        return rootView;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something with the data
    }
    class events4 {
        String eventName2;
        String eventTime2;
        String eventVenue2;
        int imageresourcetimeid;
        int imageresourcevenueid;

        events4( String eventName, String eventTime,String eventVenue,int imageresourcetimeid, int imageresourcevenueid) {
            this.eventName2 = eventName;
            this.eventTime2 = eventTime;
            this.eventVenue2 = eventVenue;
            this.imageresourcetimeid=imageresourcetimeid;
            this.imageresourcevenueid=imageresourcevenueid;
        }

    }
    class VivzAdapter4 extends BaseAdapter {
        ArrayList<events4> list4;
        Context context4;

        VivzAdapter4(Context context4) {
            this.context4 = context4;
            list4 = new ArrayList<events4>();
            Resources res = context4.getResources();
            String[] temp = res.getStringArray(R.array.eventsname2);
            String[] temp1 = res.getStringArray(R.array.eventstime2);
            String[] temp2 = res.getStringArray(R.array.eventsvenue2);
            int imageresourcetimeid=R.drawable.ic_access_alarms_black_24dp;
            int imageresourcevenueid=R.drawable.ic_place_black_24dp;
            for (int ii = 0; ii < 12; ii++) {
                events4 tempevent = new events4( temp[ii],temp1[ii],temp2[ii],imageresourcetimeid,imageresourcevenueid);
                list4.add(tempevent);
            }


        }

        @Override
        public int getCount() {
            return list4.size();
        }

        @Override
        public Object getItem(int i) {
            return list4.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        class viewHolder4 {
            TextView tv;
            TextView tv1;
            TextView tv2;
            ImageView iv;
            ImageView iv1;
            viewHolder4(View v3) {
                tv = (TextView) v3.findViewById(R.id.textView);
                tv1 = (TextView) v3.findViewById(R.id.textView1);
                tv2 = (TextView) v3.findViewById(R.id.textView2);
                iv =  (ImageView) v3.findViewById(R.id.image1);
                iv1 =  (ImageView) v3.findViewById(R.id.image2);
            }
        }

        @Override
        public View getView(int i, View view3, ViewGroup viewGroup) {
            View row4 = view3;
            viewHolder4 holder4 = null;
            if (row4 == null) {
                LayoutInflater inflater3 = (LayoutInflater) context4.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row4 = inflater3.inflate(R.layout.singlelist, viewGroup, false);
                holder4 = new viewHolder4(row4);
                row4.setTag(holder4);
            } else {
                holder4 = (viewHolder4) row4.getTag();
            }
            events4 dummy = list4.get(i);
            holder4.tv.setText(dummy.eventName2);
            holder4.tv1.setText(dummy.eventTime2);
            holder4.tv2.setText(dummy.eventVenue2);
            holder4.iv.setImageResource(dummy.imageresourcetimeid);
            holder4.iv1.setImageResource(dummy.imageresourcevenueid);
            return row4;
        }
    }
}
