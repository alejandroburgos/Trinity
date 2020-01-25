package com.dam.trinity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class PagadosActivity extends AppCompatActivity{

    private RecyclerView recyclerViewPagados;
    private PagadosAdaptador pagadosAdaptador;
    public static ArrayList<PagadosModelo> pagoModelos;

    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagados);

        final TrinityBD trinityBD = new TrinityBD(getApplicationContext());

        recyclerViewPagados=(RecyclerView)findViewById(R.id.recyclerViewPagados);
        recyclerViewPagados.setLayoutManager(new LinearLayoutManager(this));

        pagadosAdaptador = new PagadosAdaptador(trinityBD.mostrarPagados());
        recyclerViewPagados.setAdapter(pagadosAdaptador);

    }

}
