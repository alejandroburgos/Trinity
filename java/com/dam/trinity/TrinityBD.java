package com.dam.trinity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

public class TrinityBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "trinity2.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_PAGADOS = "CREATE TABLE PAGADOS" +
            "(NOMBRE TEXT PRIMARY KEY, " +
            "PAGO DATE, " +
            "CURSO TEXT)";

    public TrinityBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_PAGADOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLA_PAGADOS + "'");
        sqLiteDatabase.execSQL(TABLA_PAGADOS);
    }

    public void agregarPagado(String nombre, String pago, String curso){
        SQLiteDatabase bd = getWritableDatabase();

        if (bd!=null){
            bd.execSQL("INSERT INTO PAGADOS VALUES( '"+nombre+"' , '"+pago+"' ,'" +curso+"'COLLATE NOCASE)");
            bd.close();
        }
    }

    public void editarPagado(String nombre, String pago, String curso){
        SQLiteDatabase bd = getWritableDatabase();

        if (bd!=null){
            bd.execSQL("UPDATE PAGADOS SET CURSO='"+curso+"', PAGO='"+pago+"' WHERE NOMBRE='"+nombre+"' COLLATE NOCASE");
            bd.close();
        }
    }

    public void eliminar(String nombre){
        SQLiteDatabase bd = getWritableDatabase();

        if (bd!=null){
            bd.execSQL("DELETE FROM PAGADOS WHERE NOMBRE='"+nombre+"' COLLATE NOCASE");
            bd.close();
        }
    }

    public List<PagadosModelo> mostrarPagados() {

        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PAGADOS ORDER BY NOMBRE ASC", null);
        List<PagadosModelo> pagados = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                pagados.add(new PagadosModelo(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return pagados;
    }

    public void buscarPagado(PagadosModelo pagadosModel,String nombre ){

        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PAGADOS WHERE NOMBRE = '"+nombre+"' COLLATE NOCASE" , null);

        if(cursor.moveToFirst()) {
            do {
                pagadosModel.setNombre(cursor.getString(1));
                pagadosModel.setFecha(cursor.getString(2));
            } while (cursor.moveToNext());
        }
    }
}


