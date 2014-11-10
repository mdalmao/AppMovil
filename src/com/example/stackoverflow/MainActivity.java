package com.example.stackoverflow;

import java.util.ArrayList;
import modelo.DatabaseManager;
import modelo.TemaAdapter;
import modelo.Temas;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	ListView temasListView;
	ImageButton botonbuscar;
	ImageButton botonnuevo;
	ImageButton botoninfo;
	private ProgressDialog pd = null;
	
    public ArrayList<Temas> listTemas = new ArrayList<Temas>();
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    temasListView =(ListView) findViewById(R.id.listbuscar);
	    
	    TemaAdapter adapter;
	    DatabaseManager.db = openOrCreateDatabase("tarea", SQLiteDatabase.OPEN_READWRITE, null);
		try {
            //DatabaseManager.db.execSQL("SELECT * FROM temas");
            String selectQuery = "SELECT * FROM temas "; 
			Cursor cursor = DatabaseManager.db.rawQuery(selectQuery, null);
        } catch (SQLiteException xp) {
        	Log.e("ERROR", "Error en tema"+ xp);
        	//Sino existe creo la tabla y le agrego un tema
        	DatabaseManager.db.execSQL(DatabaseManager.CREATE_TABLE2);
    	    Log.v("hi", "table created");
    	    DatabaseManager.db.beginTransaction();
            DatabaseManager.db.execSQL("INSERT INTO temas(titulo,pregunta, nombreusuario, email, fecha, estado) VALUES ('Tema de Prueba','Le gusto el sistema?','mdalmao','mdalmaouy@gmail.com','22/10/2014','1');");
            DatabaseManager.db.setTransactionSuccessful();
            DatabaseManager.db.endTransaction();    
        }
	    listTemas= DatabaseManager.getAllTemas();
	   
	    if (listTemas.size()>= 1){
	     Log.e("DATOS","Entro");
	     adapter = new TemaAdapter(this, listTemas);
	     
	     temasListView.setAdapter(adapter);
	     temasListView.setClickable(true);
		 temasListView.setOnItemClickListener(ListClickListener);
		 
		 temasListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			    @Override
			    public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id) {
			        return onLongListItemClick(v,pos,id);
			    }

				private boolean onLongListItemClick(View v, int pos, long id) {
					 Log.i("DATOS", "onLongListItemClick id=" + id);
					 String texto= DatabaseManager.getInfoTema(id);
					 Toast toast = Toast.makeText(getApplicationContext(), "DATOS" + texto, Toast.LENGTH_SHORT);
				     View textView = toast.getView();
				     LinearLayout lay = new LinearLayout(getApplicationContext());
				     lay.setOrientation(LinearLayout.HORIZONTAL);
				     lay.setMinimumWidth(400);
				    //  ImageView view = new ImageView(getApplicationContext());
				     // view.setImageResource(android.R.drawable.ic_menu_info_details);
				      //lay.addView(view);
				      
				     lay.addView(textView);
				     toast.setView(lay);
				     toast.show();	
					 return true;
					 
					
				}
			});

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
	public void buscar (View v){
		Intent settingsActivity = new Intent(getBaseContext(), TemaBuscar.class);
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
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menu_new:
	            Log.i("ActionBar", "Nuevo!");
	            Intent settingsActivity = new Intent(getBaseContext(), Temanuevo.class);
	          	startActivity(settingsActivity); 
	            return true;
	        case R.id.menu_buscar:
	            Log.i("ActionBar", "buscar!");;
	            Intent settingsActivity2 = new Intent(getBaseContext(), TemaBuscar.class);
	          	startActivity(settingsActivity2); 
	            return true;
	        case R.id.menu_atras:
	            Log.i("ActionBar", "atras!");;
	            Intent settingsActivity4 = new Intent(getBaseContext(), MainActivity.class);
	          	startActivity(settingsActivity4); 
	          	 return true;
	        case R.id.menu_ayuda:
	            Log.i("ActionBar", "ayuda!");;
	            Intent settingsActivity3 = new Intent(getBaseContext(), TemaInfo.class);
	          	startActivity(settingsActivity3); 
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}
