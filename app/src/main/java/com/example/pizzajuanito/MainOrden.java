package com.example.pizzajuanito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainOrden extends AppCompatActivity {
    Spinner Tamanio;
    Button aceptar1,aceptar2;
    ImageView btntamanio, btnExtras, Btnpedir ;
    ConstraintLayout EmgIngredientes, EmgExtrax;
    CheckBox peperoni, carne,pinia,queso,jamon, coca,pepsi,Equeso,D2queso,Palitroques;
    String tipopizz,extra1,extra2,extra3,extra4,extra5,tipoP,nombr;
    EditText nom;
    TextView prueba;
    int ingre = 0;
    double precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_orden);
    Tamanio = findViewById(R.id.SpTamanio);
    prueba = findViewById(R.id.prueba);
    nom = findViewById(R.id.edtnom);
    String Tamanios [] = {"","Pequeña-$2.50","Mediana-$5.00","Familiar-$7.00","FullPizza-$10.00"};
        ArrayAdapter adaptadorTamanios = new ArrayAdapter(this, R.layout.spi_layout,Tamanios);
        Tamanio.setAdapter(adaptadorTamanios);
    btntamanio = findViewById(R.id.BtnSelcIng);
    peperoni= findViewById(R.id.CkPeperoni);
    carne = findViewById(R.id.CkCarne);
    pinia = findViewById(R.id.CkPinia);
    queso = findViewById(R.id.CkQueso);
    jamon = findViewById(R.id.CkJamon);
    coca = findViewById(R.id.Ckcoca);
    pepsi = findViewById(R.id.CkPepsi);
    Equeso = findViewById(R.id.CkEqueso);
    D2queso = findViewById(R.id.CkD2Queso);
    Palitroques = findViewById(R.id.CkPalitroques);
    btnExtras = findViewById(R.id.BtnSelecExtra);
    Btnpedir = findViewById(R.id.BtnPedir);
    EmgIngredientes = findViewById(R.id.emgingre);
    EmgExtrax = findViewById(R.id.EmgExtra);
    EmgIngredientes.setVisibility(View.INVISIBLE);
    EmgExtrax.setVisibility(View.INVISIBLE);
    Tamanio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            tipopizz =  Tamanios[position];
            prueba.setText(String.valueOf(tipopizz));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
           //Toast.makeText(getApplicationContext(),"Seleccione un tamaño",Toast.LENGTH_LONG).show();
        }
    });
    btntamanio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EmgIngredientes.setVisibility(View.VISIBLE);

        }
    });
    aceptar1 = findViewById(R.id.btnAceptar);
    aceptar1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EmgIngredientes.setVisibility(View.INVISIBLE);
        }
    });
    btnExtras.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EmgExtrax.setVisibility(View.VISIBLE);
        }
    });
    aceptar2 = findViewById(R.id.btnAceptar2);
    aceptar2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EmgExtrax.setVisibility(View.INVISIBLE);
        }
    });
    Btnpedir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            calculo();

        }
    });

    }

    public void calculo(){

        if (peperoni.isChecked()==true){
            ingre = ingre +1;
            precio = precio +2.00;
        }
        if (carne.isChecked()==true){
            ingre = ingre +1;
            precio = precio +2.00;
        }
        if (pinia.isChecked()==true){
            ingre = ingre +1;
            precio = precio +2.00;
        }
        if (queso.isChecked()==true){
            ingre = ingre +1;
            precio = precio +2.00;
        }
        if (jamon.isChecked()==true){
            ingre = ingre +1;
            precio = precio +2.00;
        }
        //Le ponemos el precio segun el tamanio
        if (prueba.getText().toString().equals("Pequeña-$2.50")){
             tipoP = "Pequeña";
            precio = precio + 2.50;
        }
        if (prueba.getText().toString().equals("Mediana-$5.00")){
            tipoP = "Mediana";
            precio = precio + 5.00;
        }
        if (prueba.getText().toString().equals("Familiar-$7.00")){
            tipoP = "Familiar";
            precio = precio + 7.00;
        }
        if (prueba.getText().toString().equals("FullPizza-$10.00")){
            tipoP = "FullPizza";
            precio = precio + 10.00;
        }
        // le damos valor a los extras
        if (coca.isChecked()==true){
            extra1 = "Una coca de 1.5 lts";
            precio = precio + 1.00;
        }
        if (pepsi.isChecked()==true){
            extra2 = "una pepsi de 2.5 lts";
            precio = precio + 1.50;
        }
        if (queso.isChecked()==true){
            extra3 = "Extra queso";
            precio = precio + 0.50;
        }
        if (D2queso.isChecked()==true){
            extra4 = "Dedos de queso";
            precio = precio + 5.00;
        }
        if (Palitroques.isChecked()==true){
            extra5 = "palitoques";
            precio = precio + 2.00;
        }

        if (nom.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), " No has introducido tu nombre", Toast.LENGTH_LONG).show();
        }
        else if ((peperoni.isChecked()==false)&&(carne.isChecked()==false)&&(pinia.isChecked()==false)&&(queso.isChecked()==false)&&(jamon.isChecked()==false)){
            Toast.makeText(getApplicationContext(),"Elige almenos un ingrediente",Toast.LENGTH_LONG).show();
        }
       else {
           // Agregamos valor a los ingredientees


            nombr = nom.getText().toString();
            Intent pasemola = new Intent(getApplicationContext(),MainResult.class);
            Bundle Datos = new Bundle();
            Datos.putString("nombre",nombr);
            Datos.putString("tipoPizza",tipoP);
            Datos.putString("Extra1",extra1);
            Datos.putString("Extra2",extra2);
            Datos.putString("Extra3",extra3);
            Datos.putString("Extra4",extra4);
            Datos.putString("Extra5",extra5);
            Datos.putInt("Ingredientes",ingre);
            Datos.putDouble("precio",precio);
            pasemola.putExtras(Datos);
            startActivity(pasemola);
            finish();
        }
    }

}