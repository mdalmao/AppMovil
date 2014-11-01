package com.example.stackoverflow;

import java.util.ArrayList;

import modelo.DatabaseManager;
import modelo.TemaAdapter;
import modelo.Temas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class TemaBuscar extends Activity {
	

	public ArrayList<Temas> listTemas = new ArrayList<Temas>();
	private Spinner spinner;
	private Button btnBuscar;
	ListView temasListView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_buscar);	
		temasListView =(ListView) findViewById(R.id.listbuscar);
		
		spinner = (Spinner) findViewById(R.id.spbusqueda);
		//Creamos el adaptador
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.TipoBusqueda,android.R.layout.simple_spinner_item);
		//Añadimos el layout para el menú
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		/*Le indicamos al spinner el adaptador a usar*/
		spinner.setAdapter(adapter);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tema_buscar, menu);
		return true;
	}
		
	 
    
    
	
	public void buscar (View v){
		Toast.makeText(TemaBuscar.this,
                "On Button Click : " + 
                "\n" + String.valueOf(spinner.getSelectedItem()) ,
                Toast.LENGTH_LONG).show();
		
		 TemaAdapter adapter;
		    DatabaseManager.db = openOrCreateDatabase("tarea", SQLiteDatabase.OPEN_READWRITE, null);
			try {
	            DatabaseManager.db.execSQL("SELECT * FROM temas");
	        } catch (SQLiteException xp) {
	        	//Sino existe creo la tabla y le agrego un tema
	        	DatabaseManager.db.execSQL(DatabaseManager.CREATE_TABLE2);
	    	    Log.v("hi", "table created");
	    	    DatabaseManager.db.beginTransaction();
	            String estado ="1";
	            String fecha="2014-01-01";
	            DatabaseManager.db.execSQL("INSERT INTO temas(titulo,pregunta, nombreusuario, email, fecha, estado) VALUES ('Tema de Prueba','Le gusto el sistema?','mdalmao','mdalmaouy@gmail.com','22/10/2014','1');");
	            DatabaseManager.db.setTransactionSuccessful();
	            DatabaseManager.db.endTransaction();    
	        }
			Log.e("DATOS",String.valueOf(spinner.getSelectedItem()));
			
		    listTemas= DatabaseManager.BuscarPalabra("vane",String.valueOf(spinner.getSelectedItem()));
		   
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
<<<<<<< HEAD
					      //lay.addView(view);
=======
					      //lay.addView(view); esto es una prueba
>>>>>>> a597549223479e3951a85a89c5c668e2f945ba53
					      
					      lay.addView(textView);
					      toast.setView(lay);
					      toast.show();	
						    return true;

					}
				});

		}
		
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
