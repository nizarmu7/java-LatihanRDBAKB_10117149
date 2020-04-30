package com.akb.latihanrdb_10117149;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {AktivisEntity.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract AktivisDao aktivisDao();
}
