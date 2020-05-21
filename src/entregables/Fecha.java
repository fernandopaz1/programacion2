package entregables;


public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	/*
	 IREP de Fecha: 
	 	Fecha posee tres variables de instacia, dia, mes y año. Todas en esta implementacion toman valores enteros
	 	anio: es una variable entera que toma valores entre 0 y 3000 sin incluirlos.
	 	mes: es una variable entera que toma valores entre 1 y 12 incluidos 
	 	dia: es una variable entera cuyo valor minimo permitido es el 1 y su valor máximo depende de los valore de
	 	mes y anio.
	 	Si mes es impar el valor maximo permitido de dia es 31.
	 	Si mes es par pero distinto de 2 el valor maximo permitido de dia suele ser 30.
	 	Si mes=2 y anio es divisible por 4 el valor maximo permitido de dia es 29.
	 	Si mes=2 y anio no es divisible por 4 el valor maximo permitido de dia es 28.
	 */
	
	Fecha(int dia,int mes, int anio) {
		if(diaValido(dia,mes,anio)) {
			throw new RuntimeException("Mes fuera de límite");
		}
		if(mesValido(mes)) {
			throw new RuntimeException("Día fuera de límite");
		}
		if(anioValido(anio)) {throw new RuntimeException("Anio fuera de límite");}
		this.dia=dia;
		this.mes=mes;
		this.anio=anio;
	}
	
	private static boolean esAnioBisiesto(int anio) {
		return  anio%4==0 ? true : false;
	}
	
	private static int diasDeMes(int mes,int anio) {
		switch (mes){
			case 2:
				return esAnioBisiesto(anio) ? 29 : 28;
			default:
				return mes%2==0 ? 30:31;
		}
	}
	private void sumarDía() {
		if(dia==diasDeMes(mes,anio)) {
			this.dia=1;
			this.sumarMes();
		}
		else dia++;
	}
	private void sumarMes() {
		if (mes==12) {
			mes=1;
			anio++;
		}else {
			mes++;
		}
	}
	
	private void imprimirFecha() {
		System.out.println(this.dia+"/"+this.mes+"/"+this.anio);
	}
	
	private static boolean diaValido(int dia, int mes, int anio) {
		return (dia<1 || dia>diasDeMes(mes,anio));
	}
	private static boolean mesValido(int mes) {
		return (mes<1 || mes>12);
	}
	private static boolean anioValido(int anio) {
		return !(anio<0 || anio>3000);
	}
	
	public boolean esValida() {
		return (diaValido(this.dia,this.mes,this.anio) || mesValido(this.mes) || anioValido(this.anio)) ? false : true;
	} 
	
	public static void main(String[] args) {
		try {
			Fecha f=new Fecha(29,2,2020);
			f.imprimirFecha();
			}
		catch(RuntimeException ex){
			System.out.println("Fecha no válida");
		}
		
	}
}
