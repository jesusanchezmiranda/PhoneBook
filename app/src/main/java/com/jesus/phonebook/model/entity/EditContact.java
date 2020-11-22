package com.jesus.phonebook.model.entity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jesus.phonebook.R;
import com.jesus.phonebook.view.MainActivity;
import com.jesus.phonebook.view.adapter.PhoneBookAdapter;
import com.jesus.phonebook.viewmodel.PhoneBookViewModel;

import java.util.List;

public class EditContact extends AppCompatActivity {

    private Intent intent;
    private EditText etName2, etSurname2, etPhone2, etBirthday2, etLocation2, etStreet2, etNumber2;
    private Button btUpdate, btDelete;
    private String name, surname, phone, birthday,location, street, number;
    private String name2, surname2, phone2, birthday2,location2, street2, number2;
    private PhoneBook phoneBook;
    private PhoneBookViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        viewModel = new ViewModelProvider(this).get(PhoneBookViewModel.class);
        init();
    }

    private void init() {

        etName2 = findViewById(R.id.etName2);
        etSurname2 = findViewById(R.id.etSurname2);
        etPhone2 = findViewById(R.id.etPhone2);
        etBirthday2 = findViewById(R.id.etBirthday2);
        etLocation2 = findViewById(R.id.etLocation2);
        etStreet2 = findViewById(R.id.etStreet2);
        etNumber2 = findViewById(R.id.etNumber2);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);

        intent = getIntent();
        name = intent.getStringExtra(PhoneBookAdapter.NAME);
        surname = intent.getStringExtra(PhoneBookAdapter.SURNAME);
        phone = intent.getStringExtra(PhoneBookAdapter.PHONE);
        birthday = intent.getStringExtra(PhoneBookAdapter.BIRTHDAY);
        location = intent.getStringExtra(PhoneBookAdapter.LOCATION);
        street = intent.getStringExtra(PhoneBookAdapter.STREET);
        number = intent.getStringExtra(PhoneBookAdapter.NUMBER);

        long id = intent.getLongExtra(PhoneBookAdapter.ID,0);
        viewModel.get(id);

        etName2.setText(name);
        etSurname2.setText(surname);
        etPhone2.setText(phone);
        etBirthday2.setText(birthday);
        etLocation2.setText(location);
        etStreet2.setText(street);
        etNumber2.setText(number);
        phoneBook = new PhoneBook(name, surname, phone, birthday, location, street, number);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditContact.this, "UPDATE", Toast.LENGTH_SHORT).show();
                name2 = etName2.getText().toString();
                surname2 = etSurname2.getText().toString();
                phone2 = etPhone2.getText().toString();
                birthday2 = etBirthday2.getText().toString();
                location2 = etLocation2.getText().toString();
                street2 = etStreet2.getText().toString();
                number2 = etNumber2.getText().toString();
                phoneBook.setId(id);
                phoneBook.setName(name2);
                phoneBook.setSurname(surname2);
                phoneBook.setPhone(phone2);
                phoneBook.setBirthdate(birthday2);
                phoneBook.setLocation(location2);
                phoneBook.setStreet(street2);
                phoneBook.setNumber(number2);
                viewModel.update(phoneBook);
                Intent u = new Intent(EditContact.this, MainActivity.class);
                startActivity(u);
                finish();
            }
        });


        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditContact.this, "DELETE", Toast.LENGTH_SHORT).show();
                phoneBook.setId(id);
                viewModel.delete(phoneBook);
                Intent i = new Intent(EditContact.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}