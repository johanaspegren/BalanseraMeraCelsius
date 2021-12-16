package com.aspegrenide.balanserameracelsius.support;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aspegrenide.balanserameracelsius.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class StationsAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Station> stations;
    private static LayoutInflater inflater;

    public StationsAdapter(Activity context, ArrayList<Station> stations) {
        this.context = context;
        this.stations = stations;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stations.size();
    }

    @Override
    public Station getItem(int i) {
        return stations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null ) ? inflater.inflate(R.layout.activity_listview, null): itemView;
        TextView tvStationName = (TextView) itemView.findViewById(R.id.textViewStationListItem);
        Station selectedStation = stations.get(position);
        tvStationName.setText(selectedStation.getTitle());
        return itemView;


    }
}
