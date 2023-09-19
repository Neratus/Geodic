package com.example.geodic;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geodic.COUNTRIES.Countries_Table;
import com.example.geodic.COUNTRIES.Country;
import com.example.geodic.NATION.NATION;
import com.example.geodic.NATION.Nation_Table;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Gson gson=new Gson();
    Button button;
    FloatingActionButton buttonc;
    public int Current_theme;
    public int Search_Choise;
    public int d;
    public String objective;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        buttonc=findViewById(R.id.to_chat);
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,chat.class);
                startActivity(intent);
            }
        });
Button Locate=findViewById(R.id.Locas);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
Locate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
LocationTask locationTask=new LocationTask();
locationTask.execute();
    }
});

    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_activity, null);
        AlertDialog.Builder m = new AlertDialog.Builder(this);
        Search_Choise = 0;
        m.setView(view);
        EditText editText = view.findViewById(R.id.E);
        String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
        String cancel,search,parametr_error,not_text_eror=null;
        if (DeviceLang.equalsIgnoreCase("en")) {
            cancel="Cancel";
            search="Search";
            parametr_error="You did not select a query criterion";
            not_text_eror="Enter text";
        }
        else {
            cancel="Отмена";
            search="Найти";
            parametr_error="Вы не выбрали критерий запроса";
            not_text_eror="Введите текст";
        }
        String not_text_eror1 = not_text_eror;
        m.setCancelable(true)
                .setPositiveButton(search, new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RadioButton c = view.findViewById(R.id.countries);
                        RadioButton n = view.findViewById(R.id.nations);
                        if (c.isChecked()) Search_Choise = 1;
                        else if (n.isChecked()) Search_Choise = 2;
                        objective = editText.getText().toString();
                        objective = objective.toLowerCase();
                        if ( Search_Choise ==0){
                            Toast toast = Toast.makeText(MainActivity.this, parametr_error, Toast.LENGTH_LONG);
                            toast.show();

                        }else
                        if (objective.isEmpty()) {
                            Toast toast = Toast.makeText(MainActivity.this, not_text_eror1, Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else {
                            dialog.dismiss();
                            EnterClick();

                        }
                    }
                })
                .setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        m.show();
    }


    public void EnterClick() {

        SlowTask slowTask=new SlowTask();
        slowTask.execute(objective);
    }

    public class SlowTask extends AsyncTask<String, Void, String> {
        protected ProgressDialog mProgressDialog;


        @Override
        protected String doInBackground(String... strings) {
            Intent intent = new Intent(MainActivity.this, show_activity.class);
            boolean found = false;
            objective = strings[0];
            switch (Search_Choise) {
                case 1:
                    Countries_Table table = new Countries_Table(getApplicationContext());
                    ArrayList<Country> countries = table.getCountry();
                    for (int i = 0; i < countries.size(); i++) {
                        Country d = countries.get(i);
                        String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
                        String countryname = null;
                        String count_sur=null;
                        if (DeviceLang.equalsIgnoreCase("en")) {
                            if (objective.equalsIgnoreCase(d.englTName)) {
                                found = true;
                                intent.putExtra("name", d.englTName);
                                objective = "Population: " + d.population + " man\n" +
                                        "Currency: " + d.engcurrency + "\n" +
                                        "GDP index: " + d.vvp + "dollars per capita\n" +
                                        "Square: " + d.square + "square kilometers\n" +
                                        "Celebrations: " + d.engcelebrations + "\n" +
                                        "Recomendations: " + d.engrecomendation;
                                count_sur=d.engName;
                                intent.putExtra("result", objective);
                                intent.putExtra("search", count_sur);
                            }
                        } else {
                            if (objective.equalsIgnoreCase(d.name)) {
                                found = true;
                                intent.putExtra("name", d.name);
                                objective = "Население:" + d.population + " человек\n" +
                                        "Валюта:" + d.currency + "\n" +
                                        "ВВП индекс:" + d.vvp + "долларов на душу населения\n" +
                                        "Площадь:" + d.square + " в квадратных километрах\n" +
                                        "Праздники:" + d.celebrations + "\n" +
                                        "Рекомендации" + d.recomendation;
                                count_sur=d.engName;
                                intent.putExtra("result", objective);
                                intent.putExtra("search", count_sur);
                            }
                        }

                    }

                    if (found == false) {
                        DatabaseReference mDatabase;
                        ArrayList<String> list = new ArrayList<>();
                        mDatabase = FirebaseDatabase.getInstance().getReference();
                        mDatabase.child("country").child(objective).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (!task.isSuccessful()) {
                                    Log.e("firebase", "Ошибка при получении данных", task.getException());
                                }
                                else {
                                    DataSnapshot snapshot = task.getResult();
                                    for (DataSnapshot dschild : snapshot.getChildren()) {
                                        String str0 = dschild.getValue().toString();
                                        list.add(str0);

                                    }
                                    String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
                                    String countryname = null;
                                    String count_sur=null;
                                    System.out.println(list.isEmpty());
                                    if ((DeviceLang.equalsIgnoreCase("en"))&&  (list.isEmpty()==false) ){
                                            countryname = list.get(5);
                                            objective = "Population:" + list.get(9) + " man\n" +
                                                    "Currency:" + list.get(4) + "\n" +
                                                    "GDP index:" + list.get(12) + "dollars per capita\n" +
                                                    "Square:" + list.get(11) + "square kilometers\n" +
                                                    "Celebrations:" + list.get(3) + "\n" +
                                                    "recomendations" + list.get(6);
                                            count_sur=list.get(2);
                                            intent.putExtra("result", objective);
                                            intent.putExtra("name", countryname);
                                            intent.putExtra("search", count_sur);

                                    } else {
                                        if (list.isEmpty()==false) {
                                            countryname = list.get(8);
                                            objective = "Население:" + list.get(5) + " человек\n" +
                                                    "Валюта:" + list.get(1) + "\n" +
                                                    "ВВП индекс:" + list.get(12) + "долларов на душу населения\n" +
                                                    "Площадь:" + list.get(11) + " в квадратных километрах\n" +
                                                    "Праздники:" + list.get(0) + "\n" +
                                                    "Рекомендации" + list.get(10);
                                            count_sur = list.get(2);
                                            intent.putExtra("result", objective);
                                            intent.putExtra("name", countryname);
                                            intent.putExtra("search", count_sur);
                                        }

                                    }
                                    mProgressDialog.dismiss();
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                    break;

                case 2:
                    Nation_Table tabl = new Nation_Table(getApplicationContext());
                    ArrayList<NATION> nations = tabl.getNation();
                    for (int i = 0; i < nations.size(); i++) {
                        NATION d = nations.get(i);
                        String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
                        String nation_name = null;
                        if (DeviceLang.equalsIgnoreCase("en")) {
                            if (objective.equalsIgnoreCase(d.englname)) {
                                found = true;
                                nation_name = d.englname;
                                objective = "Population:" + d.population + " man\n" +
                                        "Language:" + d.englanguage + "\n" +
                                        "Places of residence:" + d.engresidention + "\n" +
                                        "Religion:" + d.engreligion;
                                intent.putExtra("result", objective);
                                intent.putExtra("name", nation_name);
                                intent.putExtra("search", d.englname);
                            }
                        } else {
                            found = true;
                            nation_name = d.name;
                            objective = "Население:" + d.population + " человек\n" +
                                    "Язык:" + d.language + "\n" +
                                    "Места  проживания:" + d.residention + "\n" +
                                    "Религия:" + d.religion;
                            intent.putExtra("result", objective);
                            intent.putExtra("name", nation_name);
                            intent.putExtra("search", d.englname);
                        }
                    }
                    if (found == false) {
                        DatabaseReference mDatabase;
                        ArrayList<String> list = new ArrayList<>();
                        mDatabase = FirebaseDatabase.getInstance().getReference();
                        mDatabase.child("nation").child(objective).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (!task.isSuccessful()) {
                                    Log.e("firebase", "Ошибка при получении данных", task.getException());
                                }
                                else {
                                    DataSnapshot snapshot = task.getResult();
                                    for (DataSnapshot dschild : snapshot.getChildren()) {
                                        String str0 = dschild.getValue().toString();
                                        list.add(str0);

                                    }
                                    String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
                                    String nation_name = null;
                                    if ((DeviceLang.equalsIgnoreCase("en")) &&  (list.isEmpty()==false)){
                                        nation_name = list.get(1);
                                        objective = "Population:" + list.get(7) + " man\n" +
                                                "Language:" + list.get(0) + "\n" +
                                                "Places of residence:" + list.get(3) + "\n" +
                                                "Religion:" + list.get(2);

                                    } else {
                                        if (list.isEmpty()==false) {
                                            nation_name = list.get(6);
                                            objective = "Население:" + list.get(7) + " человек\n" +
                                                    "Язык:" + list.get(5) + "\n" +
                                                    "Места  проживания:" + list.get(9) + "\n" +
                                                    "Религия:" + list.get(8);
                                            intent.putExtra("result", objective);
                                            intent.putExtra("name", nation_name);
                                            intent.putExtra("search", list.get(1));
                                        }

                                    }

                                    mProgressDialog.dismiss();
                                    startActivity(intent);
                                }
                            }
                        });
                    }
            }

            mProgressDialog.dismiss();
            startActivity(intent);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(
                    MainActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
            String download_Title=null;
            if (DeviceLang.equalsIgnoreCase("en")) {
                download_Title="Downlioad...";
            }
            else download_Title="Загрузка...";
            mProgressDialog.setMessage(download_Title);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mProgressDialog.dismiss();
        }
    }
    public class LocationTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Intent intent = new Intent(MainActivity.this, show_activity.class);
            Countries_Table table = new Countries_Table(getApplicationContext());
            URL url;
            HttpURLConnection conn;
            BufferedReader rd;
            String line;
            try {
                url = new URL("https://iplist.cc/api");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = rd.readLine()) != null) {
                    objective += line;
                }
                rd.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (objective != null) {
                objective = objective.substring(73, 75);
                ArrayList<Country> countries = table.getCountry();
                for (int i = 0; i < countries.size(); i++) {
                    Country d = countries.get(i);
                    String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
                    String countryname = null;
                    if (DeviceLang.equalsIgnoreCase("en")) {
                        if (objective.equalsIgnoreCase(d.engName)) {
                            intent.putExtra("name", d.englTName);
                            objective = "Population:" + d.population + " man\n" +
                                    "Currency:" + d.engcurrency + "\n" +
                                    "GDP index:" + d.vvp + "dollars per capita\n" +
                                    "Square:" + d.square + "square kilometers\n" +
                                    "Celebrations:" + d.engcelebrations + "\n" +
                                    "Recomendations:" + d.engrecomendation;
                            countryname = d.engName;
                            intent.putExtra("result", objective);
                            intent.putExtra("search", countryname);
                        }
                    } else {
                        if (objective.equalsIgnoreCase(d.engName)) {
                            intent.putExtra("name", d.name);
                            objective = "Население:" + d.population + " человек\n" +
                                    "Валюта:" + d.currency + "\n" +
                                    "ВВП индекс:" + d.vvp + "долларов на душу населения\n" +
                                    "Площадь:" + d.square + " в квадратных километрах\n" +
                                    "Праздники:" + d.celebrations + "\n" +
                                    "Рекомендации" + d.recomendation;
                            countryname = d.engName;
                            intent.putExtra("result", objective);
                            intent.putExtra("search", countryname);
                        }
                    }


                }
            }
            if (objective==null){
                intent.putExtra("result", (String) null);
                intent.putExtra("search", (String) null);
            }
                startActivity(intent);
                return null;
            }

    }




}
