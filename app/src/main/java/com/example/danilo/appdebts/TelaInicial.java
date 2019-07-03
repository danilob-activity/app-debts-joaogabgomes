package com.example.danilo.appdebts;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.danilo.appdebts.Classes.Category;
import com.example.danilo.appdebts.Database.DataBaseHelper;
import com.example.danilo.appdebts.dao.CategoryDAO;

public class TelaInicial extends AppCompatActivity {

    private SQLiteDatabase mConection;
    private DataBaseHelper mDataHelper;
    private ConstraintLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        mLayout = findViewById(R.id.layout);


        createConnection();
        Category cat = new Category("Tia do Lanche");
        CategoryDAO catDao = new CategoryDAO(mConection);
        catDao.insert(cat);
        catDao.listCategories();
        mConection.close();
    }

    private void createConnection() {
        try {
            mDataHelper = new DataBaseHelper(this);
            mConection = mDataHelper.getWritableDatabase();
            Snackbar.make(mLayout, R.string.sucess_conection, Snackbar.LENGTH_LONG).show();
        } catch (SQLException e) {
            Snackbar.make(mLayout, e.toString(), Snackbar.LENGTH_LONG).show();
        }
    }

}
