package com.example.shadesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ShadeListFragment.ShadeSelectedListener{

    private static final String SHARED_PREFS = "shared_prefs";
    private static final String SELECTED_SHADE = "selected_shade";
    private static final String SELECTED_POS = "selected_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onShadeSelected(Shade shade, int position) {

        saveSelectedShade(shade, position);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            transaction.replace(R.id.portrait_container, ShadeDetailFragment.newInstance(shade.getDescription(), shade.getColorID())).commit();
        }
        else{
            transaction.replace(R.id.shade_detail_container, ShadeDetailFragment.newInstance(shade.getDescription(), shade.getColorID())).commit();
        }
        Toast.makeText(this, shade.getName() + " Selected", Toast.LENGTH_SHORT).show();
    }

    private void saveSelectedShade(Shade shade, int position) {
        Gson gson = new Gson();
        String selectedShadeJSON = gson.toJson(shade);
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SELECTED_POS, position);
        editor.putString(SELECTED_SHADE, selectedShadeJSON).apply();
    }

    public Shade getSelectedShade(){
        Gson gson = new Gson();
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String selectedShadeJSON = preferences.getString(SELECTED_SHADE, "");
        if(selectedShadeJSON.equals("")) return new Shade(ShadesDB.shades[0], ShadesDB.descriptions[0], ShadesDB.hexes[0]);
        return gson.fromJson(selectedShadeJSON, Shade.class);
    }

    public int getSelectedPosition(){
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return preferences.getInt(SELECTED_POS, 0);
    }
}