package com.example.mapasygeolocalizacion;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText txtLatitudActual,txtLongitudActual,txtLatitudDestino,txtLongitudDestino;
    private Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK=findViewById(R.id.btnRuta);
        txtLatitudActual=findViewById(R.id.txtLatitudActual);
        txtLongitudActual=findViewById(R.id.txtLongitudActual);
        txtLatitudDestino=findViewById(R.id.txtLatitudDestino);
        txtLongitudDestino=findViewById(R.id.txtLongitudDestino);

    }
}