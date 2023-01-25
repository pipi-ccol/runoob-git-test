package com.djht.fourteenth_session.DSQ.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 梅 on 2022/5/17.
 */

/**
 * 数据库的表创建时，可以将其提取出为一个实体类，
 * 通过静态字符串调用来指定表名字段名，
 * 方便于其他查询时获取属性值名称，提高容错率
 */
public class DBService extends SQLiteOpenHelper {

    //db.execSQL("update card set record='2022-09-03' where id=1;");

    public DBService(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(DIARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion){
            case 1:
                break;
            default:
                break;
        }
    }

}

