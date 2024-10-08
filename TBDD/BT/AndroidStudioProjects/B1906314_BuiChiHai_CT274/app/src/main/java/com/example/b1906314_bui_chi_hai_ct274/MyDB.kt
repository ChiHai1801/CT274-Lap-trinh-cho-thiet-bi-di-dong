package com.example.b1906314_bui_chi_hai_ct274

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDB (context: Context): SQLiteOpenHelper(context, "users_b1906314",null,1) {
        override fun onCreate(p0: SQLiteDatabase?) {
            p0?.execSQL("create table users_b1906314(id integer primary key autoincrement not null, fullname text, email text, phone text)")
            p0?.execSQL("insert into users_b1906314(fullname,email, phone) values ('Bui chi hai','hai@gmail.com', '0987645678')")
            p0?.execSQL("insert into users_b1906314(fullname,email, phone) values ('Hai b1906314','b1906314@gmail.com', '0987564321')")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        }
    }
