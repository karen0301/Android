package com.example.colorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_ContacName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__contac_name);
    }

    public void back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
}
