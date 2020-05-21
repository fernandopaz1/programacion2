package practica2a;

/*
 * En algunos casos se necesita modificar el comportamiento de TADs que ya existen.

Realizaremos una implementación de los números naturales(N) basándonos en Integer como el
tipo soporte.

Como Nat se define alrededor de Integer y semánticamente son similares, se dice que Nat
envuelve (redefine) a Integer.

Esto se realiza principalmente, para modificar el comportamiento del tipo base, sin
modificar al tipo base en sí mismo.

En este caso, no queremos números negativos.

Especificación

	Nat(Integer n){} // Constructor. n≥0
	sumar(Nat n){}
	
a) Implementar Nat
Notas: Ocultamiento de información

Implementar también tostring() de manera de poder mostrar los resultados.
Cualquier función o variable que utilice la clase salvo las pedidas en la implementación, deben ser
privadas.
 */

public class Nat {
	private Integer n;

	Nat(Integer n) {
		if(n<0) {
			throw new RuntimeException("Valor negativo no valido para Nat");
		}
		this.n=n;
	}
	
	private Integer sumar(Nat other) {
		return this.n+other.n;
	}
	
	public String toString() {
		String s=" "+this.n.toString()+" ";
		return s;
	}
	
	public static void main(String[] args) {
		Nat a= new Nat(10);
		try{
			Nat b= new Nat(-5);
			}
		catch(RuntimeException ex) {System.out.println("Nat no valido: Valor negativo");}
		
		Nat c= new Nat(8);
		
		System.out.println("El valor de la suma de "+a.toString()+"y " +c.toString()+ "es: "+ a.sumar(c).toString());
	}
}
