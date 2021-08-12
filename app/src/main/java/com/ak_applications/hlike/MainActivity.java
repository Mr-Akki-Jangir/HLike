package com.ak_applications.hlike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.ak_applications.hlike.Interfaces.OnVarticalClick;
import com.ak_applications.hlike.adapter.VarticalRecyclerAdapter;
import com.ak_applications.hlike.data.RowData;
import com.ak_applications.hlike.data.VarticalData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnVarticalClick {


    private VarticalRecyclerAdapter VAdapter;
    private ArrayList<RowData> list2 = new ArrayList<>();

    private ArrayList<VarticalData> list =new ArrayList<>();

    private String TAG = "MainActivity=>";

    private ArrayList<VarticalData> addData2() {

        ArrayList<RowData> listA = new ArrayList<>();
        listA.add(new RowData("A", false));
        listA.add(new RowData("D", false));
        listA.add(new RowData("C", false));
        listA.add(new RowData("B", false));
        list.add(new VarticalData("0",listA));

        ArrayList<RowData> listB = new ArrayList<>();

        listB.add(new RowData("D", false));
        listB.add(new RowData("X", false));
        listB.add(new RowData("A", false));
        listB.add(new RowData("Y", false));
        list.add(new VarticalData("1",listB));

        ArrayList<RowData> listC = new ArrayList<>();

        listC.add(new RowData("C", false));
        listC.add(new RowData("B", false));
        listC.add(new RowData("W", false));
        listC.add(new RowData("Z", false));
        list.add(new VarticalData("2",listC));

        ArrayList<RowData> listD = new ArrayList<>();

        listD.add(new RowData("Z", false));
        listD.add(new RowData("X", false));
        listD.add(new RowData("Y", false));
        listD.add(new RowData("D", false));
        list.add(new VarticalData("3",listD));

        return list;

    }

    private RecyclerView VerticalRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=addData2();
        VerticalRV = findViewById(R.id.VarticalRecycler);
        if (list == null) return;
        VAdapter = new VarticalRecyclerAdapter(list, this, this);
        VerticalRV.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        VerticalRV.setAdapter(VAdapter);
        VAdapter.notifyDataSetChanged();





    }

    @Override
    public void onVertClick(String name, boolean isChecked) {
        Log.e(TAG, "onVertClick: Name=>" + name + "\nisChecked=>" + isChecked);

    }
}