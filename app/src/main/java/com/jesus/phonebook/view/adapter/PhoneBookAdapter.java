package com.jesus.phonebook.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.jesus.phonebook.model.entity.EditContact;
import com.jesus.phonebook.model.entity.PhoneBook;



public class PhoneBookAdapter extends ListAdapter<PhoneBook, PhoneBookViewHolder> {

    private Context context;
    public static final String NAME = "NAME";
    public static final String SURNAME = "SURNAME";
    public static final String PHONE = "PHONE";
    public static final String BIRTHDAY = "BIRTHDAY";
    public static final String LOCATION = "LOCATION";
    public static final String STREET = "STREET";
    public static final String NUMBER = "NUMBER";
    public static final String ID = "ID";

    public PhoneBookAdapter(Context context, @NonNull DiffUtil.ItemCallback<PhoneBook> diffCallback) {
        super(diffCallback);
        this.context = context;
    }

    public PhoneBookAdapter(@NonNull AsyncDifferConfig<PhoneBook> config) {
        super(config);
    }

    @NonNull
    @Override
    public PhoneBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PhoneBookViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneBookViewHolder holder, int position) {
        PhoneBook pos = getItem(position);
        holder.bind(pos.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditContact.class);
                intent.putExtra(ID, pos.getId());
                intent.putExtra(NAME, pos.getName());
                intent.putExtra(SURNAME, pos.getSurname());
                intent.putExtra(PHONE, pos.getPhone());
                intent.putExtra(BIRTHDAY, pos.getBirthdate());
                intent.putExtra(LOCATION, pos.getLocation());
                intent.putExtra(STREET, pos.getStreet());
                intent.putExtra(NUMBER, pos.getNumber());
                context.startActivity(intent);
            }
        });
    }

    public static class PhoneBookDiff extends DiffUtil.ItemCallback<PhoneBook> {

        @Override
        public boolean areItemsTheSame(@NonNull PhoneBook oldItem, @NonNull PhoneBook newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull PhoneBook oldItem, @NonNull PhoneBook newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }


}
