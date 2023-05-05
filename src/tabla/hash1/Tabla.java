/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.hash1;



/**
 *
 * @author Gonza
 */
public class Tabla {
       int[] T;
     final int tamaño;
     private final double Const;

    
     //constructor de la tabla hash
     public Tabla(int tamaño){
        this.Const  = 0.6180334;
        this.tamaño = tamaño;
        this.T=new int[tamaño];
    }

    // El metodo Math.abs es para sacar el valor absoluto de un numero, es para que el numero siemore sea un numero positivo 
    // funcion para sacar el modular de un numero 
    public int aModular (int x){    
        return Math.abs(x%tamaño);
    }
    //lo inserta
    public void insertModular(int e){
        T[aModular(e)]=e;
    }
    
    //Funcion para el metodo de plegamiento en una Tabla Hash
    public int aPlegamiento(int z){
         //El metodo Integer.toString() sirve para convertir un entero a String
         String palabra=Integer.toString(z);
         //El metodo x.Length() sirve para medir la longitud de un String y lo guarda como un numero entero
         int longitud=palabra.length(); 
         //El metodo x:substring(desde, hasta) sirve para separar un String, se divide entre dos para separar a la mitad
         String primeraParte= palabra.substring(0, longitud/2);
         String segundaParte= palabra.substring(longitud/2, longitud);
         //El metodo Integer.parseInt(x) sirve para convertir un String a entero 
         int suma1= Integer.parseInt(primeraParte);
         int suma2= Integer.parseInt(segundaParte);
         int suma=suma1+suma2;
         //el while se utiliza por si la clave se pasa del tamaño de la tabla. Le resta el tamaño de la tabla hasta que la clave entre
         while (suma >= tamaño){  
         suma= suma-tamaño;
         }
         return Math.abs(suma);
     }
         public void insertPlegamiento(int x){
             T[aPlegamiento(x)]=x;
         }
         //Metodo de multiplicacion para la Tabla Hash
         public int aMultiplicacion(int a){
         double numero=a*Const;
         //El metodo Math.floor(x) sirve para redondear un número decimal hacia abajo al número entero más cercano
         double decimal= numero - Math.floor(numero); 
         //La funcion Math.log10(x)+1 calcula el logaritmo base 10 de "x", y luego se le suma 1 para obtener el número total de dígitos en base 10.
         int exponente=(int)Math.log10(tamaño)+1;
         int base=10;
         //La funcion Math.pow(base, exponente) devuelve un número elevado a una potencia determinada.
         int multiplicador= (int) Math.pow(base, exponente); 
         // se obtiene  el numero entero que se colocara en la tabla
         int entero = (int)(decimal*multiplicador);        
         while(tamaño <= entero){
         entero=entero-tamaño;
         } 
       return Math.abs(entero);
     }
     
      public void insertMultiplicacion(int x){
            T[aMultiplicacion(x)]=x;
             
      }
         
         
    
}
