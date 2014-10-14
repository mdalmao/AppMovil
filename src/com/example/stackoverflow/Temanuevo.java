package com.example.stackoverflow;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Temanuevo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temanuevo);
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
		//Intent settingsActivity = new Intent(getBaseContext(), Temanuevo.class);
      	//startActivity(settingsActivity); 
		
    }
	
}
