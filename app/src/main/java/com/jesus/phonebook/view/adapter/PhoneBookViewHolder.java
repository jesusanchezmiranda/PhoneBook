package com.jesus.phonebook.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesus.phonebook.R;


public class PhoneBookViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvName;

    public PhoneBookViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvName = itemView.findViewById(R.id.tvName);
    }

    public void bind(String text) {
        tvName.setText(text);
    }

    static PhoneBookViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new PhoneBookViewHolder(view);
    }

}
