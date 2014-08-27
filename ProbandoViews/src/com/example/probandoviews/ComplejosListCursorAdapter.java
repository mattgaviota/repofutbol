package com.example.probandoviews;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;


public class ComplejosListCursorAdapter extends SimpleCursorAdapter implements Filterable {

	private Context context;
    private int layout;
    
	
	public ComplejosListCursorAdapter(Context context, int layout, Cursor c,
			String[] from, int[] to, int flags) {
		super(context, layout, c, from, to, flags);
		this.context = context;
        this.layout = layout;
	}
	
	public void bindView (View view, Context context, Cursor cursor) {
		
	}




}
