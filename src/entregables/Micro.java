package entregables;



public class Micro {
	private String destino;
	private Fecha fecha;
	private float importe;
	private int cantidadDeAsientos;
	private boolean[] asientos; 
	private int asientosLibres;
	private int lugarLibre;
	
	
	/*
	 IREP de Micro: 
	 	Fecha posee siete variables de instacia,
	 	
	 	*Un String destino, que tiene que tener entre 3 y 100 caracteres incluidos
	 	
	 	*Un objeto fecha tipo Fecha que tiene que cumplir con el irep de fecha.
	 	
	 	*Un flotante importe que solo puede tomar valores positivos
	 	
	 	*Un entero cantidadDeAsientos que solo puede tomar valores positivos (mayor estricto a cero)
	 	
	 	*Un arreglo de tipo booleano asientos[], que representa con el valor en cada indice si el asiento
	 	 esta ocupado o no
	 	 Toma valor true en el lugar i si el número de este asiento esta ocupado y false si no
	 	 La longitud de este arreglo debe ser igual al valor de cantidadDeAsientos.
	 	 
	 	*Un entero asientosLibres el cual toma valores  enteros entre 0 y cantidadDeAsientos incluidos
	 	 esta variable esta relacionada con la variable asientos[], ya que debe ser la cantidad de elementos
	 	 del arreglo que tienen valor false.
	 	 
	 	 *Un entero lugarLibre que toma valores entre 0 y cantidadDeAsientos incluidos, esta variable representa
	 	  un asiento libre, por lo que cuando el micro esta lleno se le asigna el valor cantidadDeAsientos, ya que 
	 	  este no es un numero de asiento valido para ocupar.
	 	  lugarLibre debe cumpler que asientos[lugarLibre]=false
	 	 *
	 	 *
	 	 *Nota: Agrege varias variables de instancia para que la implementacion sea mas sencilla
	 	 	estas variables de instancia no son pasadas al constructor, ya que en la especificacion
	 	 	aclara: para estos micros la empresa define un destino, una fecha, 
	 	 			un importe de valor del asiento y una cantidad de asientos.
	 	* */
	
	
	private Micro(String destino,Fecha fecha,float importe,int cantidadDeAsientos) {
		if(destino.length()<3 || destino.length()>100) {throw new RuntimeException("El destino no es valido");}
		if(!fecha.esValida()) {throw new RuntimeException("Fecha no valida");}
		if(importe<0) {throw new RuntimeException ("Importe negativo");}
		if(cantidadDeAsientos<1) {throw new RuntimeException("El micro no tiene asientos");}
		
		
		
		this.destino=destino;
		this.fecha=fecha;
		this.importe=importe;
		this.cantidadDeAsientos=cantidadDeAsientos;
		this.asientos = new boolean[cantidadDeAsientos];
		this.asientosLibres=cantidadDeAsientos;
		this.lugarLibre=0;
		
		for(int i=0;i<this.asientos.length;i++) {
			this.asientos[i]=false;
		} 
	}
	
	private boolean ocuparAsiento(int lugar) {
		if(lugar>cantidadDeAsientos && lugar>0) {
			return false;
		}
		if(this.asientos[lugar]) {
			return false;
		}
		else {
			if(this.asientosLibres<1) {
				this.lugarLibre=this.cantidadDeAsientos;
			}else {
				for(int i=0;i<this.asientos.length;i++) {
					if(!this.asientos[i]) this.lugarLibre=i;
				}
			}
			this.asientos[lugar]=true;
			this.asientosLibres--;
			return true;
		}
	}
	
	private boolean asientoOcupado(int lugar) {
		return asientos[lugar];
	}
	
	private int cantidadDeAsientosLibres(){
		return this.asientosLibres;
	}
	
	private int verAsientoLibre() {
		return this.lugarLibre;
	}
	
	private int cantidadDeAsientosOcupados(){
		return this.cantidadDeAsientos-this.asientosLibres;
	}
	private void liberarAsiento(int lugar) {
		this.asientos[lugar]=false;
		this.asientosLibres++;
	}
	
	private void cambiarMicros(Micro m2) {
		int i=0;
		int j=0;
		while(m2.asientosLibres>0 && i<this.cantidadDeAsientos && this.cantidadDeAsientosOcupados()>0) {
			if(this.asientos[i]) {
				this.liberarAsiento(i);
				m2.ocuparAsiento(j);
				j++;
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		Fecha f  = new Fecha(20,4,2020);
		Micro m1 = new Micro("Mar del Plata",f,500,60);
		Micro m2 = new Micro("Bariloche",f,1500,40);
		
		for(int i=0; i<m1.cantidadDeAsientos;i++) {
			m1.ocuparAsiento(i);
		}
		
		System.out.println("m1.ocuparAsiento(1) debe devolver false, y devuelve: "+m1.ocuparAsiento(1));
		System.out.println("m2.ocuparAsiento(1) debe devolver true,  y devuelve: "+m2.ocuparAsiento(1));
		
		m1.cambiarMicros(m2);
		
		
		System.out.println("Van a Mar del Plata: "+ m1.cantidadDeAsientosOcupados());
		System.out.println("Van a Bariloche: "+ m2.cantidadDeAsientosOcupados());
	}
	
}
