package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pojos.Vuelo;
import pojos.Vuelo.Segmentacion;
import pojos.Vuelo.Tipo;
import utils.FileManager;

public class Main {
	
	static FileManager fm = FileManager.getFM();
	static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	public static void main(String[] args) {
		
		init();

	}

	private static void init() {
		
		
		Scanner sc = new Scanner(System.in);
			System.out.println("############## VUELITOS LOWCOST COMPANY ###############");
			System.out.println("                     - Bienvenido -                    ");
			System.out.println("");
			System.out.println("");
			System.out.println("Leyendo vuelos en la base de datos...");
			vuelos = fm.readVuelos();
			
		while(true) {
			int select;
			System.out.println("Registros obtenidos de la base de datos:");
			System.out.println("   ---------------------------------------------------  ");
			imprimeVuelos();
			System.out.println("   ---------------------------------------------------  ");
			System.out.println("¿Desea editar algun registro? ");
			System.out.println("1	 - Editar vuelo");
			System.out.println("2	 - Añadir vuelo");
			System.out.println("3	 - Borrar vuelo");
			System.out.println("4	 - Imprimir resultados");
			System.out.println("Otro - Cancelar");
			
			try {				
				select = sc.nextInt();
			}catch (Exception e){

		 		break;
		 	}
			
			

			switch (select) {
			
			case 1:
				
				
				

				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("               --------- Editar ---------");
				System.out.println("   ---------------------------------------------------  ");
				imprimeVuelos();
				System.out.println("   ---------------------------------------------------  ");
				
				
				System.out.println("Ingrese numero de vuelo: ");
				
				int vuelo = sc.nextInt() - 1;
				
				System.out.println(vuelos.get(vuelo));
				
				
				System.out.print("   Inserte nombre:  ");
				String nombre =  sc.next();
				vuelos.get(vuelo).setNombre(nombre);
				System.out.println("");

				System.out.print("   Inserte pasajeros:  ");
				int pasajeros = sc.nextInt();
				vuelos.get(vuelo).setPasajeros(pasajeros);
				System.out.println("");

				System.out.print("   Inserte tipo: (1-Eco | 2-Pre) ");
				int aux = sc.nextInt();
				Tipo tipo = Tipo.Premier;
				if(aux == 1) {
					tipo = Tipo.Economico;
				}
				vuelos.get(vuelo).setTipo(tipo);
				System.out.println("");

				System.out.print("   Inserte valorUnitario:  ");
				double vu = sc.nextDouble();
				vuelos.get(vuelo).setValorUnitario(vu);
				System.out.println("");

				System.out.print("   Inserte segmentacion(1- rentable|2- por confirmar):  ");
				int aux2 = sc.nextInt();
				Segmentacion seg = Segmentacion.RENTABLE;
				if(aux == 2) {
					seg = Segmentacion.A_CONFIRMAR;
				}
				vuelos.get(vuelo).setSegmentacion(seg);
				System.out.println("");
				
				
				System.out.print("   Inserte valor FINAL:  ");
				double vf = sc.nextDouble();
				vuelos.get(vuelo).setValorFinal(vf);
				System.out.println("");
				
				
				
				break;
			
			case 2:
				
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("               --------- Añadir ---------");
				System.out.println("   ---------------------------------------------------  ");
				
				System.out.print("   Inserte nombre:  ");
				String nombre2 =  sc.next();
				System.out.println("");

				System.out.print("   Inserte pasajeros:  ");
				int pasajeros2 = sc.nextInt();
				System.out.println("");

				System.out.print("   Inserte tipo: (1-Eco | 2-Pre) ");
				int aux3 = sc.nextInt();
				Tipo tipo2 = Tipo.Premier;
				if(aux3 == 1) {
					tipo2 = Tipo.Economico;
				}
				System.out.println("");

				System.out.print("   Inserte valorUnitario:  ");
				double vu2 = sc.nextDouble();
				System.out.println("");


				vuelos.add(new Vuelo(nombre2, pasajeros2, tipo2, vu2));
				
				
				break;
			case 3:
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("               --------- Borrar ---------");
				System.out.println("   ---------------------------------------------------  ");
				imprimeVuelos();
				System.out.println("   ---------------------------------------------------  ");
				
				System.out.println("Ingrese numero de vuelo: ");
				
				int vueloB = sc.nextInt() - 1;
				
				vuelos.remove(vueloB);
				System.out.println("Borrado vuelo " + vueloB);
				
				break;
				
			case 4:
				
				
				fm.writeVuelos(vuelos);
				
				
				
				break;
			}
			
		
		}
		
		System.out.println("Adios!!");

	}
	
	
	
	private static void imprimeVuelos() {
		int i = 1;
		System.out.println("Nº\t Nombre\t Pasajeros\t Tipo\t ValorPasaje\t ValorFinal\t Segmentacion ");
		for(Vuelo vuelo : vuelos) {
			System.out.println( i + "\t" + vuelo.getNombre()+ "\t" 
		+ vuelo.getPasajeros()+ "\t" + vuelo.getTipo() + "\t" + vuelo.getValorUnitario()
		+ "\t" + vuelo.getValorFinal() + "\t" + vuelo.getSegmentacion());
			i++;
		}
		
	}

}
