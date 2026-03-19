package com.example.computo_01;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.Buffer;
import java.util.ArrayList;

public class libro_adapter extends BaseAdapter {



    ArrayList<Libro> data;

    Context context;


    LayoutInflater inflater;

    public libro_adapter(Context context, ArrayList<Libro> data) {
        this.context = context;
        this.data = data;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ViewHolder{

        ImageView img;
        TextView nombreEtudiante;
        TextView nombreLibro;
        TextView categoria;
        TextView estado;

        Button btn_devolver;

    }

    @SuppressLint("WrongViewCast")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder ;

        if (convertView == null){

            convertView = inflater.inflate(R.layout.libro_adapter,parent, false);


            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.img);
            holder.nombreEtudiante = convertView.findViewById(R.id.nombreEstudiante);
            holder.nombreLibro = convertView.findViewById(R.id.nombreLibro);
            holder.categoria = convertView.findViewById(R.id.categoria);
            holder.estado = convertView.findViewById(R.id.estado);
            holder.btn_devolver = convertView.findViewById(R.id.btnDevolver);

            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }


        Libro l = data.get(position);


        holder.img.setImageResource(l.img);
        holder.nombreEtudiante.setText(l.nombreEstudainte);
        holder.nombreLibro.setText(l.nombreLibro);
        holder.categoria.setText(l.categoria);
        holder.estado.setText(l.estado);

        holder.btn_devolver.setOnClickListener(v -> {

            new AlertDialog.Builder(context)
                    .setTitle("Desea devolverlo")
                    .setMessage("Elominar si o no")
                    .setPositiveButton("si", (d,w)->{
                    data.remove(position);

                        notifyDataSetChanged();
            }).setNegativeButton("no", null)
                    .show();

        });


        return convertView;
    }
}
