package com.example.asuspc.medmyths.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asuspc.medmyths.R;

/**
 * Created by asus pc on 21/03/2018.
 */

public class MedicalInfoAdapter extends ArrayAdapter<MedicalInfo> {

    public MedicalInfoAdapter(Context context){
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.item_medical_info_card, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        MedicalInfo mi = getItem(position);

        holder.info.setText(mi.title);
        Glide.with(getContext()).load(mi.getMedImage()).into(holder.image);

        return contentView;
    }

    private static class ViewHolder {
        public TextView info;
        public ImageView image;

        public ViewHolder(View view) {
            this.info = (TextView) view.findViewById(R.id.tvTitle);
            this.image = (ImageView) view.findViewById(R.id.ivMedicalInfo);
        }
    }
}
