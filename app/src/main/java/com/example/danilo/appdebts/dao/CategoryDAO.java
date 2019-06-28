package com.example.danilo.appdebts.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.Classes.Category;
import com.example.danilo.appdebts.Database.ScriptDLL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 27/06/19.
 */

public class CategoryDAO {
    private SQLiteDatabase mConnection;
    public CategoryDAO(SQLiteDatabase conection){
        mConnection = conection;
    }
    public void insert(Category cat){
        ContentValues contentValues = new ContentValues();
        contentValues.put( "tipo",cat.getType());
        mConnection.insertOrThrow( "categoria",null, contentValues);
        Log.d("CategoryDAO","Inserção realizada com sucesso!");

    }
    public void remove(long id){
        String[] params =  new String[1];
        params[0] = String.valueOf(id);
        mConnection.delete("categoria","id = ?",params);
    }
    public void alter(Category cat){
        ContentValues contentValues = new ContentValues();
        contentValues.put("tipo",cat.getType());
        String[] params = new String[1];
        params[0] = String.valueOf(cat.getId());
        mConnection.update("categoria",contentValues,"id = ?",params);
    }
    public List<Category> listCategories() {
        List<Category> categories = new ArrayList<Category>();
        Cursor result = mConnection.rawQuery(ScriptDLL.getCategories(), null);
        if (result.getCount() > 0) {
            result.moveToFirst();
            do {
                Category cat = new Category();
                cat.setId(result.getLong(result.getColumnIndexOrThrow("id")));
                cat.setType(result.getString(result.getColumnIndexOrThrow("tipo")));
                categories.add(cat);
                Log.d("CategoriaDAO", "Id: " + cat.getId() + ", Nome: " + cat.getType());
            } while (result.moveToNext());
            result.close();

        }
    }
    public Category getCategory(int id){
        Category cat = new Category();
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        Cursor result = mConnection.rawQuery("Select * from categoria where id = ?",params);
        if(result.getCount()>0){
            result.moveToFirst();
            cat.setId(result.getInt(result.getColumnIndexOrThrow("id")));
            cat.setType(result.getString(result.getColumnIndexOrThrow("tipo")));
            result.close();
            return cat;
        }
        return null;
    }
}