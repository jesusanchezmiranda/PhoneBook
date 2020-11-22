package com.jesus.phonebook.model.entity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jesus.phonebook.R;
import com.jesus.phonebook.view.MainActivity;
import com.jesus.phonebook.viewmodel.PhoneBookViewModel;

public class Contact extends AppCompatActivity {

    private PhoneBook phoneBook, pepe;
    private EditText etName, etSurname, etPhone, etBirthday, etLocation, etStreet, etNumber;
    private Button btInsert;
    private PhoneBookViewModel v;
    public static final String NAME = "NAME";
    public static final String SURNAME = "SURNAME";
    public static final String PHONE = "PHONE";
    public static final String BIRTHDAY = "BIRTHDAY";
    public static final String LOCATION = "LOCATION";
    public static final String STREET = "STREET";
    public static final String NUMBER = "NUMBER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
    }

    private void init() {
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etPhone = findViewById(R.id.etPhone);
        etBirthday = findViewById(R.id.etBirthday);
        etLocation = findViewById(R.id.etLocation);
        etStreet = findViewById(R.id.etStreet);
        etNumber = findViewById(R.id.etNumber);
        btInsert = findViewById(R.id.btInsert);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertContact();
            }
        });
    }

    private void insertContact() {
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String phone = etPhone.getText().toString();
        String birthdate = etBirthday.getText().toString();
        String location = etLocation.getText().toString();
        String street = etStreet.getText().toString();
        String number = etNumber.getText().toString();

        Intent intent = new Intent(Contact.this, MainActivity.class);

        intent.putExtra(NAME, name);
        intent.putExtra(SURNAME, surname);
        intent.putExtra(PHONE, phone);
        intent.putExtra(BIRTHDAY, birthdate);
        intent.putExtra(LOCATION, location);
        intent.putExtra(STREET, street);
        intent.putExtra(NUMBER, number);
        setResult(RESULT_OK, intent);
        finish();
    }


}