package com.example.computo_01;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ListView lvLibros;
    libro_adapter adapter_Libro;

    ArrayList<Libro> libros;

    ArrayList<String> strCategorias;
    ArrayAdapter<String> adapter_categorias;
    Spinner sp_categorias;


    RadioGroup rg;

    CheckBox cbCorreo;
    CheckBox cbSMS;

    String Nombre;

    String categoria;

    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        cbCorreo = findViewById(R.id.cbCorreo);
        cbSMS = findViewById(R.id.cbSMS);
        rg = findViewById(R.id.radioGroup);


        sp_categorias = findViewById(R.id.spCategorias);

        strCategorias = new ArrayList<String>();

        strCategorias.add("Accion");
        strCategorias.add("Drama");

        adapter_categorias = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,strCategorias);

        sp_categorias.setAdapter(adapter_categorias);



        etNombre = findViewById(R.id.etNombre);


        lvLibros = findViewById(R.id.lvLibros);


        libros = new ArrayList<Libro>();


        try {

            libros.add(new Libro("ada","pepe","bueno","chafa", R.drawable.img_libro1));
            adapter_Libro = new libro_adapter(this,libros);
            lvLibros.setAdapter(adapter_Libro);

        } catch (Exception e) {

            Log.e("ERROR_APP", "Detalle: ", e);
        }

        sp_categorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoria = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }




    public void agregarNombre(View view) {

        Nombre = etNombre.getText().toString();
    }

    public void agregarLibro(View view) {

       Libro libroTemp = new Libro();



        libroTemp.nombreEstudainte = Nombre;

        libroTemp.categoria = categoria;
        libroTemp.nombreLibro  = etNombre.getText().toString();
        libroTemp.nombreLibro  = etNombre.getText().toString();


        int rbSelec = rg.getCheckedRadioButtonId();

        if (rbSelec!=-1) {

            RadioButton rb = findViewById(rbSelec);
            libroTemp.estado = rb.getText().toString();


            if (libroTemp.estado.equals("Nuevo")) {
                libroTemp.img = R.drawable.img_libro1;
            } else if (libroTemp.estado.equals("Buen Estado")) {
                libroTemp.img = R.drawable.img_libro2;
            } else if (libroTemp.estado.equals("Desgastado")) {
                libroTemp.img = R.drawable.img_libro3;
            }

        }

        libroTemp.sms =" " ;

        if (cbSMS.isChecked()){
            libroTemp.sms +=" " + cbSMS.getText().toString();

        }

        if (cbCorreo.isChecked()){

            Log.i("DEBUG", libroTemp.sms);
            libroTemp.sms +=" " + cbCorreo.getText().toString();
        }


        libros.add(libroTemp);

        new AlertDialog.Builder(this).setMessage(libroTemp.toString()).show();

        adapter_Libro.notifyDataSetChanged();

    }
}