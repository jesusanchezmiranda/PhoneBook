package com.jesus.phonebook.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jesus.phonebook.R;
import com.jesus.phonebook.model.entity.Contact;
import com.jesus.phonebook.model.entity.PhoneBook;
import com.jesus.phonebook.view.adapter.PhoneBookAdapter;
import com.jesus.phonebook.viewmodel.PhoneBookViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PhoneBookViewModel viewModel;
    private Button btAdd;
    private Intent intent;
    public static final int ACTIVITY_REQUEST_CODE = 1;
    private PhoneBook phoneBook;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra(Contact.NAME);
                String surname = data.getStringExtra(Contact.SURNAME);
                String phone = data.getStringExtra(Contact.PHONE);
                String birthdate = data.getStringExtra(Contact.BIRTHDAY);
                String location = data.getStringExtra(Contact.LOCATION);
                String street = data.getStringExtra(Contact.STREET);
                String num = data.getStringExtra(Contact.NUMBER);
                phoneBook = new PhoneBook(name, surname, phone, birthdate, location, street, num);
                viewModel.insert(phoneBook);

            }else if (resultCode == RESULT_CANCELED){
                //nada
                Toast.makeText(getApplicationContext(), R.string.Insertcanceled, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(PhoneBookViewModel.class);
        init();
    }

    private void init() {
        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Contact.class);
                startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PhoneBookAdapter adapter = new PhoneBookAdapter(MainActivity.this, new PhoneBookAdapter.PhoneBookDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllPhoneBook().observe(this, new Observer<List<PhoneBook>>() {
            @Override
            public void onChanged(List<PhoneBook> phoneBooks) {
                adapter.submitList(phoneBooks);
            }
        });
    }
}