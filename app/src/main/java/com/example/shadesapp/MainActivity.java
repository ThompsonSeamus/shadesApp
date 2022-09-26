package com.example.shadesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ShadeListFragment.ShadeSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onShadeSelected(Shade shade) {
        Toast.makeText(this, "Shade Selected", Toast.LENGTH_SHORT).show();
    }
}