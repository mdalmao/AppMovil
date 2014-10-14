package com.example.stackoverflow;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView temasListView;
	ImageButton botonbuscar;
	ImageButton botonnuevo;
	ImageButton botoninfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    temasListView =(ListView) findViewById(R.id.TemasList);
		
	    
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

}
