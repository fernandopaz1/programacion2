package practica2a;

import java.util.ArrayList;

/*
 * Muchas veces necesitamos una estructura de datos que relacione dos TADs. Para ello
utilizaremos un par (o una tupla) de elementos dentro del TAD Tupla.

Especificacíon (Tupla de T1,T2)
	TuplaIntegerInteger (T1 x, T2 y){}
	T1 getX(){}
	T2 getY(){}
	Void setX(T1 x){}
	Void setY(T2 y){}
	
Respetando esta especificación se pide:
a) Implementar el TAD Tupla.
b) Implementar una lista de coordenadas, que se representara mediante un ArrayList de
Tupla<Integer,Integer>
a. Ej: ArrayList<Tupla<Integer,Integer> > coordenadas;
*/

public class Tupla<T1,T2> {
	T1 x;
	T2 y;
	
	Tupla(T1 x,T2 y){
		this.x=x;
		this.y=y;
	}
	
	public T1 getX() {
		T1 x=this.x;
		return x;
	}
	public T2 getY() {
		T2 y=this.y;
		return y;
	}
	
	public void setX(T1 x) {   //Solo estan en public los seters para usarlos en el ejemplo de conjunto
		this.x=x;
	}
	public void setY(T2 y) {
		this.y=y;
	}
	
	public String toString() {
		String s="{ "+this.x.toString()+";" +this.y.toString()+" }";
		return s;
	}
	
	@Override
	public Tupla<T1,T2> clone(){
		Tupla<T1,T2> t=new Tupla<T1,T2>(this.getX(),this.getY()); 
		return t;
	}
	
	public static void main(String[] args) {
		Tupla<Integer, Integer> a= new Tupla<Integer,Integer>(5,2);
		Tupla<Integer, Integer> b= new Tupla<Integer,Integer>(8,3);
		a.setX(10);
		b.setY(42);
		
		ArrayList<Tupla<Integer, Integer>> array=new ArrayList<Tupla<Integer,Integer>>();
		array.add(a);
		array.add(b);
		System.out.println(array.toString());
	}

}
