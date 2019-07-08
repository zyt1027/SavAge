package com.example.savage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;

public class AlarmActivityAdapter extends ArrayAdapter {
    public AlarmActivityAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_list_item, null);
            viewHolder = new ViewHolder();

            viewHolder.time = (TextView)convertView.findViewById(R.id.txtVactivityTime);
            viewHolder.description = (TextView)convertView.findViewById(R.id.txtVDescription);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        AlarmActivity a=(AlarmActivity)getItem(position);
        viewHolder.time.setText(a.getActivityTime().toString());
        viewHolder.description.setText(a.getDescription());
        return convertView;
    }

    private class ViewHolder {
        public TextView time;
        public TextView description;
    }

}
