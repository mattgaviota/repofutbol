package com.example.probandotabs;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ProvinciasActivity extends ListActivity {

		private ProvinciasDbAdapter dbAdapter;
	    private Cursor cursor;
	    private ProvinciasCursorAdapter ProvinciasAdapter ;
	    private ListView lista;
	 
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_provincias);
	 
	      lista = (ListView) findViewById(android.R.id.list);
	 
	      dbAdapter = new ProvinciasDbAdapter(this);
	      dbAdapter.abrir();
	 
	      consultar();
	   }
	 
	   private void consultar()
	   {
	      cursor = dbAdapter.getCursor();
	      startManagingCursor(cursor);
	      ProvinciasAdapter = new ProvinciasCursorAdapter(this, cursor);
	      lista.setAdapter(ProvinciasAdapter);
	   }
	   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
