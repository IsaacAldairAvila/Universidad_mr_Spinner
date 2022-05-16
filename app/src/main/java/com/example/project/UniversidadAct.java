package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class UniversidadAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner estado, estudio;
    private double beneficios =0.0, descuentos = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universidad);
        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText salario = (EditText) findViewById(R.id.salario);

        estado = (Spinner)findViewById(R.id.spinnerestado);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.estado, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(adapter);
        estado.setOnItemSelectedListener(this);

        estudio = (Spinner)findViewById(R.id.spinnerestudio);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.estudio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estudio.setAdapter(adapter2);
        estudio.setOnItemSelectedListener(this);

        TextView ben = (TextView) findViewById(R.id.numben);
        TextView des = (TextView) findViewById(R.id.numdes);
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double finalsalario = Double.parseDouble(salario.getText().toString());
                double temporal = 0.00;
                temporal = finalsalario * descuentos;
                des.setText(String.valueOf(temporal));
                temporal = finalsalario * beneficios;
                ben.setText(String.valueOf(temporal));
                nombre.getText().clear();
                salario.getText().clear();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.spinnerestado:
                String text = parent.getItemAtPosition(position).toString();
                if(text.equals("Soltero")){
                    descuentos = 0.034;
                }
                else if(text.equals("Casado")){
                    descuentos = 0.013;
                }
                else if(text.equals("Viudo")){
                    descuentos = 0.016;
                }
                else{
                    descuentos = 0.012;
                }
                break;
            case R.id.spinnerestudio:
                String text2 = parent.getItemAtPosition(position).toString();
                if(text2.equals("Doctor")){
                    beneficios = 0.149;
                }
                else if(text2.equals("Magister")){
                    beneficios = 0.142;
                }else{
                    beneficios = 0.127;
                }

                break;
    }}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}