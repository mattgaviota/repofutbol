package com.example.probandotabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DeportesDbHelper extends SQLiteOpenHelper {
	
	 private static int version = 1;
	 private static String name = "DeportesDb" ;
	 private static CursorFactory factory = null;

	  public DeportesDbHelper(Context context)
	   {
	      super(context, name, factory, version);
	   }
	 
	   @Override
	   public void onCreate(SQLiteDatabase db)
	   {
		   db.execSQL("CREATE TABLE Provincia("+
				   " _id INT PRIMARY KEY,"+
				   " Provincia_nombre TEXT)");
		   
		   
		   db.execSQL("INSERT INTO Provincia(_id, Provincia_nombre) VALUES(1,'Salta')");
		   db.execSQL("INSERT INTO Provincia(_id, Provincia_nombre) VALUES(2,'Jujuy')");
	   }
	 
	   @Override
	   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	   {
	   }
	 
}
