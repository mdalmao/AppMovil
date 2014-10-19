package com.example.stackoverflow;

import java.util.ArrayList;
import modelo.DatabaseManager;
import modelo.TemaAdapter;
import modelo.Temas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
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
	    temasListView =(ListView) findViewById(R.id.list);
	    
	    TemaAdapter adapter;
	    DatabaseManager.db = openOrCreateDatabase("tarea", SQLiteDatabase.OPEN_READWRITE, null);
		DatabaseManager.db.execSQL(DatabaseManager.CREATE_TABLE2);
	    listTemas= DatabaseManager.getAllTemas(); 
	    if (listTemas.size()>= 1){
         Log.e("DATOS","Entro");
	     adapter = new TemaAdapter(this, listTemas);
	     
	     temasListView.setAdapter(adapter);
	     temasListView.setClickable(true);
		 temasListView.setOnItemClickListener(ListClickListener);
	    }	       
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
	
	
	private OnItemClickListener ListClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
            	Intent act = new Intent(getApplicationContext(),DetalleTema.class);
            	String valoridtema= String.valueOf(listTemas.get(arg2).getId_tema());
        		act.putExtra("idtema", valoridtema);
        	    act.putExtra("titulo", listTemas.get(arg2).getTitulo());
        	    startActivity(act);
        
        }
	};
}
