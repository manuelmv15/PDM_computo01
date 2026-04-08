package com.example.computo_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvLibro;

    ArrayList<Libro> libroArrayList;

    libro_adapter adapter;

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

        lvLibro = findViewById(R.id.lvProductos);

        libroArrayList = new ArrayList<>();

        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));
        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));
        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));
        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));
        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));

        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));

        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));

        libroArrayList.add(new Libro(R.drawable.img,"PAN","chaco"));

        adapter = new libro_adapter(libroArrayList, this);


            lvLibro.setAdapter(adapter);



    }
    // En MainActivity.java
    public void verLibro(Libro libro, int posicion) {
        // Debe ser public
        Log.i("DEBUG", libro.nombre + " en posicion " + posicion);
    }
    public void ver(View view) {


    }
}