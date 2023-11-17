/**
 * Clase que representa un nodo en un Árbol B.
 */
public class NodoB {
    int[] claves;       // Arreglo que almacena las claves del nodo
    int t;              // Orden del árbol (número mínimo de claves en un nodo)
    NodoB[] hijos;      // Arreglo de nodos hijos
    int n;              // Número actual de claves en el nodo
    boolean hoja;       // Indica si el nodo es una hoja o no

    /**
     * Constructor de la clase NodoB.
     * @param t El orden del árbol (número mínimo de claves en un nodo)
     * @param hoja Indica si el nodo es una hoja o no
     */
    public NodoB(int t, boolean hoja) {
        this.t = t;
        this.hoja = hoja;
        this.claves = new int[2 * t - 1]; // El tamaño del arreglo de claves es 2t-1
        this.hijos = new NodoB[2 * t];    // El tamaño del arreglo de hijos es 2t
        this.n = 0;                        // Inicialmente, el nodo no tiene claves
    }
}
