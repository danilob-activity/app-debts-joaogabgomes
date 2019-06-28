package com.example.danilo.appdebts.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.Classes.Debts;

/**
 * Created by aluno on 28/06/19.
 */

public class DebtsDAO {

    private SQLiteDatabase mConnection;
    public DebtsDAO(SQLiteDatabase conection){
        mConnection = conection;
    }

    public void insert(Debts debts){
        ContentValues contentValues = new ContentValues();
        contentValues.put("valor",debts.getValue());
        contentValues.put("descricao",debts.getDescription());
        contentValues.put("data_vencimento",debts.getPaymentDate());
        contentValues.put("data_pagamento",debts.getPayDate());
        contentValues.put("cod_cat",debts.getCategory().getId());
        mConnection.insertOrThrow("dividas",null,contentValues);
        Log.d("DebtsDAO","insercao realizada com sucesso");
    }

    public void remove(long id){
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        mConnection.delete("dividas","id = ?",params);
    }

    public void alter(Debts debts){
        ContentValues contentValues = new ContentValues();
        contentValues.put("valor",debts.getValue());
        contentValues.put("descricao",debts.getDescription());
        contentValues.put("data_vencimento",debts.getPaymentDate());
        contentValues.put("data_pagamento",debts.getPayDate());
        contentValues.put("cod_cat",debts.getCategory().getId());
        String[] params = new String[1];
        params[0] = String.valueOf(debts.getId());
        mConnection.update("dividas",contentValues,"id = ?",params);
    }



}
