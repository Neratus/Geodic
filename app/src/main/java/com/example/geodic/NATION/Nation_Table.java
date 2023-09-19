package com.example.geodic.NATION;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.geodic.COUNTRIES.Country;
import com.example.geodic.NATION.NATION;
import com.example.geodic.NATION.SQL_N;

import java.util.ArrayList;
import java.util.List;

public class Nation_Table extends SQLiteOpenHelper {

    public Nation_Table(Context context) {
        super(context, "NATION", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_N.CREATE_NATION_TABLE);
        insertNation(db, "Русские", "russian", "133970800", "Русский","Russian","Россия,Украина,Казахстан,США,Германия","Russia,Ukraine,Kazakhstan,USA,Germany","Православное христианство","Orthodox Christianity");
        insertNation(db, "Немцы", "germans", "150000000", "Немецкий","German","Германия,США,Канада,Бразилия","Germany,USA,Canada,Brazil","Католическое христианство,протестантизм","Catholic Christianity,Protestantism");
        insertNation(db, "Китайцы", "chineze", "1310000000", "китайский","Chinese","Китай,Тайвань,Гонконг,Индонезия,Малайзия","China,Taiwan,Hong Kong,Indonesia,Malaysia","конфуцианство,Буддизм,Даосизм","Confucianism, Buddhism, Taoism");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_N.DROP_TABLE);
        onCreate(db);
    }

    public void insertNation(SQLiteDatabase db, String name, String englname, String pop, String lan,String engllan, String res,String englres,String reli,String englreli) {
        ContentValues values = new ContentValues();
        values.put(NATION.FIELD_NAME, name);
        values.put(NATION.FIELD_ENGLNAME,englname);
        values.put(NATION.FIELD_POPULATION, pop);
        values.put(NATION.FIELD_LANGUAGE, lan);
        values.put(NATION.FIELD_ENGLANGUAGE,engllan);
        values.put(NATION.FIELD_RESIDENTION, res);
        values.put(NATION.FIELD_ENGLRESIDENTION,englres);
        values.put(NATION.FIELD_RELIGION,reli);
        values.put(NATION.FIELD_ENGLRELIGION,englreli);
        db.insert(NATION.TABLE_NAME, null, values);
    }
    public void UpdateNation(String update_what,String update_parametr,String nation_requested){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(update_parametr,update_what);
        db.update(NATION.TABLE_NAME,values,"name = ?",new String[]{nation_requested});
    }
    public Cursor searchNation() {
        return this.getReadableDatabase().rawQuery(
                "select * from " + NATION.TABLE_NAME, null);
    }

    public ArrayList<NATION> getNation() {
        Cursor s = searchNation();
        ArrayList<NATION> nations = new ArrayList<>();
        String[] colNames = s.getColumnNames();
        int idIndex = 0, nameIndex = 1,englnameIndex=2, popIndex = 3, lanIndex = 4,engllanIndex=5, resIndex = 6,englresIndex=7,relINdex=8,englreliIndex=9;
        for (int i = 0; i < colNames.length; i++) {
            switch (colNames[i]) {
                case NATION.FIELD_ID:
                    idIndex = i;
                    break;
                case NATION.FIELD_NAME:
                    nameIndex = i;
                    break;
                case NATION.FIELD_ENGLNAME:
                    englnameIndex = i;
                    break;
                case NATION.FIELD_POPULATION:
                    popIndex = i;
                    break;
                case NATION.FIELD_LANGUAGE:
                    lanIndex = i;
                    break;
                case NATION.FIELD_ENGLANGUAGE:
                    engllanIndex = i;
                    break;
                case NATION.FIELD_RESIDENTION:
                    resIndex = i;
                    break;
                case NATION.FIELD_ENGLRESIDENTION:
                    englresIndex = i;
                    break;
                case NATION.FIELD_RELIGION:
                    relINdex = i;
                    break;
                case NATION.FIELD_ENGLRELIGION:
                    englreliIndex = i;
                    break;
            }
        }
        s.moveToFirst();
        do {
            NATION nation=new NATION();
            nation.id=s.getInt(idIndex);
            nation.name=s.getString(nameIndex);
            nation.englname=s.getString(englnameIndex);
            nation.population=s.getString(popIndex);
            nation.language=s.getString(lanIndex);
            nation.englanguage=s.getString(engllanIndex);
            nation.residention=s.getString(resIndex);
            nation.engresidention=s.getString(englresIndex);
            nation.religion=s.getString(relINdex);
            nation.engreligion=s.getString(englreliIndex);
            nations.add(nation);
        }
        while (s.moveToNext());
        s.close();
        return nations;
    }
}