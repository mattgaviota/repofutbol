package com.example.probandotabs;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	FragmentComplejos fragmentComplejos = new FragmentComplejos();
	FragmentFavoritos fragmentFavoritos = new FragmentFavoritos();
	FragmentConfiguracion fragmentConfiguracion = new FragmentConfiguracion();

	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		//OBTENGO LA ACTION BAR Y DEFINO ALGUNAS CARACTERISTICAS
		final ActionBar actionBar = getActionBar();
		actionBar.setTitle("Hace Deporte");
		actionBar.setIcon(R.drawable.ic_action_hd);	
		
		//DEFINO LA IMPLEMENTACION DE TABS
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		//CREAR TABS
		Tab tComplejos = actionBar.newTab()
				.setText("Complejos")
				.setTabListener(new TabListener(fragmentComplejos));

		Tab tFavoritos = actionBar.newTab()
				.setText("Favoritos")
				.setTabListener(new TabListener(fragmentFavoritos));

		Tab tConfiguracion = actionBar.newTab()
				.setText("Configuración")
				.setTabListener(new TabListener(fragmentConfiguracion));
		
		//AGREGO LOS TABS A LA ACTION BAR 
		actionBar.addTab(tFavoritos);
		actionBar.addTab(tComplejos);	
		actionBar.addTab(tConfiguracion);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		return super.onOptionsItemSelected(item);
	}
	
	
	
	//TODO-Listener para los tabs
	public class TabListener implements ActionBar.TabListener {
		 
	    Fragment fragment;
	 
	    public TabListener(Fragment fragment) {	        
	        this.fragment = fragment;
	    }
	 
	    @Override
	    public void onTabSelected(Tab tab, FragmentTransaction ft) {	       
	    	ft.replace(R.id.fragment_container, fragment);
	        
	    }
	 
	    @Override
	    public void onTabUnselected(Tab tab, FragmentTransaction ft) {	       
	        ft.remove(fragment);
	    }
	 
	    @Override
	    public void onTabReselected(Tab tab, FragmentTransaction ft) {	 
	    }
	}

	public class FragmentComplejos extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	      
	        View rootView = inflater.inflate(R.layout.fragment_complejos, container, false);
	        return rootView;
	    }
	}
	
	public class FragmentFavoritos extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
	        return rootView;
	    }
	}
			
	public class FragmentConfiguracion extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.fragment_configuracion, container, false);
	        return rootView;
	    }
	} 
 	
}
