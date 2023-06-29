package pojos;

public class Categoria {
	
	long categoria_id;
	String nombre;
	
	
	
	public Categoria() {
		super();
	}
	
	public Categoria(String nombre) { 
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
