package com.example.stackoverflow;



import java.util.Calendar;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import modelo.DatabaseManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        Log.v("hi", "PASO");
         //String fecha="2014-01-01";
        String fecha = year + "-" + mes + "-" + dia;
        Log.v("hi", "FECHA" +fecha);
        database.execSQL("INSERT INTO temas(titulo,pregunta, nombreusuario, email, fecha, estado) VALUES ('"+titulo.getText().toString()+"','"+pregunta.getText().toString()+"','"+nombreusuario.getText().toString()+"','"+email.getText().toString()+"','"+fecha+"','"+estado+"');");
        database.setTransactionSuccessful();
        database.endTransaction();
		
        Log.e("DATOS", "titulo: " + titulo.getText().toString() + " pregunta: " +  pregunta.getText().toString());	
		
        Toast toast1 = Toast.makeText(this, "Gracias por Crear un tema", Toast.LENGTH_SHORT);
        toast1.show();
        this.pd.dismiss();
        volver(v);                	
    }
	
	public void sendMessage(View view) {
		Log.e("DATOS", "mensaje ");
    	EditText editText = (EditText) findViewById(R.id.tema_titulo);
    	String message = editText.getText().toString();    	    	
    	
    	
    	new CallMashapeAsync().execute(message);
    }
	
	
	
	private class CallMashapeAsync extends AsyncTask<String, Integer, HttpResponse<JsonNode>> {

    	protected HttpResponse<JsonNode> doInBackground(String... msg) {

    		HttpResponse<JsonNode> request = null;
			try {
				Log.e("DATOS", "mensaje2 ");
				request = Unirest.get("https://pbouda-poio.p.mashape.com/prediction?iso=ssp&text=manos")
						.header("X-Mashape-Key", "epQPu8u4BBmshhgLIUm7vp54G11sp13O00wjsnMF4zgR1JbsUM")
						.asJson();
			} catch (UnirestException e) {
				
				e.printStackTrace();
			}
    		
    		return request;
    	}    	
    	protected void onProgressUpdate(Integer...integers) {
    	}

    	protected void onPostExecute(HttpResponse<JsonNode> response) {
    		String answer = response.getBody().toString();
    		Log.e("Datos",answer);
        	//TextView txtView = (TextView) findViewById(R.id.textView1);
        	//txtView.setText(answer);
    	}
    }
	
}
