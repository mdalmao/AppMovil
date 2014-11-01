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

<<<<<<< HEAD
	private TextView titulo,idtema, pregunta;
=======
	private TextView titulo,idtema;
>>>>>>> a597549223479e3951a85a89c5c668e2f945ba53
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tema);
		titulo =(TextView) findViewById(R.id.titulo);
<<<<<<< HEAD
		pregunta =(TextView) findViewById(R.id.pregunta);
=======
>>>>>>> a597549223479e3951a85a89c5c668e2f945ba53
		idtema =(TextView) findViewById(R.id.idtema);
		
		Bundle recibo = getIntent().getExtras();
		String titulotext = recibo.getString("titulo");
		String idtematexto = String.valueOf(recibo.getString("idtema"));
<<<<<<< HEAD
		
		//Falta pasar la pregunta de un lado para el otro
		String preguntatext = DatabaseManager.pregunta(Integer.valueOf(idtematexto));
		
		titulo.setText(titulotext);
		idtema.setText(idtematexto);
		pregunta.setText(preguntatext);
=======
		titulo.setText(titulotext);
		idtema.setText(idtematexto);
>>>>>>> a597549223479e3951a85a89c5c668e2f945ba53
		
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
		getMenuInflater().inflate(R.menu.detalle_tema, menu);
		return true;
	}

}
