package com.example.idfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText edT;
    TextView tView;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edT = findViewById(R.id.edT);
        tView = findViewById(R.id.tView);
        btnSubmit = findViewById(R.id.btnSubmit);

        tView.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String idNum = edT.getText().toString().trim();
                String dob = idNum.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idNum.charAt(6)));
                String sGender;

                if(gender<5)
                {
                    sGender = "female";
                }
                else
                    {
                        sGender = "male";
                }

                int nationality = Integer.parseInt(Character.toString(idNum.charAt(10)));
                String sNationality;

                if(nationality == 0)
                {
                    sNationality = "citizen";
                }
                else
                {
                    sNationality = "Permanent Resident";
                }

                String text =  (getString(R.string.dob)+ dob + "\n" +getString(R.string.gender) + sGender + "\n" + getString(R.string.nationality)+ sNationality);
                tView.setText(text);
                tView.setVisibility(View.VISIBLE);
            }
        });
    }

}