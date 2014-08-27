package com.example.probandoviews;

import java.io.IOException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
	

	//Tabla Localidad
	public static final String TABLE_LOCALIDAD = "Localidad";
	public static final String LOC_ID = "_id";
	public static final String LOC_NAME = "nombre";
	
	public static final String CREATE_LOCALIDAD = "create table "+ TABLE_LOCALIDAD + " ("
			+ LOC_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE,"
			+ LOC_NAME + " text);";
	
	//Tabla de Complejo
	public static final String TABLE_COMPLEJO = "Complejo";
	public static final	String COM_ID = "_id";
	public static final String COM_NAME = "Complejo_nombre";
	public static final String COM_TEL = "Complejo_telefono";
	public static final String COM_DIR = "Complejo_direccion";
	
	
	public static final String CREATE_COMPLEJO = "create table " + TABLE_COMPLEJO + " ("
			+ COM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  UNIQUE,"
			+ COM_NAME + " text,"
			+ COM_TEL + " text,"
			+ COM_DIR + " text );";
	
	
	private DbHelper helper;
	private SQLiteDatabase db;
	
	private DataBaseHelper helper2;

	public DataBaseManager(Context context){
		// helper = new DbHelper(context);
		//db = helper.getWritableDatabase();
		helper2 = new DataBaseHelper(context);
		try {
			helper2.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			helper2.openDataBase();
		}catch(SQLException sqle){
			throw sqle;
		}
		db = helper2.getWritableDatabase();
	}
	
	public void insertar_localidad(String nombre){
		ContentValues valores = new ContentValues();
		valores.put(LOC_NAME, nombre);
		db.insert(TABLE_LOCALIDAD, null, valores);		
	}
	
	public Cursor CargarCursorLocalidades(){
		String[] columnas = new String[] {LOC_ID,LOC_NAME};
		return db.query(TABLE_LOCALIDAD, columnas, null, null, null, null, null);
	}
	
	
	public void insertar_complejo(String nombre, String telefono, String direccion){
		ContentValues valores = new ContentValues();
		valores.put(COM_NAME, nombre);
		valores.put(COM_TEL, telefono);
		valores.put(COM_DIR, direccion);
		db.insert(TABLE_COMPLEJO, null, valores);
	}
	
	public Cursor CargarCursorComplejos(){
		String[] columnas = new String[] {COM_ID, COM_NAME, COM_TEL, COM_DIR};
		return db.query(TABLE_COMPLEJO, columnas, null, null, null, null, null);
	}
	
}
