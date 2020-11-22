package com.jesus.phonebook.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jesus.phonebook.model.Repository;
import com.jesus.phonebook.model.entity.PhoneBook;

import java.util.List;

public class PhoneBookViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<PhoneBook>> livePhoneBook;

    public PhoneBookViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        livePhoneBook = repository.getLivePhoneBook();
    }


    public LiveData<List<PhoneBook>> getAllPhoneBook() {
        return livePhoneBook;
    }

    public void insert(PhoneBook phoneBook) {
        repository.insert(phoneBook);
    }

    public void update(PhoneBook phoneBook){
        repository.update(phoneBook);
    }

    public void delete(PhoneBook phoneBook){
        repository.delete(phoneBook);
    }


    public void get(long id){
        repository.get(id);
    }
}
