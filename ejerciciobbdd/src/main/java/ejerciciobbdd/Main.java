package ejerciciobbdd;

import java.util.Scanner;

import pojos.Usuario;
import utils.Controller;
import utils.Repository;


public class Main {
	
	static Controller controller = Controller.getRepo();

	public static void main(String[] args) {
		
		
		init();

	}

	private static void init() {
		
	
		Scanner sc = new Scanner(System.in);
		System.out.println("############## BIENVENIDO ###############");
		
		
		
		while(true) {
			int select;
			
			System.out.println("--------- Seleccione una opción ---------");
			System.out.println("1-Usuarios");
			System.out.println("2-Tareas");
			select = sc.nextInt();
			
			
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			if(select == 1) {
				
				
				System.out.println("--------- USUARIOS ---------");
				
				
				controller.mostrarUsuarios();
				
				
				
				System.out.println("1-Borrar un usuario");
				System.out.println("2-Añadir un usuario");
				
				select = sc.nextInt();
				
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				if(select == 1) {
					System.out.print("Indique numero de usuario: ");
					int user = sc.nextInt();
					
					
					controller.borrarUser(user);
					
					
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
				}else {
					String nombre;
					int edad;
					System.out.print("Inserte nombre: ");
					nombre = sc.next();
					System.out.print("Inserte edad: ");
					edad = sc.nextInt();
					
					Usuario user = new Usuario(nombre, edad);
					
					
					controller.insertarUser(user);
					
					
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
				}
				
				
			}else {
				
				
				System.out.println("--------- TAREAS ---------");
				controller.leerTareas();
				System.out.println("1-Filtrar por usuario");
				System.out.println("2-Ver detalle tarea");
				
				
				select = sc.nextInt();
				
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
			
				switch (select) {
					case 1 :
						System.out.print("Indique nombre de usuario: ");
						String user = sc.next();
						System.out.println("");
						
						controller.leerTareas(user);
						System.out.println("");
						break;
						
					case 2 :
						
						System.out.print("Indique numero de tarea: ");
						int tarea = sc.nextInt();
						System.out.println("");
						
						//TODO: LEER TAREA POR NUMERO, CON COMENTARIOS, CON CATEGORIA
						controller.leerTareaDetalle(tarea);
						
						System.out.println("1-Añadir comentario");
						System.out.println("2-Añadir usuario");
						System.out.println("3-Borrar tarea");
						
						select = sc.nextInt();
						System.out.println("");
						
						if(select == 3) {
							
							controller.borrarTarea(tarea);
							
						}else {
							System.out.println("Accion no desarrollada DE MOMENTO");

						}
						
						break;
				}
				
				
				
			}
			
			
		}
		
	}

}
