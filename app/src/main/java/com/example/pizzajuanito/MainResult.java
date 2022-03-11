package com.example.pizzajuanito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainResult extends AppCompatActivity {
    TextView precio,tama,ing,ex1,ex2,ex3,ex4,ex5,saludo;
    String e1,e2,e3,e4,e5,nomm,ti;
    ImageView corfitrmar, volver,salir;
    ConstraintLayout corfir;
    int in;
    double pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);
        corfitrmar = findViewById(R.id.BtnCorfirmar);
        volver =findViewById(R.id.BtnVolver);
        salir = findViewById(R.id.BtnSalir);
        tama=findViewById(R.id.txttamanioo);
        ing=findViewById(R.id.txtIngr);
        ex1=findViewById(R.id.txtExtra1);
        ex2=findViewById(R.id.txtExtra2);
        ex3=findViewById(R.id.txtExtra3);
        ex4=findViewById(R.id.txtExtra4);
        ex5=findViewById(R.id.txtExtra5);
        saludo=findViewById(R.id.txtSaludo);
        precio = findViewById(R.id.txtprecio);
        Bundle Datos = getIntent().getExtras();
        nomm = Datos.getString("nombre");
        ti = Datos.getString("tipoPizza");
        e1 = Datos.getString("Extra1");
        e2 = Datos.getString("Extra2");
        e3 = Datos.getString("Extra3");
        e4 = Datos.getString("Extra4");
        e5 = Datos.getString("Extra5");
        in = Datos.getInt("Ingredientes");
        pre = Datos.getDouble("precio");
        saludo.setText("Hola " + nomm +" Tu Pedido es");
        tama.setText(ti);
        ing.setText(String.valueOf(in));
        ex1.setText(e1);
        ex2.setText(e2);
        ex3.setText(e3);
        ex4.setText(e4);
        ex5.setText(e5);
        precio.setText(String.valueOf(pre));
        corfir = findViewById(R.id.ClCorfirmar);
        corfitrmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corfir.setVisibility(View.VISIBLE);
            }

        });
       volver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent regresar = new Intent(getApplicationContext(),MainOrden.class);
               startActivity(regresar);
               finish();
           }

       });
       salir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });



    }
}