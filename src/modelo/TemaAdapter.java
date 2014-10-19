package modelo;

import java.util.List;

import com.example.stackoverflow.R;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TemaAdapter extends BaseAdapter implements OnClickListener {
	    private Context context;
	    private List<Temas> listTema;

	    public TemaAdapter(Context context, List<Temas> listTema) {
	    	 this.context = context;
	         this.listTema = listTema;
		}

		public int getCount() {
	        return listTema.size();
	    }

	    public Object getItem(int position) {
	        return listTema.get(position);
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup viewGroup) {
	    	  ListTemas entry = new ListTemas(context, listTema.get(position) ); 
	       /* Temas entry = listTema.get(position);
	        if (convertView == null) {
	            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = inflater.inflate(R.layout.temas_row2 , null);
	        }
  	        TextView tvTitle = (TextView) convertView.findViewById(R.id.txtTtitulo);
	        tvTitle.setText(entry.getTitulo());
	        
	        return convertView;
	        */
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

