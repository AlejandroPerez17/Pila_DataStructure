public class NodoB {
    int orden; // orden del árbol
    int cantidad; // cantidad de datos en un nodo
    int datos[]; // array de datos
    NodoB hijos[]; // array de hijos
    boolean hoja; // booleano que indica si es hoja o no
    NodoB padre; // nodo padre

    public NodoB() {

    }

    public NodoB(int orden, NodoB padre) {
        this.orden = orden;
        this.padre = padre;
        datos = new int[2 * orden - 1];
        hijos = new NodoB[2 * orden];
        hoja = true;
        cantidad = 0;
    }

    public int getDato(int index) {
        return datos[index];
    }

    public NodoB getHijo(int index) {
        return hijos[index];
    }

    public void setDato(int index, int dato) {
        datos[index] = dato;
    }

    public void setHijo(int index, NodoB nodo) {
        hijos[index] = nodo;
    }

    public void setPadre(NodoB padre) {
        this.padre = padre;
    }

    public boolean esHoja() {
        return hoja;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getOrden() {
        return orden;
    }

    public NodoB getPadre() {
        return padre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setHoja(boolean hoja) {
        this.hoja = hoja;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}

/**
 * Clase NodoB que representa los nodos de un árbol B.
 * 
 * Campos:
 * - orden: Almacena el orden del árbol B.
 * - cantidad: Representa la cantidad de datos almacenados en el nodo.
 * - datos[]: Un array que guarda los datos del nodo.
 * - hijos[]: Un array que almacena los hijos del nodo.
 * - hoja: Un booleano que indica si el nodo es una hoja o no.
 * - padre: Referencia al nodo padre.
 * 
 * Constructores:
 * - public NodoB(): Constructor por defecto que no toma parámetros.
 * - public NodoB(int orden, NodoB padre): Constructor que recibe el orden y el nodo padre,
 *   inicializa los campos y crea los arrays de datos e hijos.
 * 
 * Métodos:
 * - public int getDato(int index): Devuelve el dato en la posición indicada por el índice.
 * - public NodoB getHijo(int index): Devuelve el hijo en la posición indicada por el índice.
 * - public void setDato(int index, int dato): Establece el dato en la posición indicada por el índice.
 * - public void setHijo(int index, NodoB nodo): Establece el hijo en la posición indicada por el índice.
 * - public void setPadre(NodoB padre): Establece el nodo padre.
 * - public boolean esHoja(): Verifica si el nodo es una hoja.
 * - public int getCantidad(): Devuelve la cantidad de datos en el nodo.
 * - public int getOrden(): Devuelve el orden del árbol.
 * - public NodoB getPadre(): Devuelve el nodo padre.
 * - public void setCantidad(int cantidad): Establece la cantidad de datos en el nodo.
 * - public void setHoja(boolean hoja): Establece si el nodo es una hoja o no.
 * - public void setOrden(int orden): Establece el orden del árbol.
 */
