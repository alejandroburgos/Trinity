package com.dam.trinity;

import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class PagadosAdaptador extends RecyclerView.Adapter<PagadosAdaptador.ViewHolder>{

    public List<PagadosModelo> pagadosModelos;
    private ArrayList<PagadosModelo> PagadosList;

    public PagadosAdaptador(List<PagadosModelo> nombrePagados) {
        this.pagadosModelos = nombrePagados;
        this.PagadosList = PagadosList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre, fecha, curso;
        private ImageView img;
        private SearchView search;

        public ViewHolder(View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.cvNombre);
            fecha = (TextView) itemView.findViewById(R.id.cdFechaPagado);
            curso = (TextView) itemView.findViewById(R.id.cdCurso);
            img = (ImageView) itemView.findViewById(R.id.imagen);
            search = (SearchView) itemView.findViewById(R.id.buscador);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_pagados,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     holder.nombre.setText(pagadosModelos.get(position).getNombre());
     holder.fecha.setText(pagadosModelos.get(position).getFecha());
     holder.curso.setText(pagadosModelos.get(position).getCurso());
     holder.img.setImageResource(pagadosModelos.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return pagadosModelos.size();
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());

        if (charText.length() == 0) {
            pagadosModelos.addAll(pagadosModelos);
        } else {
            for (PagadosModelo wp : pagadosModelos) {
                if (wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText)) {
                    pagadosModelos.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
