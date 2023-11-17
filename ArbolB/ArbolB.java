public class ArbolB {
    private NodoB raiz;
    private int t;

    // Constructor del Árbol B
    public ArbolB(int t) {
        this.raiz = new NodoB(t, true);
        this.t = t;
    }

    // Método para insertar una clave en el Árbol B
    public void insertar(int clave) {
        // Si la raíz está llena, se crea una nueva raíz y se realiza la división
        if (raiz.n == 2 * t - 1) {
            NodoB nuevaRaiz = new NodoB(t, false);
            nuevaRaiz.hijos[0] = raiz;
            dividirHijo(nuevaRaiz, 0);
            insertarNoLleno(nuevaRaiz, clave);
            raiz = nuevaRaiz;
        } else {
            // Si la raíz no está llena, se inserta directamente
            insertarNoLleno(raiz, clave);
        }
    }

    // Método auxiliar para la inserción cuando el nodo no está lleno
    private void insertarNoLleno(NodoB nodo, int clave) {
        int i = nodo.n - 1;

        // Si el nodo es una hoja, se inserta la clave en la posición adecuada
        if (nodo.hoja) {
            while (i >= 0 && clave < nodo.claves[i]) {
                nodo.claves[i + 1] = nodo.claves[i];
                i--;
            }
            nodo.claves[i + 1] = clave;
            nodo.n++;
        } else {
            // Si el nodo no es una hoja, se desciende al hijo adecuado
            while (i >= 0 && clave < nodo.claves[i]) {
                i--;
            }

            i++;
            // Si el hijo está lleno, se realiza la división antes de descender
            if (nodo.hijos[i] != null && nodo.hijos[i].n == 2 * t - 1) {
                dividirHijo(nodo, i);
                if (clave > nodo.claves[i]) {
                    i++;
                }
            }

            // Si el hijo no existe, se crea antes de descender
            if (nodo.hijos[i] == null) {
                nodo.hijos[i] = new NodoB(t, true);
            }

            insertarNoLleno(nodo.hijos[i], clave);
        }
    }

    // Método para buscar una clave en el Árbol B
    public void buscar(int clave) {
        if (buscarClave(raiz, clave)) {
            System.out.println("El nodo con la clave " + clave + " se encuentra en el Arbol-B.");
        } else {
            System.out.println("El nodo con la clave " + clave + " no se encuentra en el Arbol-B.");
        }
    }

    // Método auxiliar para la búsqueda de clave de manera recursiva
    private boolean buscarClave(NodoB nodo, int clave) {
        int i = 0;
        while (i < nodo.n && clave > nodo.claves[i]) {
            i++;
        }

        if (i < nodo.n && clave == nodo.claves[i]) {
            return true;
        }

        // Si es una hoja y no se encontró la clave, se retorna falso
        if (nodo.hoja) {
            return false;
        }

        // Se desciende al hijo correspondiente
        return buscarClave(nodo.hijos[i], clave);
    }

    // Método para eliminar una clave en el Árbol B
    public void eliminar(int clave) {
        eliminarClave(raiz, clave);

        // Si la raíz queda vacía después de la eliminación, se ajusta la raíz
        if (raiz.n == 0) {
            if (raiz.hoja) {
                raiz = null;
            } else {
                raiz = raiz.hijos[0];
            }
        }
    }

    // Método auxiliar para eliminar una clave de manera recursiva
    private void eliminarClave(NodoB nodo, int clave) {
        int i = 0;
        while (i < nodo.n && clave > nodo.claves[i]) {
            i++;
        }

        // Si el nodo es una hoja, se elimina la clave de la hoja
        if (nodo.hoja) {
            if (i < nodo.n && clave == nodo.claves[i]) {
                eliminarDeHoja(nodo, i);
            }
        } else {
            // Si el nodo no es una hoja, se elimina de un nodo no hoja
            if (i < nodo.n && clave == nodo.claves[i]) {
                eliminarDeNoHoja(nodo, i);
            } else {
                // Manejo de casos especiales y recursión para descender al hijo adecuado
                boolean flag = (i == nodo.n);

                if (nodo.hijos[i] != null && nodo.hijos[i].n < t) {
                    llenar(nodo, i);
                }

                if (flag && i > nodo.n) {
                    eliminarClave(nodo.hijos[i - 1], clave);
                } else {
                    eliminarClave(nodo.hijos[i], clave);
                }
            }
        }
    }

    // Método auxiliar para eliminar una clave de un nodo hoja
    private void eliminarDeHoja(NodoB nodo, int idx) {
        for (int i = idx + 1; i < nodo.n; ++i) {
            nodo.claves[i - 1] = nodo.claves[i];
        }
        nodo.n--;
    }

    // Método auxiliar para eliminar una clave de un nodo no hoja
    private void eliminarDeNoHoja(NodoB nodo, int idx) {
        int clave = nodo.claves[idx];

        // Se obtiene el predecesor o sucesor según sea necesario
        if (nodo.hijos[idx] != null && nodo.hijos[idx].n >= t) {
            int predecesor = obtenerPredecesor(nodo, idx);
            nodo.claves[idx] = predecesor;
            eliminarClave(nodo.hijos[idx], predecesor);
        } else if (nodo.hijos[idx + 1] != null && nodo.hijos[idx + 1].n >= t) {
            int sucesor = obtenerSucesor(nodo, idx);
            nodo.claves[idx] = sucesor;
            eliminarClave(nodo.hijos[idx + 1], sucesor);
        } else {
            // En caso de que no haya predecesor ni sucesor suficiente, se fusiona
            fusionar(nodo, idx);
            eliminarClave(nodo.hijos[idx], clave);
        }
    }

    // Método auxiliar para obtener el predecesor de una clave en un nodo
    private int obtenerPredecesor(NodoB nodo, int idx) {
        NodoB actual = nodo.hijos[idx];
        while (!actual.hoja) {
            actual = actual.hijos[actual.n];
        }
        return actual.claves[actual.n - 1];
    }

    // Método auxiliar para obtener el sucesor de una clave en un nodo
    private int obtenerSucesor(NodoB nodo, int idx) {
        NodoB actual = nodo.hijos[idx + 1];
        while (!actual.hoja) {
            actual = actual.hijos[0];
        }
        return actual.claves[0];
    }

 // Método auxiliar para llenar un nodo que tiene menos claves que el mínimo
private void llenar(NodoB nodo, int idx) {
    if (idx != 0 && nodo.hijos[idx - 1] != null && nodo.hijos[idx - 1].n >= t) {
        tomarDeAnterior(nodo, idx);
    } else if (idx != nodo.n && nodo.hijos[idx + 1] != null && nodo.hijos[idx + 1].n >= t) {
        tomarDeSiguiente(nodo, idx);
    } else {
        // En caso de que no se pueda tomar de los hermanos, se fusiona
        if (idx != nodo.n) {
            fusionar(nodo, idx);
        } else {
            fusionar(nodo, idx - 1);
        }
    }
}

    // Método auxiliar para tomar una clave del hermano anterior
    private void tomarDeAnterior(NodoB nodo, int idx) {
        NodoB hijo = nodo.hijos[idx];
        NodoB hermano = nodo.hijos[idx - 1];

        // Se desplazan las claves y los hijos en el nodo actual
        for (int i = hijo.n - 1; i >= 0; --i) {
            hijo.claves[i + 1] = hijo.claves[i];
        }

        if (!hijo.hoja) {
            for (int i = hijo.n; i >= 0; --i) {
                hijo.hijos[i + 1] = hijo.hijos[i];
            }
        }

        // Se toma la clave del padre y el último hijo del hermano
        hijo.claves[0] = nodo.claves[idx - 1];

        if (!hijo.hoja) {
            hijo.hijos[0] = hermano.hijos[hermano.n];
        }

        // Se actualiza la clave del padre con la última clave del hermano
        nodo.claves[idx - 1] = hermano.claves[hermano.n - 1];

        // Se ajustan las cuentas de claves y hijos en los nodos
        hijo.n++;
        hermano.n--;
    }

    // Método auxiliar para tomar una clave del hermano siguiente
    private void tomarDeSiguiente(NodoB nodo, int idx) {
        NodoB hijo = nodo.hijos[idx];
        NodoB hermano = nodo.hijos[idx + 1];

        // Se toma la clave del padre y el primer hijo del hermano
        hijo.claves[hijo.n] = nodo.claves[idx];

        if (!hijo.hoja) {
            hijo.hijos[hijo.n + 1] = hermano.hijos[0];
        }

        // Se actualiza la clave del padre con la primera clave del hermano
        nodo.claves[idx] = hermano.claves[0];

        // Se desplazan las claves y los hijos en el hermano
        for (int i = 1; i < hermano.n; ++i) {
            hermano.claves[i - 1] = hermano.claves[i];
        }

        if (!hermano.hoja) {
            for (int i = 1; i <= hermano.n; ++i) {
                hermano.hijos[i - 1] = hermano.hijos[i];
            }
        }

        // Se ajustan las cuentas de claves y hijos en los nodos
        hijo.n++;
        hermano.n--;
    }

    // Método auxiliar para fusionar un nodo con su hermano
    private void fusionar(NodoB nodo, int idx) {
        NodoB hijo = nodo.hijos[idx];
        NodoB hermano = nodo.hijos[idx + 1];

        // Se traslada la clave del padre al hijo
        hijo.claves[t - 1] = nodo.claves[idx];

        // Se copian las claves y los hijos del hermano al hijo
        for (int i = 0; i < hermano.n; ++i) {
            hijo.claves[i + t] = hermano.claves[i];
        }

        if (!hijo.hoja) {
            for (int i = 0; i <= hermano.n; ++i) {
                hijo.hijos[i + t] = hermano.hijos[i];
            }
        }

        // Se desplazan las claves y los hijos en el nodo
        for (int i = idx + 1; i < nodo.n; ++i) {
            nodo.claves[i - 1] = nodo.claves[i];
        }

        for (int i = idx + 2; i <= nodo.n; ++i) {
            nodo.hijos[i - 1] = nodo.hijos[i];
        }

        // Se ajustan las cuentas de claves y hijos en los nodos
        hijo.n += hermano.n + 1;
        nodo.n--;
    }

  // Método privado que divide un hijo de un nodo en caso de que esté lleno
private void dividirHijo(NodoB padre, int idx) {
    // Crear un nuevo hijo que será la mitad derecha del hijo original
    NodoB nuevoHijo = new NodoB(t, raiz.hoja);
    NodoB hijo = padre.hijos[idx]; // Hijo que se va a dividir

    padre.n++; // Incrementar el número de claves en el padre

    // Desplazar los punteros de los hijos en el padre
    for (int i = padre.n - 1; i > idx; i--) {
        padre.hijos[i] = padre.hijos[i - 1];
    }

    // Insertar el nuevo hijo en el lugar correcto
    padre.hijos[idx + 1] = nuevoHijo;

    // Copiar la mitad derecha de las claves del hijo original al nuevo hijo
    for (int i = 0; i < hijo.n - t; i++) {
        nuevoHijo.claves[i] = hijo.claves[i + t];
    }

    nuevoHijo.n = hijo.n - t; // Actualizar el número de claves en el nuevo hijo
    hijo.n = t; // Actualizar el número de claves en el hijo original

    // Mover los punteros de los hijos del hijo original al nuevo hijo
    for (int i = t; i < hijo.n; i++) {
        nuevoHijo.hijos[i - t] = hijo.hijos[i];
        hijo.hijos[i] = null; // Establecer los hijos que se han trasladado a null
    }
    
    // Vincular el último hijo de nuevoHijo correctamente
    nuevoHijo.hijos[nuevoHijo.n] = hijo.hijos[hijo.n];
    // Establecer el último hijo que se ha trasladado a null
    hijo.hijos[hijo.n] = null;
}
    
 // Método estático privado que imprime el contenido del árbol recursivamente
private static void imprimirArbol(NodoB nodo, int nivel) {
    if (nodo != null) {
        // Imprimir las claves del nodo en el nivel actual
        System.out.print("Nivel " + nivel + ": ");
        for (int i = 0; i < nodo.n; i++) {
            if (nodo.claves[i] != 0) {
                System.out.print(nodo.claves[i] + " ");
            }
        }
        System.out.println();

        // Llamar recursivamente a imprimirArbol para los hijos del nodo
        if (!nodo.hoja) {
            for (int i = 0; i <= nodo.n; i++) {
                imprimirArbol(nodo.hijos[i], nivel + 1);
            }
        }
    }
}

// Método público que inicia la impresión del árbol desde la raíz
public void imprimirArbol() {
    imprimirArbol(raiz, 0);
}
}

