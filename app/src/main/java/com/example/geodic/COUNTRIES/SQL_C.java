package com.example.geodic.COUNTRIES;

public class SQL_C {
    public static final String CREATE_COUNTRY_TABLE="CREATE TABLE "+
            Country.TABLE_NAME+" ("+
            Country.FIELD_ID+" "+Country.FIELD_ID_TYPE+" , "+
            Country.FIELD_NAME+" "+Country.FIELD_NAME_Type+" , "+
            Country.FIELD_ENGLISH_NAME+" "+Country.FIELD_ENGLISH_NAME_TYPE+" , "+
            Country.FIELD_ENGLISH_FULL_NAME+" "+Country.FIELD_ENGLISH_NAME_FULL_TYPE+" , "+
            Country.FIELD_POPULATION+" "+Country.FIELD_POPULATION_Type+" , "+
            Country.FIELD_CURRENCY+" "+Country.FIELD_CURRENCY_Type+" , "+
            Country.FIELD_ENGLISH_CURRENCY+" "+Country.FIELD_ENGLISH_CURRENCY_TYPE+" , "+
            Country.FIELD_VVP+" "+Country.FIELD_VVP_Type+" , "+
            Country.FIELD_SQUARE+" "+Country.FIELD_SQUARE_TYPE+" , "+
            Country.FIELD_CELEBRATIONS+" "+Country.FIELD_CELEBRATIONS_TYPE+" , "+
            Country.FIELD_ENGLISH_CELEBRATIONS+" "+Country.FIELD_ENGLISH_CELEBRATIONS_TYPE+" , "+
            Country.FIELD_RECOMENDATIONS+" "+Country.FIELD_RECOMENDATIONS_TYPE+" , "+
            Country.FIELD_ENGLISH_RECOMENDATIONS+" "+Country.FIELD_ENGLISH_RECOMENDATIONS_TYPE+" )";
    public static final String DROP_TABLE="DROP TABLE IF EXISTS "+Country.TABLE_NAME;
}
