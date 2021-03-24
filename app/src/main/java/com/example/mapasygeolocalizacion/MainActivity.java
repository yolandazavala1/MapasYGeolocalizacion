package com.example.mapasygeolocalizacion;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity{
    private EditText txtLatitudActual,txtLongitudActual, txtLatitudDestino,txtLongitudDestino;
    private Button btnOK;
    public static Intent intent = new Intent();
    private FusedLocationProviderClient fusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK=findViewById(R.id.btnRuta);
        txtLatitudActual=findViewById(R.id.txtLatitudActual);
        txtLongitudActual=findViewById(R.id.txtLongitudActual);
        txtLatitudDestino=findViewById(R.id.txtLatitudDestino);
        txtLongitudDestino=findViewById(R.id.txtLatitudDestino);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                            txtLatitudActual.setText(String.valueOf(location.getLatitude()));
                            txtLongitudActual.setText(String.valueOf(location.getLongitude()));
                        }else {
                            Log.i("MiUltUbi", "No hay ubicaciòn, verifique si conexión y gps");}

                    }
                });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Origen
                intent.putExtra("LatitudCasa", txtLatitudActual.getText().toString());
                intent.putExtra("LongitudCasa",txtLongitudActual.getText().toString());

                //Destino
                intent.putExtra("latituActual",txtLatitudDestino.getText().toString());
                intent.putExtra("longitudActual",txtLongitudDestino.getText().toString());

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

    }
}