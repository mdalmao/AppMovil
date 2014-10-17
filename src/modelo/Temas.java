package modelo;


public class Temas {
	
	    private Integer id_tema;
	    private String titulo;
	    private String pregunta;
	   	private String fecha;
	    private String estado;
	    private String nombreusuario;
	    private String email;
	
	    public Temas(Integer id_tema,String titulo, String pregunta, String fecha, String estado, String nombreusuario, String email) {
	    	   super();
	    	   this.setId_tema(id_tema);
	           this.setTitulo(titulo);
	           this.setPregunta(pregunta);
	           this.setFecha(fecha);
	           this.setEstado(estado);
	           this.setNombreusuario(nombreusuario);
	           this.setEmail(email);
	                   
	    }

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getId_tema() {
			return id_tema;
		}

		public void setId_tema(Integer id_tema) {
			this.id_tema = id_tema;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getPregunta() {
			return pregunta;
		}

		public void setPregunta(String pregunta) {
			this.pregunta = pregunta;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getNombreusuario() {
			return nombreusuario;
		}

		public void setNombreusuario(String nombreusuario) {
			this.nombreusuario = nombreusuario;
		}
	    
	}


