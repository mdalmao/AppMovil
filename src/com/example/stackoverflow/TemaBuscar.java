package com.example.stackoverflow;

import java.util.ArrayList;

import modelo.Temas;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class TemaBuscar extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_buscar);	
		
		Spinner spinner = (Spinner) findViewById(R.id.spbusqueda);
		//Creamos el adaptador
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.TipoBusqueda,android.R.layout.simple_spinner_item);
		//Añadimos el layout para el menú
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		/*Le indicamos al spinner el adaptador a usar*/
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tema_buscar, menu);
		return true;
	}
		
}
