package uo.cpm.examen.model;

public class Articulo {

	private String code;
	private String type;
	private float points;
	private String name;
	private int cantidad;
	
	
	public Articulo(String code,String type, String name,float points, int cantidad) {
		setCode(code);
		setType(type);
		setName(name);
		setPoints(points);
		setCantidad(cantidad);
	}


	void setType(String type) {
		this.type = type;
	}


	void setPoints(float points) {
		this.points = points;
	}


	void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	void setCode(String code) {
		this.code = code;
	}


	public String getType() {
		return type;
	}


	public float getPoints() {
		return points;
	}


	public int getCantidad() {
		return cantidad;
	}


	void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getName() {
		return name;
	}
	
	public String toString() {
		return type+"-"+name+"-"+points;
	}
	public String toStringWithCantidad() {
		return name+"-"+cantidad;
	}
}
