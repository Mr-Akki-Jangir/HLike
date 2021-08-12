package com.ak_applications.hlike.data;

public class RowData {


    String name;
    boolean isChecked ;

    public RowData(String a, boolean b) {
        this.name=a;
        isChecked=b;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
