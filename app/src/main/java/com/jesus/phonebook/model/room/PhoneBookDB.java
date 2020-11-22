package com.jesus.phonebook.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jesus.phonebook.model.dao.PhoneBookDao;
import com.jesus.phonebook.model.entity.PhoneBook;

@Database(entities = {PhoneBook.class}, version = 1, exportSchema = false)
public abstract class PhoneBookDB extends RoomDatabase {

    public abstract PhoneBookDao getDao();//ROOM se encarga de hacerlo

    private static PhoneBookDB INSTANCE;

    public static PhoneBookDB getDb(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    PhoneBookDB.class, "dbphonebook").build();
        }

        return INSTANCE;
    }


}
