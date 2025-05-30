package dominio;

public class TipoSeguro {
	
	private int Id;
	private String Descripcion;
	
	public TipoSeguro() {
		// Constructor vacio
	}

	public TipoSeguro(int id, String descripcion) {
		this.Id = id;
		this.Descripcion = descripcion;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "tipoSeguro [Id=" + Id + ", Descripcion=" + Descripcion + "]";
	}

}
