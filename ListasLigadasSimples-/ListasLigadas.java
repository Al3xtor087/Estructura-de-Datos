/**
 * Pérez Talavera Alejandro de Jesús
 * Clase donde se econtrarán los métodos para manejar las listas simplemente enlazadas
 */
public class ListasLigadas
{
    Node top; // Se crea el nodo cabeza
    
    // Método para insertar el primero nodo
    public boolean insertarPrimerNodo (String dato){
        if (top == null){ // Si la lista es igual a nula, es decir, si esta vacía
            top = new Node(); // Se crea un nuevo nodo cabeza
            top.name = dato; // Se le asigna el valor al nodo
            top.next = null; // El enlace se declara nulo
            
            return true; // Devuelve true si la lista no está vacía y se ha creado el primero nodo
        }
        else{
            return false; // Devuelve false porque la lista no estaba vacía
        }
    }
    
    // Método para insertar un nodo al principio de la lista
    public void insertaAntesPrimerNodo (String nombre){
        Node temp; // Se crea un nodo temporal
        temp = new Node(); // Se crea un objeto nodo 
        temp.name = nombre; // Se le asigna el valor al nodo temporal
        temp.next = this.top; // El enlace del nodo temporal apunta al nodo cabeza
        this.top = temp; // Se le asigna el valor de la cabeza al nodo temporal
        temp = null; // El nodo temporal se vuelve nulo
        
    }
    
    // Método para crear un nodo e insertarlo al final de la lista
    public void insertaAlFinal (String nombre){
        Node temp = new Node(); // Se crea un objeto nodo temporal
        temp.name = nombre; // Se le asigna el valor al nodo temporal
        temp.next = null; // Se vuelve nulo el enlace del nodo temporal
        
        Node temp2 = this.top; // Se crea un segundo nodo temporal y se le asigna el valor de la cabez
        
        while (temp2.next != null){
            temp2 = temp2.next; // Se recorre la lista hasta llegar al último nodo
        }
        
        temp2.next = temp; // Enlaza el nodo temporal creado al último nodo de la lista
        
        temp = null; // Se vuelve nulo el nodo temporal
        temp2 = null; // Se vuelve nulo el nodo temporal 2
    }
    
    // Método para insertar un nodo entre dos nodos
    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp =new Node(); // Se crea un objeto nodo temporal
        temp.name = nombre; // Se le asigna valor al nodo temporal
        Node temp2 = this.top; // Se crea un nodo temporal dos y se le asigna el valor de la cabeza
        
        while ((temp2 != null) && temp2.name.equals(buscado) == false){ // Mientras la lista es nula y el valor buscado sea diferente
            temp2 = temp2.next; // Se recorrerá la lista hasta encontrar el nodo deseado
        }
        
        // If para insertar el nodo después del nodo deseado
        if (temp2 != null){
            temp.next = temp2.next; // El siguiente nodo del nodo temporal será el siguiente nodo del nodo deseado
            temp2.next = temp; // El siguiente nodo despues del nodo encontrado se vuelve el nuevo nodo
            
            temp = null; // Se vuelve nulo el nodo temporal
            temp2 = null; // Se vuelve nulo el nodo temporal2
            
            return true; // Devuelve true si el nodo fue insertado correctamente
        }
        else{
            return false; // Devuelve false si el nodo no fue encontrado
        }
    }
    
    // Método para imprimir todos los nodos de la lista
    public void imprimir(){
        for (Node temp = this.top; temp != null; temp = temp.next){ // Se recorrerá toda la lista con el ciclo for
            System.out.print("[ " + temp.name + " ] -> "); // Se mostrará por la consola el valor
        }
                
        System.out.print("[ X ]\n"); // Terminando de imprimir toda la lista, se mostrará el final representado con una X
    }
    
    // Método para convertir en cadena la lista
    public String toString(){
        String cadAux = ""; // Declara e inicializa una variable tipo cadena vacía
        
        for (Node temp = this.top; temp != null; temp = temp.next){ // Recorre la lista entera
            cadAux += "[ " + temp.name + " ] -> "; // Añade el valor de cada nodo
        }
        
        cadAux += "[ X ]\n"; // Representa el final de la lista con una X
        
        return cadAux; // Devuelve el valor de cadAux
    }
    
    // Método para borrar el primer nodo
    public void borrarPrimerNodo(){
        this.top = this.top.next; // El siguiente nodo se asigna como el nodo cabeza, desechando automáticamente el anterior
    }
    
    // Método para borrar cualquier nodo
    public boolean borrarCualquierNodo(String nombre){
        Node temp = this.top; // Se crea un nodo temporal y se le asigna el valor de la cabeza
        
        while ((temp != null) && temp.name.equals(nombre) == false){ // Se recorrerá la lista hasta que el nodo deseado sea encontrado
            temp = temp.next; 
        }
        // If para verificar si el nodo ha sido encontrado
        if (temp != null){
            temp.next = temp.next.next; // El siguiente nodo de temp será el siguiente nodo del siguiente nodo
            temp = null; // El nodo temporal se vuelve nulo
            
            return true; // Devuelve true si el nodo ha sido encontrado y se ha eliminado
        }
        else{
            return false; // Devuelve false si el nodo no fue encontrado
        }
    }
    
    // Método para buscar un nodo por el valor de su campo clave y devolver una referencia
    public Node buscarPorValor(String valor) {
        Node temp = this.top; // Se crea un nodo temporal y se le asigna el valor de la cabeza
        while (temp != null && !temp.name.equals(valor)) { // Se recorre la lista hasta encontrar el nodo deseado
            temp = temp.next;  
        }
        return temp; // Devuelve la referencia
    }
    
    // Método para buscar un nodo por su campo clave e insertar un nuevo nodo después de él
    public boolean insertarDespuesDe(String buscado, String nuevoNombre) {
        Node temp = this.top; // Se crea un nodo temporal y se le asigna el valor de la cabeza

        temp = this.buscarPorValor(buscado); // Se busca el valor utilizando el método buscarPorValor

        if (temp != null) {  // Nodo buscado se encontró
            Node nuevoNodo = new Node(); // Se crea un nuevo objeto nodo
            nuevoNodo.name = nuevoNombre; // Se le da el valor al nodo
            nuevoNodo.next = temp.next; // El siguiente enlace del nuevoNodo es el siguiente enlace de temp
            temp.next = nuevoNodo; // El siguiente enlace de temp es el nuevoNodo
            return true;
        } else {
            return false;
        }
    }
    
    // Intercambiar un nodo por otro buscado
    public boolean intercambiarNodos(String nodo1, String nodo2) {
        Node temp1 = null, temp2 = null, prev1 = null, prev2 = null;
        Node temp = this.top;

        // Buscar los nodos y sus nodos previos
        while (temp != null) {
            if (temp.name.equals(nodo1)) {
                temp1 = temp;
                break;
            }
            prev1 = temp;
            temp = temp.next;
        }

        temp = this.top;

        while (temp != null) {
            if (temp.name.equals(nodo2)) {
                temp2 = temp;
                break;
            }
            prev2 = temp;
            temp = temp.next;
        }

        // Verificar si ambos nodos fueron encontrados
        if (temp1 != null && temp2 != null) {
            // Actualizar los punteros de los nodos previos
            if (prev1 != null) {
                prev1.next = temp2;
            } else {
                this.top = temp2;
            }

            if (prev2 != null) {
                prev2.next = temp1;
            } else {
                this.top = temp1;
            }

            // Intercambiar los punteros de los nodos
            Node tempNext = temp1.next;
            temp1.next = temp2.next;
            temp2.next = tempNext;

            return true;
        } else {
            return false; // Al menos uno de los nodos no fue encontrado
        }
    }
}

