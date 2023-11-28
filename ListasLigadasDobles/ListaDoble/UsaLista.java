import java.io.*;
import java.util.Scanner;

public class UsaLista{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args){
        ListaDoble lista = new ListaDoble();

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
        // Utilizar el método insertarDespuesDe
        System.out.println("Ingresa la clave del nodo a buscar");
        String clave2 = teclado.nextLine();
        String nuevoNombre = "NuevoNodo";

        // Insertar un nuevo nodo después del nodo con valor "B"
        lista.insertarDespuesDe(clave2, nuevoNombre);

        // Imprimir la lista después de la inserción
        System.out.println("Lista después de la inserción:");
        lista.imprimir();
        
        System.out.println("---------------------------------------------");
        System.out.println("Intercambiar un nodo por otro buscado.");
        System.out.println("---------------------------------------------");
        // Imprimir la lista antes de intercambiar nodos
        System.out.println("Lista antes de intercambiar nodos:");
        lista.imprimir();

        // Utilizar el método intercambiarNodos
        String nodo1 = "Nodo1";
        String nodo2 = "Nodo2";

        // Intercambiar el nodo con valor "B" por el nodo con valor "C"
        lista.intercambiarNodos(nodo1, nodo2);

        // Imprimir la lista después de intercambiar nodos
        System.out.println("Lista después de intercambiar nodos:");
        lista.imprimir();
    }
}