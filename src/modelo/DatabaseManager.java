package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager  extends SQLiteOpenHelper {
	public DatabaseManager(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	
	public static final String TABLE_NAME = "temas";
	public static final String TABLE_NAME2 = "respuesta";
	
	//-------------TEMAS-----------------------
	public static final String CN_ID = "Id_Tema";
	public static final String CN_TITULO = "Titulo";
	public static final String CN_PREGUNTA = "Pregunta";
	public static final String CN_FECHA = "Fecha";
	public static final String CN_ESTADO = "Estado";
	public static final String CN_NOMBREUSUARIO = "NombreUsuario";
	public static final String CN_EMAIL = "Email";
	
	//------------RESPUESTA---------------------
	public static final String CN_IDRESPUESTA = "Id_Respuesta";
	public static final String CN_TEMA = "Id_Tema";
	public static final String CN_RESPUESTA = "Respuesta";
	public static final String CN_FECHARESP = "Fecha";
	public static final String CN_X = "X";
	public static final String CN_Y = "Y";
	public static final String CN_NOMBREUSUARIORESP = "NombreUsuario";
	public static final String CN_EMAILRESP = "Email";
	
	
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS respuesta ("
			+ CN_IDRESPUESTA + " integer primary key autoincrement,"
			+ CN_TEMA + " integer ,"
			+ CN_RESPUESTA + " text not null," 
			+ CN_FECHARESP + " text not null,"
			+ CN_X + " real not null,"
			+ CN_Y + " real not null,"
			+ CN_NOMBREUSUARIORESP + " text not null,"
			+ CN_EMAILRESP + " text not null);";
	
	public static final String CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS temas ("
			+ CN_ID + " integer primary key autoincrement,"
			+ CN_TITULO + " text not null," 
			+ CN_PREGUNTA + " text not null,"
			+ CN_FECHA + " text not null,"
			+ CN_ESTADO + " text not null,"
			+ CN_NOMBREUSUARIO + " text not null,"
			+ CN_EMAIL + " text not null);";
	
	        //Insertamos un tema
			// Equivaldra a ejecutar la siguiente sentencia:
			// insert into temas (id_tema, titulo, pregunta, fecha, estado, nombreusuario, email) values campoClave, campoValor, date(now)
			public void insertar_tema( String titulo, String pregunta,String nombreusuario, String email)
			{
			    // Obtenemos la base de datos en modo lectura y escritura
				SQLiteDatabase db = getWritableDatabase();
				// Creamos una nueva fila, a la que le añadimos pares clave-valor
				// con el nombre de la columna y su contenido.
				ContentValues row = new ContentValues();
				
				row.put(CN_TITULO, titulo);
				row.put(CN_PREGUNTA, pregunta);
				row.put(CN_FECHA, "date(now)");
				row.put(CN_ESTADO, "1");
				row.put(CN_NOMBREUSUARIO, nombreusuario);
				row.put(CN_EMAIL, email);
				
				db.insert(TABLE_NAME, null, row);
			
				
				db.close();
			}
			
			//Insertamos una respuesta
			// Equivaldra a ejecutar la siguiente sentencia:
			// insert into respuesta (id_tema, titulo, pregunta, fecha, estado, nombreusuario, email) values campoClave, campoValor, date(now)
			public void insertar_respuesta(Integer id_tema, String respuesta, String fecha, Float X, Float Y, String nombreusuario, String email)
			{
			    // Obtenemos la base de datos en modo lectura y escritura
				SQLiteDatabase db = getWritableDatabase();
				// Creamos una nueva fila, a la que le añadimos pares clave-valor
				// con el nombre de la columna y su contenido.
				ContentValues row = new ContentValues();
				
				row.put(CN_RESPUESTA, respuesta);
				row.put(CN_TEMA, respuesta);
				row.put(CN_FECHARESP, "date(now)");
				row.put(CN_X,X );
				row.put(CN_Y, Y);
				row.put(CN_NOMBREUSUARIORESP, nombreusuario);
				row.put(CN_EMAILRESP, email);
				
				db.insert(TABLE_NAME2, null, row);
				
				db.close();
			}

			public ArrayList<HashMap<String, String>> getAllTemas() {
				ArrayList<HashMap<String, String>> wordList; wordList = new ArrayList<HashMap<String, String>>();
				String selectQuery = "SELECT * FROM temas"; 
				SQLiteDatabase database = this.getWritableDatabase();
				Cursor cursor = database.rawQuery(selectQuery, null); 
				if (cursor.moveToFirst()) {
					do { 
					HashMap<String, String> map = new HashMap<String, String>(); 
					map.put(CN_ID, cursor.getString(0)); 
					map.put(CN_TITULO, cursor.getString(1));
					map.put(CN_PREGUNTA, cursor.getString(2));
					map.put(CN_FECHA, cursor.getString(3));
					map.put(CN_ESTADO, cursor.getString(4));
					map.put(CN_NOMBREUSUARIO, cursor.getString(5));
					map.put(CN_EMAIL, cursor.getString(6));
					wordList.add(map);
					}while (cursor.moveToNext()); 
					} // return temas list return wordList; }
				return wordList;
			}
			
			public ArrayList<HashMap<String, String>> getAllRespuestas(Integer id_tema) {
				ArrayList<HashMap<String, String>> wordList; wordList = new ArrayList<HashMap<String, String>>();
				String selectQuery = "SELECT * FROM respuestas where Id_Tema='"+id_tema+"'";
     			SQLiteDatabase database = this.getWritableDatabase();
				Cursor cursor = database.rawQuery(selectQuery, null); 
				if (cursor.moveToFirst()) {
					do { 
					HashMap<String, String> map = new HashMap<String, String>(); 
					map.put(CN_IDRESPUESTA, cursor.getString(0)); 
					map.put(CN_TITULO, cursor.getString(1));
					map.put(CN_TITULO, cursor.getString(1));
					map.put(CN_PREGUNTA, cursor.getString(2));
					map.put(CN_FECHA, cursor.getString(3));
					map.put(CN_ESTADO, cursor.getString(4));
					map.put(CN_NOMBREUSUARIO, cursor.getString(5));
					map.put(CN_EMAIL, cursor.getString(6));
					wordList.add(map);
					}while (cursor.moveToNext()); 
					} // return temas list return wordList; }
				return wordList;
			}

		


			@Override
			public void onCreate(SQLiteDatabase db) {
				// TODO Auto-generated method stub
				
			}




			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion,
					int newVersion) {
				// TODO Auto-generated method stub
				
			}
}