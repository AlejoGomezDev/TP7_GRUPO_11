package dominio;

public class segurosDto {
	
	private int idSeguro;
	private String descripcion;
	private String descTipo;
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
	public String getIdTipo() {
		return descTipo;
	}
	public void setIdTipo(String descTipo) {
		this.descTipo = descTipo;
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
}
