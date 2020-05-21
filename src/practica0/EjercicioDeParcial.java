package practica0;

public class EjercicioDeParcial {
	
	public static void main(String[] args) {
		int[] a = {1,2}; 	   	  //con este arreglo da false
		int[] b = {1,4};    	     	  //con este arreglo da true
		int[] c = {1,3}; 	     	  //con este arreglo da true
		int [][] m = {{1,2},{3,4}};
		System.out.print(arregloEnFilas(m,b));
	}
	
	public static boolean arregloEnFilas(int[][] mat, int[] arreglo) {
		boolean estaEnTodasFila=true;  
  
		for(int i=0; i<mat.length; i++) {

			int elemento = arreglo[i];
			boolean estaEnLaFila=false;

			for(int c=0; c<mat.length; c++) {

				estaEnLaFila = estaEnLaFila || (mat[i][c] == elemento);
			}
			estaEnTodasFila=estaEnTodasFila && estaEnLaFila;
		}
		return estaEnTodasFila;
	}
}
