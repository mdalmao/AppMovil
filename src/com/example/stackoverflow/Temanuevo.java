package com.example.stackoverflow;


import modelo.DBHelper;
import modelo.DatabaseManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Temanuevo extends Activity {

	EditText titulo;
	EditText pregunta;
	EditText email;
	EditText nombreusuario;
	private ProgressDialog pd = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temanuevo);
		
	  titulo=(EditText)findViewById(R.id.tema_titulo);
	  pregunta=(EditText)findViewById(R.id.tema_pregunta);
	  email=(EditText)findViewById(R.id.tema_email);
	  nombreusuario=(EditText)findViewById(R.id.tema_usuario);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.temanuevo, menu);
		return true;
	}
 
	public void volver (View v){
		Intent settingsActivity = new Intent(getBaseContext(), MainActivity.class);
      	startActivity(settingsActivity); 
    }
	
	public void guardar (View v){
		Log.e("DATOS", "eNTRO");	
		this.pd = ProgressDialog.show(this, "Ingresando Tema",
				  "Guardando Tema", true);
        SQLiteDatabase database;
		String DB_NAME = "tarea";
		database=openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
		database.execSQL(DatabaseManager.CREATE_TABLE2);
        Log.v("hi", "table created");
        database.beginTransaction();
        String estado ="1";
        String fecha="2014-01-01";
        database.execSQL("INSERT INTO temas(titulo,pregunta, nombreusuario, email, fecha, estado) VALUES ('"+titulo.getText().toString()+"','"+pregunta.getText().toString()+"','"+nombreusuario.getText().toString()+"','"+email.getText().toString()+"','"+fecha+"','"+estado+"');");
        database.setTransactionSuccessful();
        database.endTransaction();
		
        Log.e("DATOS", "titulo: " + titulo.getText().toString() + " pregunta: " +  pregunta.getText().toString());	
		
        Toast toast1 = Toast.makeText(this, "Gracias por Crear un tema", Toast.LENGTH_SHORT);
        toast1.show();
        this.pd.dismiss();
        volver(v);
        
		
    }
	
}
