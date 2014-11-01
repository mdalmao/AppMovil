package modelo;

import java.util.List;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class RespuestaAdapter extends BaseAdapter implements OnClickListener {
    private Context context;
    private List<Respuesta> listRespuesta;

    public RespuestaAdapter(Context context, List<Respuesta> listRespuesta) {
    	 this.context = context;
         this.listRespuesta = listRespuesta;
	}

	public int getCount() {
        return listRespuesta.size();
    }

    public Object getItem(int position) {
        return listRespuesta.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
    	  ListRespuesta entry = new ListRespuesta(context, listRespuesta.get(position) ); 
          return entry;  
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	

}