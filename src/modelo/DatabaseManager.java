package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager  extends SQLiteOpenHelper {
	public DatabaseManager(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	
	public static SQLiteDatabase db;
	
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
			+ CN_X + " float not null,"
			+ CN_Y + " float not null,"
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

			public static ArrayList<Temas> getAllTemas() {
				ArrayList<Temas> wordList; 
				wordList = new ArrayList<Temas>();
				
			 String selectQuery = "SELECT * FROM temas"; 
			   
			 Cursor cursor = db.rawQuery(selectQuery, null); 
			 if (cursor.moveToFirst()) {
					do { 
				    Temas map = new Temas(); 
					//map.seput(CN_ID, cursor.getString(0));
				    map.setId_tema(cursor.getInt(0));
					map.setTitulo(cursor.getString(1));
					map.setPregunta(cursor.getString(2));
					map.setFecha(cursor.getString(3));
					map.setEstado(cursor.getString(4));
					map.setNombreusuario(cursor.getString(5));
					map.setEmail( cursor.getString(6));
					wordList.add(map);
					}while (cursor.moveToNext()); 
					} // return temas list return wordList; }
				Log.e("DATOS_rEC","RECUPERA miraaaa "+wordList.get(0).getId_tema());
				return wordList;
			}
			
			
			public static ArrayList<Temas> BuscarPalabra(String textSearch, String tipoSearch){
				ArrayList<Temas> wordList; 
				wordList = new ArrayList<Temas>();
				
			
				if(tipoSearch.equals("Usuario")){
					Log.e("DATOS","entro a la igualdad");
					tipoSearch = "nombreusuario";
				}
				
				String selectQuery = "SELECT * FROM temas WHERE " + tipoSearch + " LIKE '%" + textSearch + "%'"; 
				
				if(selectQuery.isEmpty())
				{
					return null;
				}
				else
				{
					Cursor cursor = db.rawQuery(selectQuery, null); 
					 if (cursor.moveToFirst()) {
							do { 
						    Temas map = new Temas(); 
							//map.seput(CN_ID, cursor.getString(0));
						    map.setId_tema(cursor.getInt(0));
							map.setTitulo(cursor.getString(1));
							map.setPregunta(cursor.getString(2));
							map.setFecha(cursor.getString(3));
							map.setEstado(cursor.getString(4));
							map.setNombreusuario(cursor.getString(5));
							map.setEmail( cursor.getString(6));
							wordList.add(map);
							}while (cursor.moveToNext()); 
							} // return temas list return wordList; }
					Log.e("DATOS_rEC","RECUPERA "+wordList.get(0).getId_tema());								
					return wordList;
				}
				
												
			}
			
			
			//Integer id_respuesta, Integer id_tema,String respuesta, String fecha, Float X, Float Y, String nombreusuario, String email
			public static ArrayList<Respuesta> getAllRespuestas(Integer id_tema) {
				ArrayList<Respuesta> wordList; 
				wordList = new ArrayList<Respuesta>();
				String selectQuery = "SELECT * FROM respuesta "; 
				Cursor cursor = db.rawQuery(selectQuery, null);
				if (cursor.moveToFirst()) {
					do { 
				   if ( cursor.getInt(1) == id_tema){
						Respuesta map = new Respuesta(cursor.getInt(0),cursor.getInt(1), cursor.getString(2),  cursor.getString(3), cursor.getFloat(4),  cursor.getFloat(5),  cursor.getString(6),  cursor.getString(7)); 
					    wordList.add(map);
				    }
					}while (cursor.moveToNext()); 
					} // return respuesta list return wordList; }
				return wordList;
			}

			//Integer id_respuesta, Integer id_tema,String respuesta, String fecha, Float X, Float Y, String nombreusuario, String email
			public static ArrayList<Respuesta> NotificacionMail(Integer id_tema) {
				ArrayList<Respuesta> wordList; 
				wordList = new ArrayList<Respuesta>();
				String selectQuery = "SELECT * FROM respuesta "; 
				Cursor cursor = db.rawQuery(selectQuery, null);
				if (cursor.moveToFirst()) {
					do { 
				    if ( cursor.getInt(1) == id_tema){
						//Respuesta map = new Respuesta(cursor.getInt(0),cursor.getInt(1), cursor.getString(2),  cursor.getString(3), cursor.getFloat(4),  cursor.getFloat(5),  cursor.getString(6),  cursor.getString(7)); 
					   // wordList.add(map);
				    	String email = cursor.getString(7);
				    	
				    }
					}while (cursor.moveToNext()); 
					} // return respuesta list return wordList; }
				return wordList;
			}
		


			@Override
			public void onCreate(SQLiteDatabase db) {
				
			}

    		@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion,
					int newVersion) {
				// TODO Auto-generated method stub
				
			}

			public static String getInfoTema(long id) {
				String texto= "";
				    String selectQuery = "SELECT * FROM temas "; 
					Cursor cursor = db.rawQuery(selectQuery, null);
					if (cursor.moveToFirst()) {
						do { 
					   if ( cursor.getInt(0) == id+1){
						    texto= "Creador de " +  cursor.getString(1) + " es " + cursor.getString(5) ;
					    }
						}while (cursor.moveToNext()); 
						} // return respuesta list return wordList; }
				
				
				return texto;
				
			}
			
	}