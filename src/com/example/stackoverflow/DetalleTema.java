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
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class DetalleTema extends Activity {

	private TextView titulo,idtema;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tema);
		titulo =(TextView) findViewById(R.id.titulo);
		idtema =(TextView) findViewById(R.id.idtema);
		
		Bundle recibo = getIntent().getExtras();
		String titulotext = recibo.getString("titulo");
		String idtematexto = String.valueOf(recibo.getString("idtema"));
		titulo.setText(titulotext);
		idtema.setText(idtematexto);
		
		ListView respuestaListView = (ListView) findViewById(R.id.list);
	    
	    RespuestaAdapter adapter;
	    DatabaseManager.db = openOrCreateDatabase("tarea", SQLiteDatabase.OPEN_READWRITE, null);
	  //  DatabaseManager.db.execSQL("DROP TABLE IF EXISTS respuesta");
		DatabaseManager.db.execSQL(DatabaseManager.CREATE_TABLE);
		ArrayList<Respuesta> listRespuesta = DatabaseManager.getAllRespuestas(recibo.getInt("idtema")); 
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
		getMenuInflater().inflate(R.menu.detalle_tema, menu);
		return true;
	}

}
