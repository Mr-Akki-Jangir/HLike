package com.ak_applications.hlike.data;

import java.util.ArrayList;

public class VarticalData {

    private String name;
    private ArrayList<RowData> liist;

    public VarticalData(String s, ArrayList<RowData> listA) {
        this.name=s;
        this.liist=listA;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<RowData> getLiist() {
        return liist;
    }

    public void setLiist(ArrayList<RowData> liist) {
        this.liist = liist;
    }
}
