package ru.mipt.hometask1;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

    public class FragmentMain extends Fragment {

        @Override

        public void onSaveInstanceState(Bundle OutState) {

            super.onSaveInstanceState(OutState);
            setRetainInstance(true);}

        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_main, container, false);
            final EditText placename = (EditText) view.findViewById(R.id.name);
            final EditText placesurname = (EditText) view.findViewById(R.id.surname);
            final TextView placedate = (TextView) view.findViewById(R.id.date);


            final Button save = (Button) view.findViewById(R.id.save);


            placedate.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Calendar c = Calendar.getInstance();
                            int myear = c.get(Calendar.YEAR);
                            int mmonth = c.get(Calendar.MONTH);
                            int mday = c.get(Calendar.DAY_OF_MONTH);


                            DatePickerDialog new_date = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                                    placedate.setText(editTextDateParam);
                                }
                            }, myear, mmonth, mday);
                            new_date.show();
                        }

                        ;
                    }
            );





            save.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {





                    Intent intent = new Intent(getActivity(),CheckingActiv.class);
                    intent.putExtra("chname", placename.getText().toString());
                    intent.putExtra("chsurname", placesurname.getText().toString());
                    intent.putExtra("chdate", placedate.getText().toString());
                    if ((placename.getText().length() != 0) &&
                            (placesurname.getText().length() != 0) &&
                            (placedate.getText().length() != 0)  ) {

                        startActivity(intent);


                    }

                    }
                });


            return view;
        }
    }
