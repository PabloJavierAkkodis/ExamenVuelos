package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojos.Vuelo;
import pojos.Vuelo.Tipo;

public class FileManager {

	private static FileManager instance;

	private FileManager() {
		super();
	}
	
	public static FileManager getFM(){
		if(instance == null) {
			return new FileManager();
		} else {
			return instance;
		}
	}
	
	public ArrayList<Vuelo> readVuelos(){
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		 try
		 		{
		 		File documento = new File(".\\vuelos1.txt");
		 		BufferedReader leer_fichero = new BufferedReader(new FileReader(documento));
		 		String caracteres = "";
		 		while((caracteres = leer_fichero.readLine()) != null)
		 		{
		 			
		 			String[] arrOfStr = caracteres.split("\t");
		 			
		 			String aux = arrOfStr[2];
					Tipo tipo = Tipo.Premier;
					if(aux == "Economico") {
						tipo = Tipo.Economico;
					}
		 			 
		 			vuelos.add(new Vuelo(arrOfStr[0],
		 					Integer.valueOf(arrOfStr[1]),
		 					tipo,
		 					Double.valueOf(arrOfStr[3])));

		 		}
		 	}
		 	catch (IOException e)
		 	{
		 		e.printStackTrace();
		 	}
		
		
		return vuelos;
	}
	
	public void writeVuelos(ArrayList<Vuelo> vuelos){
		
		try {
			//Declarar la ruta y el nombre de archivo con la extension del mismo
		String ruta = ".\\vuelos1.txt";
		//Inicializo la clase File que me permite crear el archivo.
		File archivo = new File(ruta);
		if(! archivo.exists())
		{
		archivo.createNewFile(); //utilizo el metodo createNewFile() para crear el archivo.
		System.out.println("Se ha generado el archivo.");	
		}
		FileWriter fw = new FileWriter(archivo); //El FileWriter es el encargado de habilitar la opción de escritura
		BufferedWriter bw = new BufferedWriter(fw); //BufferedWritter es el encargado de realizar la acción de escritura.
		
		for(Vuelo vuelo : vuelos) {
			bw.write(vuelo.toString());
		}
		
		
		bw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
