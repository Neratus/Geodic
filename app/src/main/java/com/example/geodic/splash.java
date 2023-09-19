package com.example.geodic;

import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.geodic.COUNTRIES.Countries_Table;
import com.example.geodic.COUNTRIES.Country;
import com.example.geodic.NATION.NATION;
import com.example.geodic.NATION.Nation_Table;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class splash extends AppCompatActivity {
    private static Gson gson=new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Intent intent=new Intent(splash.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public class UpdateTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

                DatabaseReference mDatabase;
                Countries_Table table = new Countries_Table(getApplicationContext());
                ArrayList<Country> countries = table.getCountry();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("country").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Ошибка при получении данных", task.getException());
                        }
                        else {
                            DataSnapshot snapshot = task.getResult();
                            HashMap<String, HashMap<String,String>> country_names= (HashMap<String, HashMap<String, String>>) snapshot.getValue();
                            for (int i = 0; i < countries.size(); i++) {
                                Country require_update_country = countries.get(i);
                                HashMap<String, String> ab = country_names.get(require_update_country);
                                table.UpdateCountry(ab.get("population"), Country.FIELD_POPULATION, require_update_country.name);
                                table.UpdateCountry(ab.get("vvp"), Country.FIELD_VVP, require_update_country.name);
                                table.UpdateCountry(ab.get("square"), Country.FIELD_SQUARE, require_update_country.name);
                                table.UpdateCountry(ab.get("celebrations"), Country.FIELD_CELEBRATIONS, require_update_country.name);
                                table.UpdateCountry(ab.get("engcelebrations"), Country.FIELD_ENGLISH_CELEBRATIONS, require_update_country.name);
                                table.UpdateCountry(ab.get("recomendation"), Country.FIELD_RECOMENDATIONS, require_update_country.name);
                                table.UpdateCountry(ab.get("engrecomendation"), Country.FIELD_ENGLISH_RECOMENDATIONS, require_update_country.name);
                            }
                        }
                    }
                });
                Nation_Table Ntable = new Nation_Table(getApplicationContext());
                ArrayList<NATION> nations = Ntable.getNation();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("nation").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Ошибка при получении данных", task.getException());
                        }
                        else {
                            DataSnapshot snapshot = task.getResult();
                            HashMap<String, HashMap<String,String>> nation_names= (HashMap<String, HashMap<String, String>>) snapshot.getValue();
                            for (int i = 0; i < nations.size(); i++) {
                                NATION require_update_nation = nations.get(i);
                                HashMap<String, String> ab = nation_names.get(require_update_nation);
                                table.UpdateCountry(ab.get("population"), Country.FIELD_POPULATION, require_update_nation.name);
                                table.UpdateCountry(ab.get("language"), Country.FIELD_VVP, require_update_nation.name);
                                table.UpdateCountry(ab.get("englanguage"), Country.FIELD_SQUARE, require_update_nation.name);
                                table.UpdateCountry(ab.get("residention"), Country.FIELD_CELEBRATIONS, require_update_nation.name);
                                table.UpdateCountry(ab.get("engresidention"), Country.FIELD_ENGLISH_CELEBRATIONS, require_update_nation.name);
                                table.UpdateCountry(ab.get("religion"), Country.FIELD_RECOMENDATIONS, require_update_nation.name);
                                table.UpdateCountry(ab.get("engreligion"), Country.FIELD_ENGLISH_RECOMENDATIONS, require_update_nation.name);
                            }
                        }
                    }
                });


return null;
        }
    }

}
