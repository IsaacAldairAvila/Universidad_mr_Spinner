package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EstudianteAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spjava, spandroid, spphp;
    private double javasuma = 0.0;
    private double androidsuma = 0.0;
    private double phpsuma = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);
        spjava = (Spinner)findViewById(R.id.spinnerjava);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.turno, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjava.setAdapter(adapter);
        spjava.setOnItemSelectedListener(this);
        spandroid = (Spinner)findViewById(R.id.spinnerandroid);
        spandroid.setOnItemSelectedListener(this);
        spandroid.setAdapter(adapter);
        spphp = (Spinner)findViewById(R.id.spinnerphp);
        spphp.setOnItemSelectedListener(this);
        spphp.setAdapter(adapter);


        RadioButton php = (RadioButton) findViewById(R.id.phprb);
        RadioButton java = (RadioButton) findViewById(R.id.javarb);
        RadioButton android = (RadioButton) findViewById(R.id.androidrb);

        Button clickbutton = (Button) findViewById(R.id.buttoncalcular);
        TextView texto = (TextView) findViewById(R.id.texto);
        clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double suma = 0.0;
                if (php.isChecked()){
                   suma = suma + phpsuma;
                }
                if(java.isChecked()){
                    suma = suma + javasuma;
                }
                if(android.isChecked()){
                    suma = suma + androidsuma;
                }
                texto.setText(String.valueOf(suma));

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.spinnerandroid:
                String text = parent.getItemAtPosition(position).toString();
                if(text.equals("Mañana")){
                    androidsuma = 545;
                }
                else if(text.equals("Tarde")){
                    androidsuma = 575;
                }else{
                    androidsuma = 620;
                }
                break;
            case R.id.spinnerjava:
                String text2 = parent.getItemAtPosition(position).toString();
                if(text2.equals("Mañana")){
                    javasuma = 330;
                }
                else if(text2.equals("Tarde")){
                    javasuma = 340;
                }else{
                    javasuma = 365;
                }

                break;
            case R.id.spinnerphp:
                String text3 = parent.getItemAtPosition(position).toString();
                if(text3.equals("Mañana")){
                    phpsuma = 225;
                }
                else if(text3.equals("Tarde")){
                    phpsuma = 260;
                }else{
                    phpsuma = 275;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}