package com.example.stackoverflow;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.net.NetworkInfo;



import modelo.DatabaseManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TemaRespuesta extends Activity {

	private TextView titulo,idtema,respuesta,usuario,email;
	TextView et1, et2;
	private ProgressDialog pd = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_respuesta);
		Bundle recibo = getIntent().getExtras();
		String idtematexto = recibo.getString("idtema");
		String titulotexto = recibo.getString("titulo");
		
		/* Use the LocationManager class to obtain GPS locations */
	      LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

	      LocationListener mlocListener = new MyLocationListener();
	      mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
	     
	      et1=(TextView)findViewById(R.id.latitud);
	      et2=(TextView)findViewById(R.id.longitud);
		
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
       // Float X = Float(et1.getText());
       //  Float Y = (float) et1.getText() ;
        Float X = Float.valueOf(et1.getText().toString());
        Float Y = Float.valueOf(et2.getText().toString());
              
       	Integer idtematexto = Integer.valueOf((String) idtema.getText()); 
    	Log.e("DATOS", "X"+ X + " Y" + Y ); 
    	database.execSQL("INSERT INTO respuesta(Id_Tema,Respuesta, Fecha, X, Y, NombreUsuario, Email) VALUES ("+idtematexto+",'"+respuesta.getText().toString()+"','"+fecha+"',"+X+","+Y+",'"+usuario.getText().toString()+"','"+email.getText().toString()+"');");
        database.setTransactionSuccessful();
        database.endTransaction();
        Toast toast1 = Toast.makeText(getApplicationContext(), "Gracias por responder en este tema", Toast.LENGTH_SHORT);
        toast1.show();
        this.pd.dismiss();
        if(isInternetOn()){
           enviarmail();
           /*
           String[] to = { "mdalmaouy@gmail.com", "marcelo_dalmao@hotmail.com" };
           String[] cc = { "mdalmao@sisinfo.com.uy" };
           enviar(to, cc, "Hola","Esto es un email enviado desde una app de Android");
           */
        }
        
        volver(v);
        
		
    }
	
	public final boolean isInternetOn() {
		try {  
    	 ConnectivityManager connec =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    	 if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
    	 connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ) {
    	 return true;
    	 } else if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||  connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {
    	 return false;
    	 }
		} catch (Exception e) {   
			return false;
		}
		return false;
    }
	

	public void enviarmail(){
		/*try {   
            GMailEnvio sender = new GMailEnvio("mdalmaouy@gmail.com", "pass.m0sca2");
            sender.sendMail("This is Subject", "This is Body", "mdalmaouy@gmail.com", "mdalmaouy@gmail.com");   
            Log.e("SendMail", "Se envio correctamente");
        } catch (Exception e) {   
            Log.e("SendMail", e.getMessage(), e);   
        } */

	}
	
	
	private void enviar(String[] to, String[] cc,
	        String asunto, String mensaje) {
	        Intent emailIntent = new Intent(Intent.ACTION_SEND);
	        emailIntent.setData(Uri.parse("mailto:"));
	        //String[] to = direccionesEmail;
	        //String[] cc = copias;
	        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
	        emailIntent.putExtra(Intent.EXTRA_CC, cc);
	        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
	        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
	        emailIntent.setType("message/rfc822");
	        startActivity(Intent.createChooser(emailIntent, "Email "));
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

	
	public class MyLocationListener implements LocationListener
    {

	 
	 protected void onCreate(Location loc) {
		 loc.getLatitude();
	        loc.getLongitude();     
	        et1=(TextView)findViewById(R.id.latitud);
			et1.setText( new Double(loc.getLatitude()).toString());
			et2=(TextView)findViewById(R.id.longitud);
			et2.setText(new Double(loc.getLongitude()).toString());
	 }
      @Override
      public void onLocationChanged(Location loc)
      {
        loc.getLatitude();
        loc.getLongitude();     
        et1 = (TextView)findViewById(R.id.latitud);
		et1.setText( new Double(loc.getLatitude()).toString());
		et2 = (TextView)findViewById(R.id.longitud);
		et2.setText(new Double(loc.getLongitude()).toString());
      }

      @Override
      public void onProviderDisabled(String provider)
      {
        Toast.makeText( getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show();
      }

      @Override
      public void onProviderEnabled(String provider)
      {
        Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onStatusChanged(String provider, int status, Bundle extras)
      {

      }
    }
}
