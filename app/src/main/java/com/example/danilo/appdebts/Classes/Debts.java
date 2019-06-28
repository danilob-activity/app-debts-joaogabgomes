package com.example.danilo.appdebts.Classes;

/**
 * Created by aluno on 27/06/19.
 */

public class Debts {
    private long mId;
    private Category mCategory;
    private float mValue;
    private String mDescription;
    private String mpaymentDate;
    private String mPayDate;

    public Debts(){

    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public float getValue() {
        return mValue;
    }

    public void setValue(float value) {
        mValue = value;
    }

    public String getPaymentDate() {
        return mpaymentDate;
    }

    public void setPaymentDate(String mpaymentDate) {
        this.mpaymentDate = mpaymentDate;
    }

    public String getPayDate() {
        return mPayDate;
    }

    public void setPayDate(String payDate) {
        mPayDate = payDate;
    }
}
