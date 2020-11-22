package com.jesus.phonebook.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jesus.phonebook.PhoneBookApplication;
import com.jesus.phonebook.model.dao.PhoneBookDao;
import com.jesus.phonebook.model.entity.PhoneBook;
import com.jesus.phonebook.model.room.PhoneBookDB;

import java.util.List;

public class Repository {

    //acceso a la bd
    PhoneBookDB db;

    //acceso a acada una de las tablas
    private PhoneBookDao phoneBookDao;

    private LiveData<List<PhoneBook>> livePhoneList;


    public Repository(Application context){
        db = PhoneBookDB.getDb(context);
        phoneBookDao = db.getDao();

        //LiveData: carga de datos en segundo plano
        livePhoneList = phoneBookDao.getAllLive();
    }


    public LiveData<List<PhoneBook>> getLivePhoneBook() {
        return livePhoneList;
    }

    public void insert(PhoneBook phoneBook){
        //sin lambda expresion
        PhoneBookApplication.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                phoneBookDao.insert(phoneBook);
            }
        });
    }

    public void update( PhoneBook phoneBook){
        PhoneBookApplication.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                phoneBookDao.update(phoneBook);
            }
        });
    }

    public void delete( PhoneBook phoneBook){
        PhoneBookApplication.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                phoneBookDao.delete(phoneBook);
            }
        });
    }



    public void get( long id){
        PhoneBookApplication.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                phoneBookDao.get(id);
            }
        });
    }


}
