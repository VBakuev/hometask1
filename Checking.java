package ru.mipt.hometask1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Checking extends Fragment{
    @Override

    public void onSaveInstanceState(Bundle OutState) {
        super.onSaveInstanceState(OutState);
    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.checking, container, false);
        final TextView chosenname = (TextView) view.findViewById(R.id.name);
        final TextView chosensurname = (TextView) view.findViewById(R.id.surname);
        final TextView chosendate = (TextView) view.findViewById(R.id.date);

        final Button edit = (Button) view.findViewById(R.id.edit);


        Intent intent = getActivity().getIntent();

        String chosename = intent.getStringExtra("chname");
        String chosesurname = intent.getStringExtra("chsurname");
        String chosedate = intent.getStringExtra("chdate");

        chosenname.setText(chosename);
        chosensurname.setText(chosesurname);
        chosendate.setText(chosedate);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    return view;
    }

    }
