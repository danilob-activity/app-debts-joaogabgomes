package com.example.danilo.appdebts.Database;

/**
 * Created by aluno on 26/06/19.
 */

public class ScriptDLL {
    public static String createTableCategory(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE categoria (");
        sql.append(" id INTEGER NOT NULL PRIMARY KEY,");
        sql.append(" tipo TEXT NOT NULL,");
        sql.append(");");
        return sql.toString();
    }

    public static String createTableDebts(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE dividas(");
        sql.append("id INTEGER NOT NULL PRIMARY KEY,");
        sql.append("cod_cat INTEGER NOT NULL,");
        sql.append("valor REAL NOT NULL,");
        sql.append("descricao TEXT NOT NULL,");
        sql.append("data_vencimento DATE NOT NULL,");
        sql.append("data_pagamento DATE,");
        sql.append("FOREIGN KEY (cod_cat) REFERENCES categoria(id));");
        return sql.toString();

    }
}
