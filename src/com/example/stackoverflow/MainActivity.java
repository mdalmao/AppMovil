package com.example.stackoverflow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import modelo.DBHelper;
import modelo.DatabaseManager;
import modelo.TemaAdapter;
import modelo.Temas;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	ListView temasListView;
	ImageButton botonbuscar;
	ImageButton botonnuevo;
	ImageButton botoninfo;
	
	
    public ArrayList<Temas> listTemas = new ArrayList<Temas>();
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    temasListView =(ListView) findViewById(R.id.TemasListPrincipal);
	    
	    TemaAdapter adapter;
	    DatabaseManager.db = openOrCreateDatabase("tarea", SQLiteDatabase.OPEN_READWRITE, null);
		DatabaseManager.db.execSQL(DatabaseManager.CREATE_TABLE2);
	    listTemas= DatabaseManager.getAllTemas(); 
	       
        Log.e("DATOS","Entro");
	    adapter = new TemaAdapter(getApplicationContext(), listTemas);
	    Log.e("DATOS","Cantidad " + adapter.getCount());  
	   
	   	    
	    temasListView.setAdapter(adapter);
	    //temasListView.setAdapter(new ArrayAdapter<Temas>(this,R.layout.temas_row2,listTemas));	 
	    temasListView.setClickable(true);
		temasListView.setOnItemClickListener(ListClickListener);
		       
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void nuevo (View v){
		Intent settingsActivity = new Intent(getBaseContext(), Temanuevo.class);
      	startActivity(settingsActivity); 
    }
	public void info (View v){
		Intent settingsActivity = new Intent(getBaseContext(), TemaInfo.class);
      	startActivity(settingsActivity); 
    }
	public void buscar (View v){
		Intent settingsActivity = new Intent(getBaseContext(), TemaBuscar.class);
      	startActivity(settingsActivity); 
    }
    
	private OnItemClickListener ListClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
            	Intent act = new Intent(getApplicationContext(),TemaRespuesta.class);
        		//act.putExtra("email", listTrueques.get(arg2).getEmail());
        	     act.putExtra("titulo", listTemas.get(arg2).getTitulo());
        	    //act.putExtra("descripcion", listTrueques.get(arg2).getDescripcion());
        	    //act.putExtra("valor", listTrueques.get(arg2).getValor());
        	    //act.putExtra("idobjeto", listTrueques.get(arg2).getIdObjeto());
                 startActivity(act);
        
        }
	};
}
