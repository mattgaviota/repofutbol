package com.example.probandoviews;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ComplejosActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complejos);
		
		TextView tv = (TextView) findViewById(R.id.tvMostrarNombre);
		TextView tv2 = (TextView) findViewById(R.id.tvMostrarTel);
		TextView tv3 = (TextView) findViewById(R.id.tvMostrarDir);
		
		Bundle bundle = getIntent().getExtras();
		
        tv.setText(bundle.getString("COMPLEJO_NOMBRE"));
        tv2.setText(bundle.getString("COMPLEJO_TELEFONO"));
        tv3.setText(bundle.getString("COMPLEJO_DIRECCION"));
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.complejos, menu);
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
