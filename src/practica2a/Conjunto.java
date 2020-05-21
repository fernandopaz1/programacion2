package practica2a;

import java.util.ArrayList;

/*
 * Definir el TAD Conjunto, que se comporta como el conjunto de la teoría de conjuntos.

No se puede utilizar Set ni ninguna de sus subclases para implementarlo.

Es decir, no queremos envolver Set, queremos definirlo basado en otros tipos básicos.
Sugerimos utilizar la clase Array(class Arrays) para el nuevo Tad.

Especificacíon
	Conjunto<T>(){} // Constructor1
	Integer tamaño(){}
	void Agregar(T n) {}
	T iesimo(Interger indice){} // indice< tamaño()
	Void union(Conjunto<T> c){} // union1: Destructiva
	Conjunto<T> union2(Conjunto<T> c){}

// union2: No debe tener Aliasing!
Void interseccion(Conjunto<T> c){} // interseccion 1: Destructiva
Conjunto<T> interseccion2(Conjunto<T> c){} 
 */



public class Conjunto<T> {
	private ArrayList<T> conj;
	private Integer indice;
	
	public Conjunto(){
		this.conj=new ArrayList<T>();
		this.indice=0;
	}
	
	private Integer tamanio() {
		return conj.size();
	}
	
	private boolean pertenece(T n) {
		return this.conj.contains(n);
	}
	
	private boolean agregar(T n) {
		if(this.pertenece(n)) {
			return false;
		}
		this.conj.add(n);  //Tiene aliasing
		return true;
	} 
	
	private boolean quitar(T n) {
		return this.conj.remove(n);
	}
	
	private T iesimo(Integer indice) {
		if(indice>=this.tamanio() || indice<0) {
			return null;
		}else {
			return this.conj.get(indice);
		}
	}
	private T dameUno() {
		T auxiliar= this.conj.get(indice);
		this.indice++;
		if(this.indice>=this.tamanio()) {
			this.indice=0;
		}
		return auxiliar;
		
	}
	
	private Conjunto<T> union(Conjunto<T> c){    //Union no destructiva
		 Conjunto<T> nuevo = new Conjunto<T>();
		 for(int i=0;i<this.tamanio();i++) {
			 nuevo.agregar(this.dameUno());
		 }
		 for(int i=0;i<c.tamanio();i++) {
			 nuevo.agregar(c.dameUno());
		 }
		 return nuevo;
	}
	
	private void union1(Conjunto<T> c){    //Union destructiva
		for(int i=0;i<c.tamanio();i++) {
			this.agregar(c.dameUno());
		}
	}
	
	private Conjunto<T> interseccion(Conjunto<T> c){    //Interseccion no destructiva
		Conjunto<T> nuevo = new Conjunto<T>();
		T auxiliar;
		for(int i=0;i<this.tamanio();i++) {
			auxiliar=this.dameUno();
			if(c.pertenece(auxiliar)) {
				nuevo.agregar(auxiliar);
			}
		 }
		return nuevo;
	}
	
	private void interseccion1(Conjunto<T> c){    //Interseccion no destructiva
		for(int i=0;i<c.tamanio();i++) {
			this.quitar(c.dameUno());
		 }
	}
	
	public String toString() {
		String s="{ ";
		for(int i=0;i<this.tamanio();i++) {
			s=s+this.dameUno().toString()+" ";
		}
		return s+ " }";
	}
	
	public static void main(String[] args) {
		Tupla<Integer,Integer> t1 = new Tupla<Integer,Integer>(1,1);
		Tupla<Integer,Integer> t2 = new Tupla<Integer,Integer>(1,3);
		
		Conjunto<Tupla<Integer,Integer>> c= new Conjunto<Tupla<Integer,Integer>>();
		
		c.agregar(t1);
		c.agregar(t2);
		
		t1.setX(5);
		
		System.out.println(c.toString());
	}
}
