package com.example.b1906314_buichihai

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyData (context: Context):SQLiteOpenHelper(context, "user_b1906314", null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user_b1906314(id integer primary key autoincrement not null,ten text,email text, gioitinh text, lop text, diem text)")
        p0?.execSQL("insert into user_b1906314 (ten, email, gioitinh , lop, diem)values ('Nguyễn Văn A', 'nva@gmail.com', 'Nam', 'CT27401', '8.0')")
        p0?.execSQL("insert into user_b1906314 (ten , email, gioitinh , lop, diem)values ('Trần Văn B', 'tvb@gmail.com', 'Nữ', 'CT27402', '6.0')")
        p0?.execSQL("insert into user_b1906314 (ten , email, gioitinh , lop, diem)values ('Cao Văn C', 'cvc@gmail.com', 'Nam', 'CT27403', '8.0')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}