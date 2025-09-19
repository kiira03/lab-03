package com.example.listycity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditCityFragment extends DialogFragment {

    public interface EditCityDialogListener {
        void updateCity(int position, City updatedCity);
    }

    private EditCityDialogListener listener;
    private int position;
    private City city;

    public EditCityFragment(int position, City city) {
        this.position = position;
        this.city = city;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof EditCityDialogListener) {
            listener = (EditCityDialogListener) context;
        } else {
            throw new RuntimeException(context + " must implement EditCityDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_edit_city, null);
        EditText cityNameInput = view.findViewById(R.id.edit_city_name);
        EditText provinceInput = view.findViewById(R.id.edit_province_name);

        // Pre-fill with existing values
        cityNameInput.setText(city.getName());
        provinceInput.setText(city.getProvince());

        return new AlertDialog.Builder(getActivity())
                .setTitle("Edit City")
                .setView(view)
                .setPositiveButton("Save", (dialog, which) -> {
                    String newCity = cityNameInput.getText().toString();
                    String newProvince = provinceInput.getText().toString();
                    listener.updateCity(position, new City(newCity, newProvince));
                })
                .setNegativeButton("Cancel", null)
                .create();
    }
}
