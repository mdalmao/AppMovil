package modelo;

public class Respuesta {
     
	    private Integer id_respuesta;
	    private Integer Id_Tema;
	    private String Respuesta;
	    private String Fecha;
	    private Float X;
	    private Float Y;
	    private String NombreUsuario;
	    private String email;
	    
	    public Respuesta(Integer id_respuesta, Integer id_tema,String respuesta, String fecha, Float X, Float Y, String nombreusuario, String email) {
	    	   super();
	    	   this.setId_Tema(id_tema);
	    	   this.setId_respuesta(id_respuesta);
	           this.setRespuesta(respuesta);
	           this.setFecha(fecha);
	           this.setX(X);
	           this.setY(Y);
	           this.setNombreUsuario(nombreusuario);
	           this.setEmail(email);
	                   
	    }
	    
	    public Respuesta() {
			super();
			this.setEmail("");
			this.setFecha("");
			this.setId_respuesta(0);
			this.setId_Tema(0);
			this.setNombreUsuario("");
			this.setRespuesta("");
			this.setX((float) 0);
			this.setY((float) 0);
	    }
	    
		public Integer getId_respuesta() {
			return id_respuesta;
		}
		public void setId_respuesta(Integer id_respuesta) {
			this.id_respuesta = id_respuesta;
		}
		public Integer getId_Tema() {
			return Id_Tema;
		}
		public void setId_Tema(Integer id_Tema) {
			Id_Tema = id_Tema;
		}
		public String getRespuesta() {
			return Respuesta;
		}
		public void setRespuesta(String respuesta) {
			Respuesta = respuesta;
		}
		public String getFecha() {
			return Fecha;
		}
		public void setFecha(String fecha) {
			Fecha = fecha;
		}
		public Float getX() {
			return X;
		}
		public void setX(Float x) {
			X = x;
		}
		public Float getY() {
			return Y;
		}
		public void setY(Float y) {
			Y = y;
		}
		public String getNombreUsuario() {
			return NombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			NombreUsuario = nombreUsuario;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}
