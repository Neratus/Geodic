package com.example.geodic.COUNTRIES;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Countries_Table extends SQLiteOpenHelper {

    public Countries_Table(Context context) {
        super(context, Country.TABLE_NAME, null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_C.CREATE_COUNTRY_TABLE);
        insertCountry(db, "Россия", "ru","Russia","146171015", "Российский Рубль","Russian Ruble","28184","17125191","1, 2, 3, 4, 5, 6 и 8 января — Новогодние каникулы;\n" +
                "7 января — Рождество Христово;" +
                "23 февраля — День защитника Отечества;" +
                "8 марта — Международный женский день;" +
                "1 мая — Праздник весны и труда;" +
                "9 мая — День Победы;" +
                "12 июня — День России;" +
                "4 ноября — День народного единства","January 1, 2, 3, 4, 5, 6, and 8 - New Year's vacations;\"+\"January 7 - Christmas Day;\" +\"February 23 - Defender of the Fatherland Day;\" +\"March 8 - International Women's Day;\" +\"May 1 - Spring and Labor Day;\" +\"May 9 - Victory Day;\" +\"June 12 - Russia Day; +\"November 4 - National Unity Day",
                "1.В российских ресторанах принято оставлять чаевые в размере 10% от стоимости заказа.\n" +
                "\n" +
                "2.Направляясь в сельскую местность можно остаться без телефонной связи. Если в пункте назначения ваш оператор бессилен, стоит приобрети сим-карту мобильной компании с хорошим приемом именно в этом регионе.\n" +
                "\n" +
                "3. Отправляясь в новый город, изучите повадки и предпочтения местного населения.\n"+"4. Если есть возможность, возьмите на прокат авто. Таким образом, вы сможете увидеть настоящую Россию, насладиться живописными особенностями дикой природы.\n" +
                "\n" +
                "5. Россия — это многонациональная страна. Несмотря на то, что на ее территории официальным языком считается русский, есть много народностей, которые разговаривают и на других языках\n" +
                "\n" +
                "6. Официальной валютой в России считается RUB, но в ходу также USD. Кредитные карты широко используются в крупных городах\n"+"7. Путешествуя по мегаполису, в качестве передвижения по городу лучше выбирать метро, так как оно убережет вас от пробок\n" +
                "\n" +
                "8. Пересекая границу России на собственном авто помните, что в баке у вас должно быть не более 20л бензина","1.In Russian restaurants it is customary to leave a tip of 10% of the cost of the order."+
       "2.Going to the countryside can be without telephone service. If your operator is helpless at your destination, get a SIM card from a cell phone company with good reception in that area." +
               "3.When you go to a new city, learn the habits and preferences of the local people."+"4. If possible, rent a car. This way, you can see the real Russia and enjoy the picturesque features of wildlife."+
        "5. Russia is a multinational country. Despite the fact that Russian is considered to be the official language, there are many nationalities who speak other languages as well"+
        "6. The official currency in Russia is RUB, but USD is also in use. Credit cards are widely used in large cities"+ "7. Travelling around the metropolis, it is better to choose the metro as your means of getting around the city, because it will save you from traffic jams."+
        "8. When crossing the border of Russia in your own car, remember that you must have no more than 20 liters of gasoline in the tank.");
        insertCountry(db, "США", "us","USA",   "331216157", "Доллар США","US dollar","65253","9519431",
                "4-й четверг ноября-День благодарения\n" +
                "25 декабря-Рождество\n" +
                "1 января-Новый год\n" +
                "3-й понедельник января-День Мартина Лютера Кинга\n" +
                "3-й понедельник февраля-Президентский день\n" +
                "Последний понедельник мая-День памяти павших\n" +
                "4 июля-День независимости\n" +
                "1-й понедельник сентября-День труда\n" +
                "2-й понедельник октября-День Колумба\n" +
                "11 ноября-День ветеранов","4th Thursday of November-Thanksgiving. December 25-Christmas January 1-New Year's Eve 3rd Monday of January-Martin Luther King Day 3rd Monday of February-President's Day Last Monday of May-Memorial Day July 4th-Independence Day 1st Monday of September-Labour Day 2nd Monday of October-Columbus Day November 11-Veterans Day",
                "Берите с собой, как наличные деньги, так и деньги на карте;стоимость билета включает в себя только перелет с 1 сумкой ручной клади. Если у вас есть багаж, вы должны, в зависимости от авиакомпании, уже заблаговременно купить билет, в стоимость которого входит багаж или оплатить багаж при регистрации на рейс;не заказывайте воду в ресторане, ее принесут вам бесплатно;не заказывайте гарнир к мясному блюду. Если вы заказали стейк, вам не надо заказывать к нему порцию картофеля или салат;Обязательно оформите туристическую страховку прежде чем ехать в путешествие в США",
                "Bring both cash and money on the card;\n" +
                        "the ticket price includes only the flight with 1 bag of hand luggage. \n" +
                        "If you have luggage, you must, depending on the airline, already buy a ticket in advance that includes luggage or pay for luggage at check-in;\n" +
                        "do not order water in the restaurant; they will bring it to you free of charge. If you ordered a steak, you should not order potatoes or salad with it;\n" +
                        "Make sure you have travel insurance before you travel to the United States");
        insertCountry(db, "Великобритания","gb" , "Great Britain" , "66273576", "фунт стерлингов","pound sterling","42379","243809",
                "25-26 декабря-Рождество и День подарков; 1 января-Новый год; 14 февраля-День Святого Валентина; с конца марта по конец апреля(дата всегда разная)-Пасха; 31 октября-Хэллоуин; Ночь с 4 на 5 ноября-Ночь Гая Фокса",
                "December 25-26-Christmas and Boxing Day; January 1-New Year's Day; February 14-Valentine's Day; End of March to end of April (the date is always different)-Easter; October 31-Halloween;November 4-5 Guy Fawkes Night",
                "Не рассчитывайте купить здесь лекарства, все необходимое берите из дома;Не везите зонт. Дожди здесь в сезон не затяжные, если будет необходимо, купите на месте, либо воспользуетесь дождевиком;" +
                        "Люди в Лондоне толерантны. Не стоит показывать удивление по поводу необычного внешнего вида и поведения людей;",
                "Do not expect to buy medicine here, take everything you need from home; Do not bring an umbrella. The rains here in the season are not prolonged, if necessary, buy on the spot, or use a raincoat; People in London are tolerant. You don't have to show surprise at people's unusual appearance and behavior;");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_C.DROP_TABLE);
        onCreate(db);
    }

    public void insertCountry(SQLiteDatabase db, String name,String englname,String fullenglname, String pop, String cur,String englcur, String VVP,String Sqr,String seleb,String englceleb, String rec,String englrec) {
        ContentValues values = new ContentValues();
        values.put(Country.FIELD_NAME, name);
        values.put(Country.FIELD_ENGLISH_NAME, englname);
        values.put(Country.FIELD_ENGLISH_FULL_NAME,fullenglname);
        values.put(Country.FIELD_POPULATION, pop);
        values.put(Country.FIELD_CURRENCY, cur);
        values.put(Country.FIELD_ENGLISH_CURRENCY,englcur);
        values.put(Country.FIELD_VVP, VVP);
        values.put(Country.FIELD_SQUARE,Sqr);
        values.put(Country.FIELD_CELEBRATIONS,seleb );
        values.put(Country.FIELD_ENGLISH_CELEBRATIONS,englceleb);
        values.put(Country.FIELD_RECOMENDATIONS, rec);
        values.put(Country.FIELD_ENGLISH_RECOMENDATIONS,englrec);
        db.insert(Country.TABLE_NAME, null, values);
    }
    public void UpdateCountry(String update_what,String update_parametr,String country_requested){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(update_parametr,update_what);
        db.update(Country.TABLE_NAME,values,"Name = ?",new String[]{country_requested});
        db.setVersion(db.getVersion()+1);
    }

    public Cursor searchCountry() {
        return this.getReadableDatabase().rawQuery("select * from "+Country.TABLE_NAME,null);
    }

    public ArrayList<Country> getCountry() {
        Cursor s = searchCountry();
        s.moveToFirst();
        ArrayList<Country> countries = new ArrayList<>();
        String[] colNames = s.getColumnNames();
        int idIndex = 0, nameIndex = 1,englnameIndex=2,fullenglnameIndex=3, popIndex = 4, curIndex = 5,englcurIndex=6, VVPIndex = 7,SQRIndex=8,CelebIndex=9,englcelebIndex=10,RecIndex=11,englnrecIndex=12;
        for (int i = 0; i < colNames.length; i++) {
            switch (colNames[i]) {
                case Country.FIELD_ID:
                    idIndex = i;
                    break;
                case Country.FIELD_NAME:
                    nameIndex = i;
                    break;
                case Country.FIELD_ENGLISH_NAME:
                    englnameIndex = i;
                    break;
                case Country.FIELD_ENGLISH_FULL_NAME:
                    fullenglnameIndex = i;
                    break;
                case Country.FIELD_POPULATION:
                    popIndex = i;
                    break;
                case Country.FIELD_CURRENCY:
                    curIndex = i;
                    break;
                case Country.FIELD_ENGLISH_CURRENCY:
                    englcurIndex = i;
                    break;
                case Country.FIELD_VVP:
                    VVPIndex = i;
                    break;
                case Country.FIELD_SQUARE:
                    SQRIndex = i;
                    break;
                case Country.FIELD_CELEBRATIONS:
                    CelebIndex = i;
                    break;
                case Country.FIELD_ENGLISH_CELEBRATIONS:
                    englcelebIndex = i;
                    break;
                case Country.FIELD_RECOMENDATIONS:
                    RecIndex = i;
                    break;
                case Country.FIELD_ENGLISH_RECOMENDATIONS:
                    englnrecIndex = i;
                    break;
            }
        }

        s.moveToFirst();
        do {
            Country country=new Country();
            country.id=s.getInt(idIndex);
            country.name=s.getString(nameIndex);
            country.engName=s.getString(englnameIndex);
            country.englTName=s.getString(fullenglnameIndex);
            country.population=s.getString(popIndex);
            country.currency=s.getString(curIndex);
            country.engcurrency=s.getString(englcurIndex);
            country.vvp=s.getString(VVPIndex);
            country.square=s.getString(SQRIndex);
            country.celebrations=s.getString(CelebIndex);
            country.engcelebrations=s.getString(englcelebIndex);
            country.recomendation=s.getString(RecIndex);
            country.engrecomendation=s.getString(englnrecIndex);
            countries.add(country);
        }
        while (s.moveToNext());
        s.close();

return countries;
    }
}