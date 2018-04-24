package com.example.gamma.lab05;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {FormulariosModel.class}, version = 1, exportSchema = false)
public abstract class FormsDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess() ;
}
