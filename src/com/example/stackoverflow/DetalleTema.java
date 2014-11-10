package com.example.stackoverflow;

import java.util.ArrayList;

import modelo.DatabaseManager;
import modelo.Respuesta;
import modelo.RespuestaAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class DetalleTema extends Activity {

	private TextView titulo,idtema, pregunta;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tema);
		titulo =(TextView) findViewById(R.id.titulo);
		pregunta =(TextView) findViewById(R.id.pregunta);
		idtema =(TextView) findViewById(R.id.idtema);
		
		Bundle recibo = getIntent().getExtras();
		String titulotext = recibo.getString("titulo");
		String idtematexto = String.valueOf(recibo.getString("idtema"));
		
		//Falta pasar la pregunta de un lado para el otro
		String preguntatext = DatabaseManager.pregunta(Integer.valueOf(idtematexto));
		
		titulo.setText(titulotext);
		idtema.setText(idtematexto);
		pregunta.setText(preguntatext);
		
		ListView respuestaListView = (ListView) findViewById(R.id.listbuscar);
	    
	    RespuestaAdapter adapter;
	    DatabaseManager.db = openOrCreateDatabase("tarea", SQLiteDatabase.OPEN_READWRITE, null);
	  //  DatabaseManager.db.execSQL("DROP TABLE IF EXISTS respuesta");
		DatabaseManager.db.execSQL(DatabaseManager.CREATE_TABLE);
	    Log.e("DATOS22","VALOR DE ID "+ idtematexto);  
		ArrayList<Respuesta> listRespuesta = DatabaseManager.getAllRespuestas(Integer.valueOf(idtematexto)); 
	    Log.e("DATOS","traigo los datos de respuestas ");  
	    if (listRespuesta.size() >=1){
	   // listTemas.add(a);
        Log.e("DATOS","Entro");
	    adapter = new RespuestaAdapter(this, listRespuesta);
	    Log.e("DATOS","Cantidad " + adapter.getCount());  
	   
	    respuestaListView.setAdapter(adapter);
	    //temasListView.setAdapter(new ArrayAdapter<Temas>(this,R.layout.temas_row2,listTemas));	 
	    respuestaListView.setClickable(true);
	    }else{
	    	 Log.e("DATOS"," No tiene respuestas ");  
	  	    
	    }
	    
       
	}
	
	public void responder (View v){
		Intent act = new Intent(getBaseContext(), TemaRespuesta.class);
		act.putExtra("idtema", idtema.getText());
		act.putExtra("titulo", titulo.getText());
		Log.e("DATOS","Llamo a TemaRespuesta con idtema "+idtema.getText()); 
      	startActivity(act); 
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
