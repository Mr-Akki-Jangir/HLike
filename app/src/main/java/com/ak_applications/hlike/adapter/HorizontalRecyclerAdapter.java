package com.ak_applications.hlike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ak_applications.hlike.Interfaces.OnVarticalClick;
import com.ak_applications.hlike.R;
import com.ak_applications.hlike.data.RowData;
import com.ak_applications.hlike.data.VarticalData;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.HoriViewHolder> {

    private ArrayList<RowData> list;
    private Context context;
    private OnVarticalClick onVerticalClick;
    VarticalRecyclerAdapter viewHolder;
    ArrayList<VarticalData> list2;

    public HorizontalRecyclerAdapter(ArrayList<RowData> list, Context context, OnVarticalClick onVerticalClick, VarticalRecyclerAdapter viewHolder, ArrayList<VarticalData> list2) {
        this.list = list;
        this.context = context;
        this.onVerticalClick = onVerticalClick;
        this.viewHolder = viewHolder;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public HoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.h_recycle_item, parent, false);
        return new HoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRecyclerAdapter.HoriViewHolder holder, int position) {

        holder.RowTxt.setText(list.get(position).getName());
        if (list.get(position).isChecked()) {
            holder.HrtChk.setChecked(true);
        } else {
            holder.HrtChk.setChecked(false);
        }

        holder.HrtChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    if (list.get(position).isChecked()) {
                        onVerticalClick.onVertClick(list.get(position).getName(), b);
                        list.get(position).setChecked(b);
                        updateNotify(list.get(position));
                    }
                }else {
                    onVerticalClick.onVertClick(list.get(position).getName(), b);
                    list.get(position).setChecked(b);
                    updateNotify(list.get(position));
                }

            }
        });

    }

    private void updateNotify(RowData rowData) {
        ArrayList<VarticalData> data = this.list2;
        for (int i = 0; i < data.size(); i++) {
            ArrayList<RowData> data2 = data.get(i).getLiist();
            for (int j = 0; j < this.list2.size(); j++) {
                if (rowData.getName().equalsIgnoreCase(data2.get(j).getName())) {
                    data2.get(j).setChecked(rowData.isChecked());
                }

            }
//            data.get(i).setLiist(data2);
            this.list2.get(i).setLiist(data2);

        }
        viewHolder.updateData(this.list2);
//        this.notifyDataSetChanged();
//        this.viewHolder.notifyAll();
//        viewHolder.notifyAll();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class HoriViewHolder extends RecyclerView.ViewHolder
    {
        private TextView RowTxt;
        MaterialCheckBox HrtChk;

        public HoriViewHolder(@NonNull View itemView) {
            super(itemView);
            RowTxt = itemView.findViewById(R.id.HItemTxt);
            HrtChk = itemView.findViewById(R.id.HLikeBtn);

        }
    }
}
