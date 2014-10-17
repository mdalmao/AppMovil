package modelo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

	private static final String DB_NAME = "tarea.sqlite";
	private static final int DB_SCHEME_VERSION = 1;
		
	
	public DBHelper(Context context) {		
		super(context, DB_NAME, null, DB_SCHEME_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//db.execSQL(DatabaseManager.CREATE_TABLE);
		//db.execSQL(DatabaseManager.CREATE_TABLE2);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
