package com.example.stackoverflow;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
 
public class CustomOnItemSelectedListener implements OnItemSelectedListener {
 	
	 
	  
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
    	
    	if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Fecha")){
    		 Toast.makeText(parent.getContext(),"Formato Fecha: yyyy-mm-dd \n",Toast.LENGTH_LONG).show();
    	}    	       
    }
 
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub prueba
 
    }
 
}