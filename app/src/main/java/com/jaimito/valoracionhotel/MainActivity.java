package com.jaimito.valoracionhotel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    TextView[] numViews = new TextView[7];
    RatingBar[] ratingBars = new RatingBar[7];
    ;
    Button btnNuevaValoracion;
    float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        numViews[0] = findViewById(R.id.numPersonal);
        numViews[1] = findViewById(R.id.numInstalaciones);
        numViews[2] = findViewById(R.id.numServicios);
        numViews[3] = findViewById(R.id.numLimpieza);
        numViews[4] = findViewById(R.id.numComfort);
        numViews[5] = findViewById(R.id.numCalidadPrecio);
        numViews[6] = findViewById(R.id.numUbicacion);

        ratingBars[0] = findViewById(R.id.rbPersonal);
        ratingBars[1] = findViewById(R.id.rbInstalaciones);
        ratingBars[2] = findViewById(R.id.rbServicios);
        ratingBars[3] = findViewById(R.id.rbLimpieza);
        ratingBars[4] = findViewById(R.id.rbComfort);
        ratingBars[5] = findViewById(R.id.rbCalidadPrecio);
        ratingBars[6] = findViewById(R.id.rbUbicacion);

        btnNuevaValoracion = findViewById(R.id.btnNuevaValoracion);

        for (int i = 0; i < ratingBars.length; i++) {
            final int index = i;
            ratingBars[i].setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> actualizarNumero(index));
        }

        btnNuevaValoracion.setOnClickListener(view -> nuevaValoracion());

    }

    private void actualizarNumero(int ratingbar) {

        numViews[ratingbar].setText(String.valueOf(ratingBars[ratingbar].getRating()));
        float sum = 0;
        for (int i = 0; i < ratingBars.length; i++) {
            sum += ratingBars[i].getRating();
        }
        resultado = sum / ratingBars.length;
        tvResultado.setText(String.format("%.2f", resultado));

    }

    private void nuevaValoracion() {
        for (int i = 0; i < ratingBars.length; i++) {
            numViews[i].setText("0");
            ratingBars[i].setRating(0);
        }

        tvResultado.setText("0");
    }

}