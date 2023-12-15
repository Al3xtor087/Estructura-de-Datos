/**
 * Pérez Talavera Alejandro de Jesús
 * Clase donde se econtrarán los métodos para manejar las listas simplemente enlazadas
 */
public class ListaDoble
{
    Node topForward; // Se crea el nodo cabeza
    Node topBackward;
    
    // Método para insertar el primero nodo
    public boolean insertarPrimerNodo (String dato){
        if (topForward == null){ // Si la lista es igual a nula, es decir, si esta vacía
            topForward = new Node(); // Se crea un nuevo nodo cabeza
            topForward.name = dato; // Se le asigna el valor al nodo
            topForward.previous = null; // El enlace anterior se declara nulo
            topForward.next = null; // El enlace siguiente se declara nulo
            
            topBackward = topForward;
            
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
        temp.next = this.topForward; // El enlace del nodo temporal apunta al nodo cabeza
        this.topForward.previous = temp; // El enlace siguiente toma el valor de temp
        this.topForward = temp; // Se le asigna el valor de la cabeza al nodo temporal
        temp = null; // El nodo temporal se vuelve nulo
        
    }
    
    // Método para crear un nodo e insertarlo al final de la lista
    public void insertaAlFinal (String nombre){
        Node temp = new Node(); // Se crea un objeto nodo temporal
        temp.name = nombre; // Se le asigna el valor al nodo temporal
        temp.next = null; // Se vuelve nulo el enlace del nodo temporal
        
        temp.previous = this.topBackward; // El anterior enlace del nodo temporal apunta al último nodo de la lista
        
        this.topBackward.next = temp; // El nodo temp se convierte en el siguiente nodo despues del topBackward
        this.topBackward = temp; // El nodo anterior ya no es el último nodo
        temp = null; // temp se vuelve nulo
    }
    
    // Método para insertar un nodo entre dos nodos
    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node(); // Se crea un objeto nodo temporal
        temp.name = nombre; // Se le asigna valor al nodo temporal
        Node temp2 = this.topForward; // Se crea un nodo temporal dos y se le asigna el valor de la cabeza
        
        while ((temp2 != null) && temp2.name.equals(buscado) == false){ // Mientras la lista es nula y el valor buscado sea diferente
            temp2 = temp2.next; // Se recorrerá la lista hasta encontrar el nodo deseado
        }
        
        // If para insertar el nodo después del nodo deseado
        if (temp2 != null){
            temp.next = temp2.next; // El siguiente nodo del nodo temporal será el siguiente nodo del nodo deseado
            temp2.next = temp; // El siguiente nodo despues del nodo encontrado se vuelve el nuevo nodo
            
            temp.previous = temp2;
            temp.next.previous = temp;
            
            temp = null;
            temp2 = null;
            
            return true; // Devuelve true si el nodo fue insertado correctamente
        }
        else{
            return false; // Devuelve false si el nodo no fue encontrado
        }
    }
    
    // Método para imprimir todos los nodos de la lista
    public void imprimir(){
        System.out.print("[ X ]");
        
        for (Node temp = this.topForward; temp != null; temp = temp.next){ // Se recorrerá toda la lista con el ciclo for
            System.out.print(" <- [ " + temp.name + " ] -> "); // Se mostrará por la consola el valor
        }
                
        System.out.print("[ X ]\n"); // Terminando de imprimir toda la lista, se mostrará el final representado con una X
    }
    
    // Método para convertir en cadena la lista
    public String toString(){
        String cadAux = ""; // Declara e inicializa una variable tipo cadena vacía
        
        for (Node temp = this.topForward; temp != null; temp = temp.next){ // Recorre la lista entera
            cadAux += " <- [ " + temp.name + " ] -> "; // Añade el valor de cada nodo
        }
        
        cadAux += "[ X ]\n"; // Representa el final de la lista con una X
        
        return cadAux; // Devuelve el valor de cadAux
    }
    
    // Método para borrar el primer nodo
    public void borrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }
    
    // Método para borrar cualquier nodo
    public boolean borrarCualquierNodo(String nombre){
        Node temp = this.topForward; // Se crea un nodo temporal y se le asigna el valor de la cabeza
        
        while ((temp != null) && temp.name.equals(nombre) == false){ // Se recorrerá la lista hasta que el nodo deseado sea encontrado
            temp = temp.next; 
        }
        // If para verificar si el nodo ha sido encontrado
        if (temp != null){
            temp.next = temp.next.next; // El siguiente nodo de temp será el siguiente nodo del siguiente nodo
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null; // El nodo temporal se vuelve nulo
            
            return true; // Devuelve true si el nodo ha sido encontrado y se ha eliminado
        }
        else{
            return false; // Devuelve false si el nodo no fue encontrado
        }
    }
    
    // Método para buscar un nodo por el valor de su campo clave y devolver una referencia
    public Node buscarPorValor(String valor) {
        Node temp = this.topForward; // Se crea un nodo temporal y se le asigna el valor de la cabeza
        while (temp != null && !temp.name.equals(valor)) { // Se recorre la lista hasta encontrar el nodo deseado
            temp = temp.next;  
        }
        return temp; // Devuelve la referencia
    }
    
    // Método para buscar un nodo por su campo clave e insertar un nuevo nodo después de él
    public boolean insertarDespuesDe(String buscado, String nuevoNombre) {
        Node temp = buscarPorValor(buscado);

        if (temp != null) {
            // Comprobar si el nodo buscado es el último de la lista
            if (temp.next == null) {
                // Usar el método insertaAlFinal
                insertaAlFinal(nuevoNombre);
            } else {
                // Usar el método insertarDespuesDe
                Node nuevoNodo = new Node();
                nuevoNodo.name = nuevoNombre;
                nuevoNodo.next = temp.next;
                temp.next = nuevoNodo;

                nuevoNodo.previous = temp;
                nuevoNodo.next.previous = nuevoNodo;
            }
            return true;
        }
        return false; // No se encontró el nodo
    }
    
    // Intercambiar un nodo por otro buscado
    public boolean intercambiarNodos(String nombre, String buscado) {
        Node nodo1 = buscarPorValor(nombre);
        Node nodo2 = buscarPorValor(buscado);

        // Buscar los nodos y sus nodos previos
        if (nodo1 != null && nodo2 != null) {
            String temp = nodo1.name;
            nodo1.name = nodo2.name;
            nodo2.name = temp;
            return true;
        }
        return false; // No se encontraron los nodos
    }
}


