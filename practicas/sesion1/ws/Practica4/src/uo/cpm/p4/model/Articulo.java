package uo.cpm.p4.model;

public class Articulo {

	private String codigo;
	private String tipo;
	private String denominacion;
	private float precio;
	private int unidades;

	
	/**
	 * Crea una instancia del objeto con su codigo, tipo, denominacion, precio y unidades
	 * @param codigo
	 * @param tipo
	 * @param denominacion
	 * @param precio
	 * @param unidades
	 */
	public Articulo(String codigo, String tipo, String denominacion, float precio, int unidades) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.precio = precio;
		this.unidades = unidades;
	}

	/**
	 * Crea un articulo en base a los parametro del articulo dado en parametro
	 * @param otroArticulo
	 */
	public Articulo(Articulo otroArticulo) {
		this(otroArticulo.codigo, otroArticulo.tipo, otroArticulo.denominacion, otroArticulo.precio,
				otroArticulo.unidades);
	}

	/**
	 * Devuelve la denominacion el objeto
	 * @return denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * Establece la denominacion del objeto
	 * @param denominacion
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * Obtiene el precio del  producto
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene el codigo del producto
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece le codigo del producto
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene las unidades restantes del producto
	 * @return unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	
	/**
	 * Establece las unidades del producto
	 * @param unidades
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	
	/**
	 * Devuelve la cadena toString del objeto
	 * @return string with object info
	 */
	public String toString() {
		String strArticulo;
		strArticulo = this.tipo + " - " + this.denominacion + " - " + this.precio + " Euros";
		if (this.unidades != 0) {
			strArticulo += " (" + this.unidades + " uds." + ")";
		}
		return strArticulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
}
