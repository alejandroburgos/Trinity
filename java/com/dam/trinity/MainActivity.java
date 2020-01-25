package com.dam.trinity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtCurso, edtNombre, datFecha;

    Button btnAgregar;
    Button btnMostrar;
    Button btnBuscar;
    Button btnEditar;
    Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.editNombre);
        edtCurso = (EditText) findViewById(R.id.editCurso);
        datFecha = (EditText) findViewById(R.id.datePago);

        btnAgregar = (Button) findViewById(R.id.btnGuardar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnBorrar);

        final TrinityBD trinity = new TrinityBD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtNombre.getText().toString().isEmpty() && !edtCurso.getText().toString().isEmpty() && !datFecha.getText().toString().isEmpty()) {
                    trinity.agregarPagado(edtNombre.getText().toString(), edtCurso.getText().toString(), datFecha.getText().toString());
                    Toast.makeText(getApplicationContext(), "PAGO GUARDADO", Toast.LENGTH_SHORT).show();

                    edtNombre.setText("");
                    edtCurso.setText("");
                    datFecha.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "RELLENA TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarPagados = new Intent(getApplicationContext(), PagadosActivity.class);
                startActivity(mostrarPagados);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PagadosModelo pagadosModelo2 = new PagadosModelo();

                trinity.buscarPagado(pagadosModelo2, edtNombre.getText().toString());
                edtCurso.setText(pagadosModelo2.getNombre());
                datFecha.setText(pagadosModelo2.getFecha());

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtNombre.getText().toString().isEmpty() && !edtCurso.getText().toString().isEmpty() && !datFecha.getText().toString().isEmpty()) {
                trinity.editarPagado(edtNombre.getText().toString(), datFecha.getText().toString(), edtCurso.getText().toString());
                Toast.makeText(getApplicationContext(), "DATOS MODIFICADOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();

                    edtNombre.setText("");
                    edtCurso.setText("");
                    datFecha.setText("");
            }else{
                    Toast.makeText(getApplicationContext(), "RELLENA TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtNombre.getText().toString().isEmpty() && !edtCurso.getText().toString().isEmpty() && !datFecha.getText().toString().isEmpty()){
                    trinity.eliminar(edtNombre.getText().toString());
                    Toast.makeText(getApplicationContext(), "ALUMNO ELIMINADO", Toast.LENGTH_SHORT).show();

                    edtNombre.setText("");
                    edtCurso.setText("");
                    datFecha.setText("");
                }else{

                    Toast.makeText(getApplicationContext(), "NO SE PUEDE ELIMINAR", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}
