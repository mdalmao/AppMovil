package modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stackoverflow.R;

public class ListRespuesta  extends LinearLayout  {
	 
	 private TextView lblTitulo;
	 private Respuesta Respuesta; 
	 
	 public ListRespuesta(Context context, Respuesta respuesta) {
	  super(context);
	  this.Respuesta = respuesta;
	  inicializar();
	 }
	 
	 private void inicializar(){
	  String infService = Context.LAYOUT_INFLATER_SERVICE;
	  LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
	  li.inflate(R.layout.respuesta_item, this, true);
	  
	  lblTitulo = (TextView) findViewById(R.id.txtRespuesta);
	  	  
	  lblTitulo.setText(Respuesta.getRespuesta());
	  
	 }
	}