package com.example.computo_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    Spinner sp_Productos;
    Spinner sp_Moneda;

    TextView txt;

    EditText ed_Cantidad;

    ArrayList<Producto> productos_vendidos;



    ArrayList<Producto> productos;
    ArrayAdapter<Producto> adapter_Productos;

    Producto producto_temporal;

    ArrayAdapter<Moneda> adapter_monedas;
    ArrayList<Moneda> monedas;

    Moneda moneda_temporal;


    double total;




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

        productos = new ArrayList<Producto>();
        productos.add(new Producto("Cemetno",8.50));
        productos.add(new Producto("arena",3.00));
        productos.add(new Producto("ladrillo",0.75));
        productos.add(new Producto("Varilla",6.25));
        productos.add(new Producto("Pintura",12.0));
        adapter_Productos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,productos);
        sp_Productos = findViewById(R.id.sp_Productos);
        sp_Productos.setAdapter(adapter_Productos);

        monedas = new ArrayList<Moneda>();
        monedas.add(new Moneda("Euro", 1.08));
        monedas.add(new Moneda("Peso Mexicano", 0.49));
        monedas.add(new Moneda("Quetzal", 0.13));
        adapter_monedas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,monedas);
        sp_Moneda = findViewById(R.id.sp_Moneda);
        sp_Moneda.setAdapter(adapter_monedas);





        sp_Moneda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moneda_temporal = (Moneda) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_Productos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                producto_temporal = (Producto) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ed_Cantidad = findViewById(R.id.etCantidad);

        txt = findViewById(R.id.textView);


        productos_vendidos = new ArrayList<>();

    }

    public void agregar(View view) {


        String cantidadSt = ed_Cantidad.getText().toString();
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(cantidadSt);




        } catch (Exception e) {

            Log.i("DEBUG", e.toString());
        }

        if (cantidad>0){

            producto_temporal.cantidad = cantidad;

            productos_vendidos.add(producto_temporal);

            Log.i("VENTAS","Producto->" + producto_temporal.toString() + "| precio->" +producto_temporal.precio+"| cantidad->"+producto_temporal.cantidad+"| subtital->" +producto_temporal.subTotal());

    total =0;
            txt.setText("nombre\tsubtotal\n");
            for (Producto producto:
                 productos_vendidos) {
                txt.append(producto.toString() + " " + producto.subTotal() + "\n");
                total+= producto.subTotal();
            }
            txt.append("total\t"+ total);
        }
        else {
            Toast.makeText(this, "La cantidad debe ser mayor a 0 y entero`", Toast.LENGTH_SHORT).show();
        }

    }

    public void calcular(View view) {

        double cambio = 0;

        cambio = total /moneda_temporal.valor ;
        Toast.makeText(this, "cambio a "+ moneda_temporal.toString()+ "es "+ cambio, Toast.LENGTH_SHORT).show();



    }
}