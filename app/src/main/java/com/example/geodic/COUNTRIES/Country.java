package com.example.geodic.COUNTRIES;

public class Country {
    public int id;
    public String name;
    public String englTName;
    public String engName;
   public String population;
   public String currency;
   public String engcurrency;
    public String vvp;
   public String square;
   public String celebrations;
   public String engcelebrations;
    public String recomendation;
   public String engrecomendation;

    public String getName() {
        return name;
    }



    public static final String TABLE_NAME="Countries";
    public static final String FIELD_ID="id";

    public static final String FIELD_NAME="Name";
    public static final String FIELD_ENGLISH_NAME="EngName";
    public static final String FIELD_ENGLISH_FULL_NAME="EnglTName";

    public static final String FIELD_SQUARE="Square";

    public static final String FIELD_CELEBRATIONS="Celebrations";
    public static final String FIELD_ENGLISH_CELEBRATIONS="Engcelebrations";

    public static final String FIELD_RECOMENDATIONS="Recomended";
    public static final String FIELD_ENGLISH_RECOMENDATIONS="Engrecomendation";

    public static final String FIELD_POPULATION="population";

    public static final String FIELD_CURRENCY="currency";
    public static final String FIELD_ENGLISH_CURRENCY="Engcurrency";

    public static final String FIELD_VVP="VVP";




    public static final String FIELD_ID_TYPE="INTEGER PRIMARY KEY";

    public static final String FIELD_NAME_Type="TEXT";
    public static final String FIELD_ENGLISH_NAME_TYPE="TEXT";
    public static final String FIELD_ENGLISH_NAME_FULL_TYPE="TEXT";

    public static final String FIELD_SQUARE_TYPE="TEXT";

    public static final String FIELD_CELEBRATIONS_TYPE="TEXT";
    public static final String FIELD_ENGLISH_CELEBRATIONS_TYPE="TEXT";

    public static final String FIELD_RECOMENDATIONS_TYPE="TEXT";
    public static final String FIELD_ENGLISH_RECOMENDATIONS_TYPE="TEXT";

    public static final String FIELD_POPULATION_Type="TEXT";

    public static final String FIELD_CURRENCY_Type="TEXT";
    public static final String FIELD_ENGLISH_CURRENCY_TYPE="TEXT";

    public static final String FIELD_VVP_Type="TEXT";
}
