package com.example.geodic.NATION;

import com.example.geodic.COUNTRIES.Country;

public class SQL_N {
    public static final String CREATE_NATION_TABLE="CREATE TABLE "+
            NATION.TABLE_NAME+" ("+
            NATION.FIELD_ID+" "+NATION.FIELD_ID_TYPE+" , "+
            NATION.FIELD_NAME+" "+NATION.FIELD_NAME_Type+" , "+
            NATION.FIELD_ENGLNAME+" "+NATION.FIELD_ENGLNAME_TYPE+" , "+
            NATION.FIELD_POPULATION+" "+NATION.FIELD_POPULATION_Type+" , "+
            NATION.FIELD_LANGUAGE+" "+NATION.FIELD_LANGUAGE_Type+" , "+
            NATION.FIELD_ENGLANGUAGE+" "+NATION.FIELD_ENGLANGUAGE_Type+" , "+
            NATION.FIELD_RESIDENTION+" "+NATION.FIELD_RESIDENTION_Type+" , "+
    NATION.FIELD_ENGLRESIDENTION+" "+NATION.FIELD_ENGLRESIDENTION_Type+" , "+
    NATION.FIELD_RELIGION+" "+NATION.FIELD_RELIGION_Type+" , "+
            NATION.FIELD_ENGLRELIGION+" "+NATION.FIELD_ENGLRELIGION_Type+" )";
    public static final String DROP_TABLE="DROP TABLE IF EXISTS "+NATION.TABLE_NAME;
}
