package com.example.gamma.lab05;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleForm (FormulariosModel movies);
    @Insert
    void insertMultipleForms (List<FormulariosModel> formulariosModelList);
    @Query("SELECT * FROM FormulariosModel WHERE formId = :formId")
    FormulariosModel fetchOneFormByFormId (int formId);
    @Update
    void updateForm (FormulariosModel formulariosModel);
    @Delete
    void deleteForm (FormulariosModel formulariosModel);
}