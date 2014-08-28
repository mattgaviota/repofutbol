package com.example.probandoviews;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AgregarComplejoActivity extends ActionBarActivity {

	DataBaseManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_complejo);

		manager = new DataBaseManager(this);
		
		Button b = (Button) findViewById(R.id.bAgregar);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText tvNombre = (EditText) findViewById(R.id.editText1);
				EditText tvTelefono = (EditText) findViewById(R.id.editText2);
				EditText tvDireccion = (EditText) findViewById(R.id.editText3);
				
				manager.insertar_complejo(tvNombre.getText().toString(), tvTelefono.getText().toString(), tvDireccion.getText().toString());
				finish();
			}		
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agregar_complejo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
