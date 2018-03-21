package com.example.asuspc.medmyths.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asuspc.medmyths.GameActivity;
import com.example.asuspc.medmyths.R;

import java.util.List;

/**
 * Created by asus pc on 20/03/2018.
 */

public class GameMenuAdapter extends RecyclerView.Adapter<GameMenuAdapter.MyViewHolder> {

    private Context mContext;
    private List<GameMenu> gameMenuList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView angka, level;
        public ImageView lingkaran;

        public MyViewHolder(View view){
            super(view);
            angka = (TextView) view.findViewById(R.id.tvAngka);
            level = (TextView) view.findViewById(R.id.tvLevel);
            lingkaran = (ImageView) view.findViewById(R.id.ivLingkaran);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(),GameActivity.class));
                }
            });
        }
    }

    public GameMenuAdapter(Context mContext, List<GameMenu> gameMenuList){
        this.mContext = mContext;
        this.gameMenuList = gameMenuList;
    }

    @Override
    public GameMenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_menu_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GameMenuAdapter.MyViewHolder holder, int position) {
        GameMenu gameMenu = gameMenuList.get(position);
        holder.angka.setText(String.valueOf(gameMenu.getAngka()));
        holder.level.setText(String.valueOf(gameMenu.getLevel()));
        Glide.with(mContext).load(gameMenu.getThumbnail()).into(holder.lingkaran);
    }

    @Override
    public int getItemCount() {
        return gameMenuList.size();
    }
}
