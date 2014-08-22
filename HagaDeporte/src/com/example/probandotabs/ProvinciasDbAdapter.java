package com.example.probandotabs;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ProvinciasDbAdapter {
	
		/**
	    * Definimos constante con el nombre de la tabla
	    */
	   public static final String C_TABLA = "Provincia" ;
	 
	   /**
	    * Definimos constantes con el nombre de las columnas de la tabla
	    */
	   public static final String C_COLUMNA_ID   = "_id";
	   public static final String C_COLUMNA_NOMBRE = "Provincia_nombre";
	 
	   private Context contexto;
	   private DeportesDbHelper dbHelper;
	   private SQLiteDatabase db;
	 
	   /**
	    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
	    */
	   private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE} ;
	 
	   public ProvinciasDbAdapter(Context context)
	   {
	      this.contexto = context;
	   }
	 
	   public ProvinciasDbAdapter abrir() throws SQLException
	   {
	      dbHelper = new DeportesDbHelper(contexto);
	      db = dbHelper.getWritableDatabase();
	      return this;
	   }
	 
	   public void cerrar()
	   {
	      dbHelper.close();
	   }
	 
	   /**
	    * Devuelve cursor con todos las columnas de la tabla
	    */
	   public Cursor getCursor() throws SQLException
	   {
	      Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);
	 
	      return c;
	   }

}
