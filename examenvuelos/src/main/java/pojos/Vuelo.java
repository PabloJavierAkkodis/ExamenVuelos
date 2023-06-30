package pojos;

public class Vuelo {
	
//	-	Nombre del vuelo
//	-	Cantidad de pasajeros
//	-	Tipo de pasaje
//	-	Valor unitario del pasaje
//	
//		ValorFinalPorVuelo = ValorUnitario * Cant Pasajeros
//		Segmentación =  Si Tipo_pasaje = Económico && ValorFinalPorVuelo >= 100 Entonces es Rentable
//						Si Tipo_pasaje = Económico && ValorFinalPorVuelo < 100 Entonces es No Rentable
//						Si Tipo_pasaje = Premier   && ValorFinalPorVuelo >= 1500 Entonces es Rentable
//						Si Tipo_pasaje = Premier   && ValorFinalPorVuelo < 1500 Entonces no es Rentable
	
	String nombre;
	int pasajeros;
	double valorUnitario;
	
	public enum Tipo {
		Economico,
		Premier
	}
	Tipo tipo;
	
	double valorFinal;
	
	public enum Segmentacion {
		RENTABLE,
		A_CONFIRMAR
	}
	Segmentacion segmentacion;
	
	
	public Vuelo(String nombre, int pasajeros, Tipo tipo, double valorUnitario) {
		super();
		this.nombre = nombre;
		this.pasajeros = pasajeros;
		this.tipo = tipo;
		this.valorUnitario = valorUnitario;
		
		
		
		calcular();
		
	}
	
	
	private void calcular() {
		this.valorFinal = valorUnitario * pasajeros;
		if( tipo == Tipo.Economico && valorFinal >= 100 ||
				tipo == Tipo.Premier && valorFinal >= 1500	) {
				
				this.segmentacion = Segmentacion.RENTABLE;
				
			}else {
				this.segmentacion = Segmentacion.A_CONFIRMAR;

			}
	}


	public Vuelo() {
		super();
	}





	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPasajeros() {
		return pasajeros;
		
	}


	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
		calcular();
	}


	public double getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
		calcular();
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
		calcular();
	}


	public double getValorFinal() {
		return valorFinal;
	}


	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
		if( tipo == Tipo.Economico && valorFinal >= 100 ||
				tipo == Tipo.Premier && valorFinal >= 1500	) {
				
				this.segmentacion = Segmentacion.RENTABLE;
				
			}else {
				this.segmentacion = Segmentacion.A_CONFIRMAR;

			}
	}


	public Segmentacion getSegmentacion() {
		return segmentacion;
	}


	public void setSegmentacion(Segmentacion segmentacion) {
		this.segmentacion = segmentacion;
	}


	@Override
	public String toString() {
		return  this.nombre + "\t" 
				+  this.pasajeros + "\t" 
				+  this.tipo + "\t"
				+  this.valorUnitario + "\t" 
				+  this.valorFinal + "\t" 
				+ this.segmentacion + "\n" ;
	}
	
	
	
	

}
