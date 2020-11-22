package com.jesus.phonebook.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.jesus.phonebook.model.entity.PhoneBook;

import java.util.List;

@Dao
public interface PhoneBookDao {

    @Delete
    void delete (PhoneBook phoneBook);

    @Query("select * from phoneBook where id = :id")
    PhoneBook get (long id);

    @Query("select * from phoneBook order by name")
    LiveData<List<PhoneBook>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PhoneBook phoneBook);

    @Update
    void update(PhoneBook phoneBook);

    @Query("select * from phoneBook order by name")
    LiveData<List<PhoneBook>> getAllLive();

}
