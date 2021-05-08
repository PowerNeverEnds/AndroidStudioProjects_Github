package com.example.c09;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static org.xmlpull.v1.XmlPullParser.TEXT;

public class WordDBHelper extends SQLiteOpenHelper {



    // (2) DB 생성 (EngWord.db)

    public WordDBHelper(Context context) {

        super(context, "EngWord.db", null, 1);

    }



    // (3) DB내 테이블의 스키마 생성 (dic)

    // 테이블내 속성 : eng, han

    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE dic ( _id INTEGER PRIMARY KEY AUTOINCREMENT," + "eng TEXT, han TEXT);");

    }



    // 테이블 변경

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // 기존 테이블 삭제후, 동일 테이블 다시 생성

        db.execSQL("DROP TABLE IF EXISTS dic");

        onCreate(db);

    }

}