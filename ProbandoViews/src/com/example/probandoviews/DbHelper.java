package com.example.probandoviews;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	
	 private static int DB_SCHEME_VERSION = 1;
	 private static String DB_NAME = "DeportesDb.sqlite" ;
	 private static CursorFactory factory = null;
	 private static DataBaseManager manager;
	 
	 
	  public DbHelper(Context context)
	   {
	      super(context, DB_NAME, factory, DB_SCHEME_VERSION);
	      
	   }
	 
	   @Override
	   public void onCreate(SQLiteDatabase db)
	   {
		   db.execSQL(DataBaseManager.CREATE_LOCALIDAD);
		   db.execSQL(DataBaseManager.CREATE_COMPLEJO);
			   
	   }
	 
	   @Override
	   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	   {
	   }
	 
}
