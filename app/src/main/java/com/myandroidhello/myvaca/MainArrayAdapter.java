package com.myandroidhello.myvaca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MainArrayAdapter extends ArrayAdapter<String> {
    public MainArrayAdapter(Context context, List<String> locations){
        super(context, 0 , locations);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent){
        View itemView = convertView;
        ViewHolder viewHolder;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_destination_list, parent, false);
            viewHolder = new ViewHolder(itemView);

        }else{
            viewHolder = (ViewHolder) itemView.getTag();
        }
        String name = getItem(position);
        viewHolder.locationNameTextView.setText(name);

        return itemView;
    }

    public class ViewHolder{
        TextView locationNameTextView;

        public ViewHolder(View itemView){
            locationNameTextView = itemView.findViewById(R.id.header);
        }
    }
}
