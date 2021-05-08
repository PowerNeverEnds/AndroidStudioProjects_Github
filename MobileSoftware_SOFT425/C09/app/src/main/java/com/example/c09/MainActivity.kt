package com.example.c09

//import android.R
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var mHelper: WordDBHelper? = null

    var mText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHelper =  WordDBHelper(this);    //  (1) DB 생성을 위한 객체 생성

        mText = findViewById<EditText>(R.id.edittext);
    }

    fun mOnClick(v: View) {
        val db: SQLiteDatabase
        val row: ContentValues
        when (v.getId()) {
            R.id.insert -> {
                db = mHelper!!.writableDatabase // (6) DB에 저장하기 위해 DB를 열음, DB객체리턴
                // (삽입 방법 1) insert 메서드로 삽입 – 첫번 레코드 (DML 명령어 사용)
                row = ContentValues() // (7) 한 개 레코드 삽입위한 객체 생성
                row.put("eng", "boy") // (8) 첫번 레코드의 첫번 속성의 값 삽입
                row.put("han", "머스마")
                db.insert("dic", null, row) // (9) dic 테이블에 row에 저장된 한개 레코드 DB에 저장
                // (삽입 방법 2) SQL 명령으로 삽입 – 두번째 레코드 (자바 메소드 이용)
                db.execSQL("INSERT INTO dic VALUES (null, 'girl', '가시나');")
                mHelper!!.close()
                mText!!.setText("Insert Success")
            }
            R.id.delete -> {
                db = mHelper!!.writableDatabase
                // delete 메서드로 삭제
                db.delete("dic", null, null)
                // SQL 명령으로 삭제
                //db.execSQL("DELETE FROM dic;");
                mHelper!!.close()
                mText!!.setText("Delete Success")
            }
            R.id.update -> {
                db = mHelper!!.writableDatabase
                // (방법 1) update 메서드로 갱신
                row = ContentValues()
                row.put("han", "소년") // han 속성에 대해 “머스마”를 “소년” 값으로 변경
                db.update("dic", row, "eng = 'boy'", null) // eng가 “boy”인 레코드의
                // (방법 2) SQL 명령으로 갱신
                //db.execSQL("UPDATE dic SET han = '소년' WHERE eng = 'boy';");
                mHelper!!.close()
                mText!!.setText("Update Success")
            }
            R.id.select -> {
                db = mHelper!!.readableDatabase
                val cursor: Cursor;
                // (방법 1) query 메서드로 읽기
                // cursor = db.query("dic", new String[] {"eng", "han"}, null,
                // null, null, null, null);
                // (방법 2) SQL 명령으로 읽기
                cursor = db.rawQuery("SELECT eng, han FROM dic", null) // cursor 객체에 검색된 모든 레코드 저장
                var Result = ""
                while (cursor.moveToNext()) { //한개레코드씩 읽음
                    val eng: String = cursor.getString(0)
                    val han: String = cursor.getString(1)
                    Result += "$eng = $han\n"
                }
                if (Result.length == 0) {
                    mText!!.setText("Empyt Set")
                } else {
                    mText!!.setText(Result) // 검색 레코드 출력
                }
                cursor.close()
                mHelper!!.close()
            }
        }
    }

}