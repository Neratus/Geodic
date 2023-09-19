package com.example.geodic.NATION;

public class NATION {
    public int id;
   public String name;
 public String englname;
   public String population;
   public String language;
   public String englanguage;
  public   String residention;
    public String engresidention;
    public String religion;
    public String engreligion;

    public String getName() {
        return name;
    }


    public static final String TABLE_NAME="Nations";

    public static final String FIELD_ID="id";

    public static final String FIELD_NAME="name";
    public static final String FIELD_ENGLNAME="englname";

    public static final String FIELD_POPULATION="population";

    public static final String FIELD_LANGUAGE="language";
    public static final String FIELD_ENGLANGUAGE="englanguage";

    public static final String FIELD_RESIDENTION="residention";
    public static final String FIELD_ENGLRESIDENTION="engresidention";

    public static final String FIELD_RELIGION="religion";
    public static final String FIELD_ENGLRELIGION="engreligion";



    public static final String FIELD_ID_TYPE="INTEGER PRIMARY KEY";

    public static final String FIELD_NAME_Type="TEXT";
    public static final String FIELD_ENGLNAME_TYPE="TEXT";

    public static final String FIELD_POPULATION_Type="TEXT";

    public static final String FIELD_LANGUAGE_Type="TEXT";
    public static final String FIELD_ENGLANGUAGE_Type="TEXT";

    public static final String FIELD_RESIDENTION_Type="TEXT";
    public static final String FIELD_ENGLRESIDENTION_Type="TEXT";

    public static final String FIELD_RELIGION_Type="TEXT";
    public static final String FIELD_ENGLRELIGION_Type="TEXT";
}
