package com.example.sqlite_project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="items.db";
    public static final String TABLE_NAME="items_table";
    public static final String COL1="id";
    public static final String COL2="image";
    public static final String COL3="name";
    public static final String COL4="description";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "IMAGE BLOB, " +
                "NAME TEXT, " +
                "DESCRIPTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String id,byte[] image,String name,String description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2 ,image);
        contentValues.put(COL3,name);
        contentValues.put(COL4,description);
        Long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from " +TABLE_NAME,null);
        return cursor;

    }

    public boolean updateData(String id ,byte[] image,String name , String description){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2 ,image);
        contentValues.put(COL3,name);
        contentValues.put(COL4,description);

        sqLiteDatabase.update(TABLE_NAME ,contentValues,"ID=?",new String[]{id});
        return true;
    }

    public  Integer deleteData(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete(TABLE_NAME,"ID=?",new String[]{id});
    }

}
