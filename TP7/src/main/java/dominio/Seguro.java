package dominio;

public class Seguro {
	
	private int idSeguro;
	private String descripcion;
	private TipoSeguro tipo;
	private float costoContratacion;
	private float costoAsegurado;
	
	///GETTERS & SETTERS
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoSeguro getTipo() {
		return this.tipo;
	}
	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}
	public float getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public float getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	///CONSTRUCTORES
	public Seguro(int idSeguro, String descripcion, TipoSeguro tipo, float costoContratacion, float costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}
	
	public Seguro(){}
	
	///TO-STRING
	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + tipo.getId()
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
	
}
