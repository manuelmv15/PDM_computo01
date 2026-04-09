package com.example.computo_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Producto_adapter extends BaseAdapter {

    ArrayList<Producto> data;

    Context context;

    LayoutInflater inflater;

    public Producto_adapter(Context context, ArrayList<Producto> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.item,parent,false);

            holder = new viewHolder();

            holder.img = convertView.findViewById(R.id.img);
            holder.tvid =convertView.findViewById(R.id.tvid);
            holder.tvnombre =convertView.findViewById(R.id.tvnombre);
            holder.tvcategoria =convertView.findViewById(R.id.tvcategoria);
            holder.tvprecio =convertView.findViewById(R.id.tvprecio);
            holder.btnAccion = convertView.findViewById(R.id.btnAccion);



         convertView.setTag(holder);

        }
        else {


            holder = (viewHolder)  convertView.getTag();
        }

        Producto p = data.get(position);

        if (p.cantidad>0){
            holder.btnAccion.setText("Eliminar");
            holder.btnAccion.setOnClickListener(v -> { data.remove(p);});
        }
        else{



        }


        holder.img.setImageResource(p.img);
        holder.tvid.setText(String.valueOf(p.id));
        holder.tvnombre.setText(p.nombre);
        holder.tvcategoria.setText(p.categoria);
        holder.tvprecio.setText(String.valueOf(p.precio));





        return convertView;
    }


    static class viewHolder {
        ImageView img;

        TextView tvid, tvnombre, tvcategoria, tvprecio;

        Button btnAccion;
    }
}
