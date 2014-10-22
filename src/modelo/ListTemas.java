package modelo;

import com.example.stackoverflow.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListTemas extends LinearLayout  {
	 
	 private TextView lblTitulo,lblid;
	 private Temas temas; 
	 
	 public ListTemas(Context context, Temas temas) {
	  super(context);
	  this.temas = temas;
	  inicializar();
	 }
	 
	 private void inicializar(){
	  String infService = Context.LAYOUT_INFLATER_SERVICE;
	  LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
	  li.inflate(R.layout.temas_row2, this, true);
	  
	  
	  lblTitulo = (TextView) findViewById(R.id.txtTtitulo);
	  lblid = (TextView) findViewById(R.id.idtema);
	  	  
	  lblTitulo.setText(temas.getTitulo());
	  lblid.setText(String.valueOf(temas.getId_tema()));
	 }
	}
