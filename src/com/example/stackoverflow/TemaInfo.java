package com.example.stackoverflow;


import android.content.Context;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class TemaInfo extends Activity {
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void info2 (View v){
		Intent settingsActivity = new Intent(context, WebViewActivity.class);
      	startActivity(settingsActivity);
		 
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
