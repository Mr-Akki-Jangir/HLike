package com.ak_applications.hlike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}