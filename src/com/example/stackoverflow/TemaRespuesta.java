package com.example.stackoverflow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TemaRespuesta extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_respuesta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tema_respuesta, menu);
		return true;
	}

}
