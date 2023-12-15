/**
 * Pérez Talavera Alejandro de Jesús
 * Clase main
 */
public class Main{

    public static void main(String[] args){
        ListaDoble lista = new ListaDoble();

        lista.insertarPrimerNodo("3");
        lista.insertaAntesPrimerNodo("1");
        lista.insertaAlFinal("4");
        lista.insertaEntreNodos("2","1");
        lista.imprimir();
        
        System.out.println("Método buscarPorValor");
        Node nodoEncontrado = lista.buscarPorValor("3");
        // Verificar si el nodo fue encontrado
        if (nodoEncontrado != null) {
            System.out.println("Nodo encontrado: " + nodoEncontrado.name);
        } else {
            System.out.println("Nodo no encontrado.");
        }
        System.out.println("Método insertarDespuesDe");
        lista.insertarDespuesDe("3", "5");
        System.out.print(lista);
        
        System.out.println("Método intercambiarNodos");
        lista.intercambiarNodos("1", "2");
        System.out.print(lista);    
    }

}
