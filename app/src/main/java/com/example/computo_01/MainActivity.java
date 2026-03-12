package com.example.computo_01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView txt;

    Button btn;

    ArrayList<Productos> productos;

    ArrayAdapter<Productos> adapter;
    Spinner spinner;

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

        spinner = findViewById(R.id.spProductos);

        txt = findViewById(R.id.textView);


        productos = new ArrayList<Productos>();

        productos.add(new Productos(1,"1papa",0.5));
        productos.add(new Productos(2,"2papa",0.6));
        productos.add(new Productos(3,"3papa",0.7));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,productos);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Productos productoselecionado =  (Productos) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, "id"+ productoselecionado.id, Toast.LENGTH_SHORT).show();

                txt.setText(productoselecionado.txt());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}