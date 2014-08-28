package com.example.probandoviews;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	
	ViewPager mViewPager;
	MyAdapter mAdapter;
	private static DataBaseManager manager;
	static Cursor cLocalidad, cComplejo;
	static SimpleCursorAdapter cursorAdapter;
	public static Boolean BD_CARGADA = false;
	
	static final int NUM_ITEMS = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager = new DataBaseManager(this);
 		
		final ActionBar actionBar = getSupportActionBar();
	    // Specify that tabs should be displayed in the action bar.
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	    mAdapter = new MyAdapter(getSupportFragmentManager());
	    
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });
        
    
	    
	    // Create a tab listener that is called when the user changes tabs.
	    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
	        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // show the given tab
	        	mViewPager.setCurrentItem(tab.getPosition());
	        }

	        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // hide the given tab
	        }

	        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // probably ignore this event
	        }
	    };

	    // Add 3 tabs, specifying the tab's text and TabListener
	    actionBar.addTab(
                actionBar.newTab()
                        .setText("FAVORITOS")
                        .setTabListener(tabListener));
	    
	    actionBar.addTab(
                actionBar.newTab()
                        .setText("COMPLEJOS")
                        .setTabListener(tabListener));
	    
	    actionBar.addTab(
                actionBar.newTab()
                        .setText("CONFIGURACIONES")
                        .setTabListener(tabListener));
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		if (id == R.id.add_complejo) {
			Intent i  = new Intent(this,AgregarComplejoActivity.class);
			startActivity(i);
			
		}
		return super.onOptionsItemSelected(item);
	}
	
	 public static class MyAdapter extends FragmentPagerAdapter {
	        public MyAdapter(FragmentManager fm) {
	            super(fm);
	        }

	        @Override
	        public int getCount() {
	            return NUM_ITEMS;
	        }

	        @Override
	        public Fragment getItem(int position) {
	        	
	        	if (position == 2) { //si esta seleccionado el tab de configuraciones
	        		return ConfiguracionesFragment.newInstance(position);
	        	}
	        		else return ComplejosFragment.newInstance(position);
	        }
	    }

	    public static class ComplejosFragment extends ListFragment {
	        int mNum;

	        /**
	         * Create a new instance of CountingFragment, providing "num"
	         * as an argument.
	         */
	        static ComplejosFragment newInstance(int num) {
	        	ComplejosFragment f = new ComplejosFragment();

	            // Supply num input as an argument.
	            Bundle args = new Bundle();
	            args.putInt("num", num);
	            f.setArguments(args);

	            return f;
	        }

	        /**
	         * When creating, retrieve this instance's number from its arguments.
	         */
	        @Override
	        public void onCreate(Bundle savedInstanceState) {
	            super.onCreate(savedInstanceState);
	            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
	        }

	        /**
	         * The Fragment's UI is just a simple text view showing its
	         * instance number.
	         */
	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            
	        	View v = inflater.inflate(R.layout.complejos_list, container, false);	
	    		ListView lv = (ListView) v.findViewById(android.R.id.list);
	  
	    		String[] from = new String[] {manager.COM_NAME, manager.COM_TEL, manager.COM_DIR, manager.COM_FAV}; 
	    		int[] to = new int[] {R.id.tvComplejoNombre, R.id.tvComplejoTel, R.id.tvComplejoDir, R.id.imageView1};

	    		cComplejo = manager.CargarCursorComplejos();
	    		
	    		cursorAdapter = new SimpleCursorAdapter(container.getContext(), R.layout.row_complejos_list, cComplejo, from, to,0);
	    		
	    		lv.setAdapter(cursorAdapter);
	    			   
	    		
	    		return v;
	        }
	        
	        //TODO onResume
	        
	        @Override
	        public void onActivityCreated(Bundle savedInstanceState) {
	            super.onActivityCreated(savedInstanceState);
	            
	        }

	        @Override
	        public void onListItemClick(ListView l, View v, int position, long id) {
	        	Intent i = new Intent(l.getContext(), ComplejosActivity.class);
	        	TextView tvNombre = (TextView) v.findViewById(R.id.tvComplejoNombre);
	        	TextView tvTelefono = (TextView) v.findViewById(R.id.tvComplejoTel);
	        	TextView tvDireccion = (TextView) v.findViewById(R.id.tvComplejoDir);
	        	
	        	
	        	i.putExtra("COMPLEJO_NOMBRE", tvNombre.getText().toString());
	        	i.putExtra("COMPLEJO_TELEFONO", tvTelefono.getText().toString());
	        	i.putExtra("COMPLEJO_DIRECCION", tvDireccion.getText().toString());
	        	
	        	startActivity(i);
	        }
	    }
	    
	    
	    public static class ConfiguracionesFragment extends Fragment {
	        int mNum;

	        /**
	         * Create a new instance of CountingFragment, providing "num"
	         * as an argument.
	         */
	        static ConfiguracionesFragment newInstance(int num) {
	            ConfiguracionesFragment f = new ConfiguracionesFragment();

	            // Supply num input as an argument.
	            Bundle args = new Bundle();
	            args.putInt("num", num);
	            f.setArguments(args);

	            return f;
	        }

	        /**
	         * When creating, retrieve this instance's number from its arguments.
	         */
	        @Override
	        public void onCreate(Bundle savedInstanceState) {
	            super.onCreate(savedInstanceState);
	            mNum = getArguments() != null ? getArguments().getInt("num") : 1; 
	        }

	        /**
	         * The Fragment's UI is just a simple text view showing its
	         * instance number.
	         */
	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	        	
	            View v = inflater.inflate(R.layout.configuraciones, container, false);	
	            Button b = (Button) v.findViewById(R.id.LLamar);
	            final TextView tv = (TextView) v.findViewById(R.id.tvConfiguraciones2);
	            
	            b.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View vista) {
						
						tv.setText("Apretaste el boton");     
					}	            	
	            });
	            return v;
	        }

	        @Override
	        public void onActivityCreated(Bundle savedInstanceState) {
	            super.onActivityCreated(savedInstanceState);	 
	            
	             
	        }	        
	    }
	    
	   
	    
}
	
	

