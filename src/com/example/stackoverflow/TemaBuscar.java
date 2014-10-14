package com.example.stackoverflow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TemaBuscar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_buscar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tema_buscar, menu);
		return true;
	}

}
