package com.example.scoremanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    public static final String CRT_TBL_STUDENTS="create table students (\n" +
            "id integer not null primary key autoincrement,\n" +
            "name varchar(50),\n" +
            "stuId long,\n" +
            "interior integer,\n" +
            "morale integer,\n" +
            "discipline integer,\n" +
            "behave integer,\n" +
            "active integer,\n" +
            "jc integer,\n" +
            "member integer,\n" +
            "cadre integer,\n" +
            "stamina integer,\n" +
            "learn integer,\n" +
            "total integer\n" +
            ")";
    public static final String INS_TBL_STUDNETS="insert into students (name,stuId,interior,morale,discipline,behave,active" +
            ",jc,member,cadre,stamina,learn,total) values ('Test',1809050000,1,1,1,1,1,1,1,1,1,1,90);";
    public DBOpenHelper(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRT_TBL_STUDENTS);
        db.execSQL(INS_TBL_STUDNETS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
