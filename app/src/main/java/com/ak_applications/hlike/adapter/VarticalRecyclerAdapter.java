package com.ak_applications.hlike.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ak_applications.hlike.Interfaces.OnVarticalClick;
import com.ak_applications.hlike.R;
import com.ak_applications.hlike.data.RowData;
import com.ak_applications.hlike.data.VarticalData;

import java.util.ArrayList;

public class VarticalRecyclerAdapter extends RecyclerView.Adapter<VarticalRecyclerAdapter.VarticalViewHolder>
{

    private ArrayList<VarticalData> list;
    private Context context;
    private OnVarticalClick onVarticalClick;

    public VarticalRecyclerAdapter(ArrayList<VarticalData> list, Context context, OnVarticalClick onVerticalClick) {
        this.list = list;
        this.context = context;
        this.onVarticalClick = onVerticalClick;
    }

    @NonNull
    @Override
    public VarticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vartical_recycler_item, parent, false);
        return new VarticalViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VarticalRecyclerAdapter.VarticalViewHolder holder, int position) {

        holder.VRVtxtl.setText(list.get(position).getName());
        setRecyclerView(holder, list.get(position),list);

    }

    private void setRecyclerView(VarticalViewHolder holder, VarticalData varticalRVData,ArrayList<VarticalData> list) {
        ArrayList<RowData> list2=varticalRVData.getLiist();
        RecyclerView hrv=holder.HRV;
        HorizontalRecyclerAdapter
                adapter = new HorizontalRecyclerAdapter(list2, context, onVarticalClick,this,list);
        hrv.setLayoutManager(new GridLayoutManager(context, 4));
        hrv.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public void updateData(ArrayList<VarticalData> list) {
        this.list=list;
        notifyDataSetChanged();
    }

    class VarticalViewHolder extends RecyclerView.ViewHolder
    {
        private TextView VRVtxtl;
        RecyclerView HRV;

        public VarticalViewHolder(@NonNull View itemView) {
            super(itemView);
            VRVtxtl = itemView.findViewById(R.id.VLTxt);
            HRV = itemView.findViewById(R.id.HRecycler);
        }
    }
}
