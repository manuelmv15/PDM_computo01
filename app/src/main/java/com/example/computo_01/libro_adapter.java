package com.example.computo_01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class libro_adapter extends BaseAdapter {

    ArrayList<Libro> data;
    Context context;

    LayoutInflater inflater;


   public libro_adapter (ArrayList<Libro> data , Context context){

       this.context =context;
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

       ViewHolder holder;

       if (convertView == null){

           convertView = inflater.inflate(R.layout.libro_items,parent,false);

           holder = new ViewHolder();

           holder.img = convertView.findViewById(R.id.img);
           holder.tvNombre = convertView.findViewById(R.id.tvNombre);
           holder.tvCategoria = convertView.findViewById(R.id.tvCategoria);
           holder.btm = convertView.findViewById(R.id.btn);

           convertView.setTag(holder);

       }

       else {
           holder = (ViewHolder) convertView.getTag();
       }


        Libro l;

       l = data.get(position);


        holder.img.setImageResource(l.img);
        holder.tvNombre.setText(l.nombre);
        holder.tvCategoria.setText(l.catgoria);

            holder.btm.setOnClickListener(v -> {

                //((MainActivity) context).verLibro(l, position);

                data.remove(position);

                notifyDataSetChanged();
            });

        //desde aquui
        return convertView;
    }

    static class ViewHolder{

        ImageView img;
        TextView tvNombre, tvCategoria;

        Button btm;


    }
}
