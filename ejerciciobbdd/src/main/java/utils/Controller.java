package utils;

import pojos.Usuario;

public class Controller extends Repository{
	
	private static Controller instance;

	public static Controller getRepo() {
		if(instance == null) {
			return new Controller();
		} else {
			return instance;
		}
	}
	public Controller() {
		super();
		instance = this;
	}

	/*------ Controller methods -------*/


	public void mostrarUsuarios() {
		
		System.out.println("No \tNombre \tEdad");
		this.readTable("usuario");
		
	}
	
	
	public void insertarUser(Usuario user) {
		System.out.println("INSERTANDO USER");
		this.insertUser(user.getNombre(),user.getEdad());
		mostrarUsuarios();
		
	}
	
	public void borrarUser(int user) {
		System.out.println("BORRANDO USER");
		this.borrarPorId("usuario", user);
	}
	
	
	public void leerTareas() {
		
		System.out.println("No \tNombre \tFecha");
		this.readTable("tarea");
		
	}
	
	
	public void leerTareas(String usuario){
		
		System.out.println("No \tNombre \tFecha");
		this.readTable("tarea");
		
	}
	
	public void leerTareaDetalle(int tareaId) {
		
		System.out.println("No \tNombre \tFecha");
		this.readTable("tarea");
		
	}
	public void borrarTarea(int tarea) {

		System.out.println("BORRANDO tarea");
		this.borrarPorId("tarea", tarea);
		
	}
	
	
	
	

}
