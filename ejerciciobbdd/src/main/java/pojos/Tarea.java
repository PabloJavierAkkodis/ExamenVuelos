package pojos;

import java.util.Date;

public class Tarea {
	
	long tarea_id;
	String nombre;
	Date fecha_limite;
	Categoria categoria;
	public Tarea(String nombre, Date fecha_limite, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.fecha_limite = fecha_limite;
		this.categoria = categoria;
	}
	public Tarea() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_limite() {
		return fecha_limite;
	}
	public void setFecha_limite(Date fecha_limite) {
		this.fecha_limite = fecha_limite;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
