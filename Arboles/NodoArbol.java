
/**
 * Clase de un nodo en un árbol genérico.
 *
 * @param <T> Tipo de dato que almacena el nodo.
 */
public class NodoArbol<T> {
    private T dato; // Dato almacenado en el nodo.
    private boolean esBinario = false; // Indica si el nodo es parte de un árbol binario.
    private NodoArbol<T> primerHijo; // Primer hijo del nodo.
    private NodoArbol<T> siguienteHermano; // Siguiente hermano del nodo.

    /**
     * Constructor de la clase. Inicializa el nodo con el dato proporcionado.
     *
     * @param dato Dato a almacenar en el nodo.
     */
    public NodoArbol(T dato) {
        this.dato = dato;
        primerHijo = null;
        siguienteHermano = null;
    }

    /**
     * Agraga hijo a nodo, Si el nodo ya tiene un hijo, agrega el nuevo hijo
     * como siguiente hermano, a menos que sea un árbol binario, en cuyo caso emite
     * un mensaje de error.
     *
     * @param hijo Nuevo nodo que se agrega como hijo.
     */
    public void agregarHijo(NodoArbol<T> hijo) {
        if (primerHijo == null) {
            primerHijo = hijo;
        } else {
            NodoArbol<T> hermano = this.primerHijo;

            if (esBinario) {
                if (hermano.siguienteHermano != null) {
                    System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
                } else {
                    hermano.siguienteHermano = hijo;
                }
            } else {
                while (hermano.siguienteHermano != null) {
                    hermano = hermano.siguienteHermano;
                }
                hermano.siguienteHermano = hijo;
            }
        }
    }

    /**
     * Obtiene el primer hijo del nodo.
     *
     * @returna Primer hijo del nodo.
     */
    public NodoArbol<T> obtenerPrimerHijo() {
        return primerHijo;
    }

    /**
     * Obtiene el siguiente hermano del nodo.
     *
     * @return Siguiente hermano del nodo.
     */
    public NodoArbol<T> obtenerSiguienteHermano() {
        return siguienteHermano;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return Dato almacenado en el nodo.
     */
    public T getDato() {
        return dato;
    }

    /**
     * Verifica si el nodo es parte de un árbol binario.
     *
     * @return true si el nodo es parte de un árbol binario, false de lo contrario.
     */
    public boolean esBinario() {
        return esBinario;
    }

    /**
     * Establece si el nodo es parte de un árbol binario o no.
     *
     * @param esBinario true si el nodo es parte de un árbol binario, false de lo contrario.
     */
    public void setEsBinario(boolean esBinario) {
        this.esBinario = esBinario;
    }

    /**
     * Imprime el subárbol del nodo en recorrido de prefijo.
     */
    public void imprimirEnPrefijo() {
        System.out.print(dato + "\t");
        NodoArbol<T> hijo = primerHijo;

        while (hijo != null) {
            hijo.imprimirEnPrefijo();
            hijo = hijo.siguienteHermano;
        }
    }

    /**
     * Imprime el subárbol del nodo en recorrido infijo.
     */
    public void imprimirEnInfijo() {
        NodoArbol<T> hijo = primerHijo;

        if (hijo != null) {
            hijo.imprimirEnInfijo();
        }

        System.out.print(dato + "\t");
        while (hijo != null) {
            hijo = hijo.siguienteHermano;
            if (hijo != null) {
                hijo.imprimirEnInfijo();
            }
        }
    }

    /**
     * Imprime el subárbol del nodo en recorrido posfijo.
     */
    public void imprimirEnPosfijo() {
        NodoArbol<T> hijo = primerHijo;

        while (hijo != null) {
            hijo.imprimirEnPosfijo();
            hijo = hijo.siguienteHermano;
        }

        System.out.print(dato + "\t");
    }
}

