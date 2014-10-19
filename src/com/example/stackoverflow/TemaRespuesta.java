package com.example.stackoverflow;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.DatabaseManager;
import modelo.Respuesta;
import modelo.RespuestaAdapter;
import modelo.TemaAdapter;
import modelo.Temas;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TemaRespuesta extends Activity {

	private TextView titulo,idtema,respuesta,usuario,email;
	private ProgressDialog pd = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_respuesta);
		Bundle recibo = getIntent().getExtras();
		String idtematexto = recibo.getString("idtema");
		String titulotexto = recibo.getString("titulo");
		
		idtema=  (TextView) findViewById(R.id.idtema);
		titulo = (TextView) findViewById(R.id.tema_Titulo);
		respuesta= (TextView) findViewById(R.id.tema_respuesta);
		usuario =  (TextView) findViewById(R.id.tena_usuario);
		email=  (TextView) findViewById(R.id.tema_email);
		
		titulo.setText(titulotexto);
		idtema.setText(String.valueOf(idtematexto));
		Log.e("DATOS", "Entro en Respuesta" + idtematexto);	
		
	}
	
	
	
	@SuppressLint("SimpleDateFormat")
	public void guardar (View v){
		this.pd = ProgressDialog.show(this, "Gaurdando", "Guardando Respuesta", true, false);
		 
		Log.e("DATOS", "Guardo Respuesta");	
	
        SQLiteDatabase database;
		String DB_NAME = "tarea";
		database=openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
		database.execSQL(DatabaseManager.CREATE_TABLE);
        Log.v("DATOS", "table created");
        database.beginTransaction();
        Date dt = new Date(0);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = df.format(dt);
        
     //   String fecha="2014-01-01";
        Float X = (float) 1;
        Float Y = (float) 1 ;
       	Integer idtematexto = Integer.valueOf((String) idtema.getText()); 
    	//Log.e("DATOS", "INSERT"+ usuario.getText().toString() + "EMAIL" + email.getText().toString()); 
    	database.execSQL("INSERT INTO respuesta(Id_Tema,Respuesta, Fecha, X, Y, NombreUsuario, Email) VALUES ("+idtematexto+",'"+respuesta.getText().toString()+"','"+fecha+"',"+X+","+Y+",'"+usuario.getText().toString()+"','"+email.getText().toString()+"');");
        database.setTransactionSuccessful();
        database.endTransaction();
        Toast toast1 = Toast.makeText(getApplicationContext(), "Gracias por responder en este tema", Toast.LENGTH_SHORT);
        toast1.show();
        this.pd.dismiss();	
        volver(v);
        
		
    }

	public void volver (View v){
		Intent act = new Intent(getBaseContext(), DetalleTema.class);
		act.putExtra("idtema", idtema.getText());
	    act.putExtra("titulo", titulo.getText());
	   	startActivity(act); 
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tema_respuesta, menu);
		return true;
	}

}
