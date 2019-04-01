package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Modul4RecycleViewAdapter extends RecyclerView.Adapter<Modul4RecycleViewAdapter.ViewHolder> {
    private ArrayList<String> llistitem, llistjumlah, llistsajian;
    private Context mcontext;

    public Modul4RecycleViewAdapter(Context context, ArrayList<String> listitem, ArrayList<String> listjumlah, ArrayList<String> listsajian){
        llistitem = listitem;
        llistjumlah = listjumlah;
        llistsajian = listsajian;

        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_modul4menuitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemmenu.setText(llistitem.get(i));
        viewHolder.itemjumlah.setText(llistjumlah.get(i));
        viewHolder.itemsajian.setText(llistsajian.get(i));

        final Intent intent = new Intent(mcontext, Modul4isimenu.class);
        intent.putExtra("index", i);
        intent.putExtra("menuselect", llistitem.get(i));
        intent.putExtra("jumlahmenu", llistjumlah.get(i));
        intent.putExtra("sajian", llistsajian.get(i));

        viewHolder.itemmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) mcontext).startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return llistitem.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout itemrelativ;
        public TextView itemmenu;
        public TextView itemjumlah;
        public TextView itemsajian;
        public ViewHolder(View itemView){
            super(itemView);
            itemrelativ = itemView.findViewById(R.id.itemrelativ);
            itemmenu = itemView.findViewById(R.id.itemmenu);
            itemjumlah = itemView.findViewById(R.id.itemjumlah);
            itemsajian = itemView.findViewById(R.id.itemsajian);
        }

    }
}

