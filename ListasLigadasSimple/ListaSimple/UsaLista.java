import java.io.*;
import java.util.Scanner;

public class UsaLista{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args){
        ListaSimple lista = new ListaSimple();

        lista.insertaPrimerNodo("Nodo2");
        lista.insertaAntesPrimerNodo("Nodo1");
        lista.insertaAlFinal("Nodo3");
        lista.insertaEntreNodos("Nodo4", "Nodo5");
        lista.imprimir();
        
        System.out.println("---------------------------------------------");
        System.out.println("Buscar un nodo por el valor de su campo clave y devolver una referencia.");
        System.out.println("---------------------------------------------");
        // Usar el método buscarPorValor
        System.out.println("Ingresa la clave del nodo a buscar");
        String clave = teclado.nextLine();
        String valorBuscado = clave;
        Node nodoEncontrado = lista.buscarPorValor(valorBuscado);

        // Verificar si el nodo fue encontrado
        if (clave != null) {
            System.out.println("Nodo encontrado: " + nodoEncontrado.name);
        } else {
            System.out.println("Nodo no encontrado.");
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("Buscar un nodo por su campo clave e insertar un nuevo nodo después de él.");
        System.out.println("---------------------------------------------");
        // Usar el método insertarDespuesDe
        System.out.println("Ingresa la clave del nodo a buscar");
        String clave2 = teclado.nextLine();
        String nuevoNombre = "NuevoNodo";
        boolean exito = lista.insertarDespuesDe(clave2, nuevoNombre);

        // Verificar si la inserción fue exitosa
        if (exito) {
            System.out.println("Inserción después de " + clave2 + " exitosa.");
        } else {
            System.out.println("No se encontró el nodo " + clave2 + ".");
        }

        // Imprimir la lista después de la inserción
        System.out.println("Lista después de la inserción:");
        lista.imprimir();
        
        System.out.println("---------------------------------------------");
        System.out.println("Intercambiar un nodo por otro buscado.");
        System.out.println("---------------------------------------------");
        // Usar el método intercambiarNodos
        String nodo1 = "Nodo1";
        String nodo2 = "Nodo2";
        boolean exito2 = lista.intercambiarNodos(nodo1, nodo2);

        // Verificar si el intercambio fue exitoso
        if (exito) {
            System.out.println("Intercambio entre " + nodo1 + " y " + nodo2 + " exitoso.");
        } else {
            System.out.println("Al menos uno de los nodos no fue encontrado.");
        }

        // Imprimir la lista después del intercambio
        System.out.println("Lista después del intercambio:");
        lista.imprimir();
    }
    
    


}