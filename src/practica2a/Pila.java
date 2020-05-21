package practica2a;
import java.util.LinkedList;

/*
 * Ejercicio 4: Pila de T
 * 
a) Implementar la Pila de enteros, sin envolver el tipo Stack.

Especificación (operaciones básicas)

PilaInt<T>(){} // Constructor1
Boolean vacia()
Void agregar (T n){} // Agrega en la cima.
T quitar(){} // Quita de la cima.
T cima(){} // Devuelve la cima sin quitarla.

b) Implementar los siguientes métodos utilizando solamente las operaciones básicas

T minimo(){} // obtiene y quita el mínimo de la pila*
void ordenar(){}
void MezclarOrdenar(PilaInt pila2){}
Pila<T> MezclarOrdenar(Pila<T> pila2){}
Pila<T> OrdenarMezclar(Pila<T> pila2){}
* Asumir que T tiene un método Integer compareTo(T e2)
* Que devuelve -1 cuando e2 < this

ordenar()   Deja la pila ordenada.
MezclarOrdenar()  Mezcla pila2 con this y luego ordena this
PilaInt MezclarOrdenar(PilaExtendida pila2) Hace lo mismo, pero devuelve una referencia a
otra pila (no genera aliasing).
Pila<T> OrdenarMezclar (Pila<T> pila2) Ordena this y pila2. Luego hace un merge de las dos
pilas de manera inteligente, recorriendo una sola vez cada pila.
Ayuda:
Como ambas pilas están ordenadas se puede recorrer las dos pilas con dos
punteros, tomando los elementos según correspondan.
c) Calcular el Orden de complejidad de los métodos
odenar()
MezclarOrdenar()
OrdenarMezclar()
¿Cuál tarda menos, MezclarOrdenar() u OrdenarMezclar() ?
 */

public class Pila<T extends Comparable<T>> {
	private LinkedList<T> pila;
	
	
	public Pila(){
		pila=new LinkedList<T>();
	}
	
	private boolean vacia() {
		return this.pila.isEmpty();
	}
	
	private void agregar(T e) {
		this.pila.addFirst(e);
	}
	
	private T quitar() {
		return this.pila.removeFirst();
	}

	private T cima() {
		return this.pila.getFirst();
	}
	
	private T minimo() {
		Pila<T> auxiliar = new Pila<T>();
		T minimo= quitar();
		while(!this.vacia()) {
			if(minimo.compareTo(this.cima())>0) {
				minimo=this.cima();
			}
			auxiliar.agregar(this.quitar());	
		}
		while(!auxiliar.vacia()) {
			if(!minimo.equals(auxiliar.cima())) {
				this.agregar(auxiliar.cima());
			}
		}
		return minimo;
	}
	
	private void ordenar() {
		Pila<T> ordenada=new Pila<T>();
		while(!this.vacia()) {
			ordenada.agregar(this.minimo());
		}
		while(!ordenada.vacia()) {
			this.agregar(ordenada.quitar());
		}
	}
	
	private void mezclarDestructivo(Pila<T> p) {
		while(!p.vacia()) {
			this.agregar(p.quitar());
		}
	}
	
	private Pila<T> mezclar(Pila<T> p) {
		Pila<T> nueva = new Pila<T>();
		while(!p.vacia()) {
			nueva.agregar(p.quitar());
		}
		while(!this.vacia()) {
			nueva.agregar(this.quitar());
		}
		
		return nueva;
	}
	
	private void mezclarOrdenar(Pila<T> p) {
		this.mezclarDestructivo(p);
		this.ordenar();
	}
	
	private Pila<T> ordenarMezclar(Pila<T> p){
		this.ordenar();
		p.ordenar();
		Pila<T> nueva= new Pila<T>();
		
		while(!this.vacia() || !p.vacia()) {
			if(this.cima().compareTo(this.cima())>0) {
				nueva.agregar(this.quitar());
				this.agregar(nueva.cima());
			}else {
				nueva.agregar(p.quitar());
				p.agregar(nueva.cima());
			}
		}
		return nueva;
	}
}
