package com.example.pizzajuanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
     ImageView ordenar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ordenar = findViewById(R.id.BtnOrdenar);
        ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orden = new Intent(getApplicationContext(),MainOrden.class);
                startActivity(orden);
                finish();
            }
        });
    }
}