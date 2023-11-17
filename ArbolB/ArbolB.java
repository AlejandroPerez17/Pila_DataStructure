/** 
 * Clase ArbolB que representa un árbol B.
 * 
 * Campos:
 * - orden: Almacena el orden del árbol.
 * - raiz: Representa la raíz del árbol.
 * 
 * Constructores:
 * - public ArbolB(int orden): Constructor que recibe el orden del árbol
 *   e inicializa la raíz con un nuevo nodo.
 * 
 * Métodos:
 * - public NodoB buscar(NodoB raiz, int dato): Busca un dato en el árbol y muestra un mensaje
 *   indicando si se encontró o no.
 * - public void dividir(NodoB x, int i, NodoB y): Divide un nodo durante la inserción si está lleno.
 * - public void insercionNoLlena(NodoB x, int dato): Realiza la inserción de un dato en un nodo no lleno.
 * - public void insertar(ArbolB t, int dato): Inserta un dato en el árbol B.
 * - public void imprimir(NodoB n): Imprime los datos del árbol de manera ordenada.
 * - public void imprimirNodoEspecifico(ArbolB T, int x): Imprime un nodo específico del árbol.
 * - public void eliminarLlave(ArbolB t, int llave): Elimina un dato del árbol B si existe.
 */


public class ArbolB {
    
    int orden; // orden del árbol
    NodoB raiz; // raíz del árbol

    public ArbolB(int orden) {
        this.orden = orden;
        raiz = new NodoB(orden, null);
    }

   public NodoB buscar(NodoB raiz, int dato) {
    int i = 0; // índice de búsqueda

    while (i < raiz.getCantidad() && dato > raiz.getDato(i)) {
        i++;
    }
    
    if (i <= raiz.getCantidad() && dato == raiz.getDato(i)) {
        System.out.println("Se encontro el dato " + dato + " en el arbol B.");
        return raiz;
    }
    
    if (raiz.esHoja()) {
        System.out.println("No se encontro el dato " + dato + " en el arbol B.");
        return null;
    } else {
        return buscar(raiz.getHijo(i), dato);
    }
}

  public void dividir(NodoB x, int i, NodoB y) {
    NodoB z = new NodoB(orden, null);

    z.setHoja(y.esHoja());
    z.setCantidad(orden - 1);

    for (int j = 0; j < orden - 1; j++) {
        z.setDato(j, y.getDato(j + orden));
    }
    if (!y.esHoja()) {
        for (int k = 0; k < orden; k++) {
            z.setHijo(k, y.getHijo(k + orden));
        }
    }

    // Inicializar los arrays del nuevo nodo (z)
    z.datos[orden - 1] = 0;
    z.hijos[orden] = null;

    y.setCantidad(orden - 1);

    for (int j = x.getCantidad(); j > i; j--) {
        x.setHijo(j + 1, x.getHijo(j));
    }
    x.setHijo(i + 1, z);

    for (int j = x.getCantidad(); j > i; j--) {
        x.setDato(j + 1, x.getDato(j));
    }
    x.setDato(i, y.getDato(orden - 1));

    y.setDato(orden - 1, 0);

    for (int j = 0; j < orden - 1; j++) {
        y.setDato(j + orden, 0);
    }
    x.setCantidad(x.getCantidad() + 1);
}
   
   public void insercionNoLlena(NodoB x, int dato) {
    int i = x.getCantidad();

    if (x.esHoja()) {
        while (i >= 1 && dato < x.getDato(i - 1)) {
            x.setDato(i, x.getDato(i - 1));
            i--;
        }

        x.setDato(i, dato);
        x.setCantidad(x.getCantidad() + 1);
    } else {
        int j = 0;
        while (j < x.getCantidad() && dato > x.getDato(j)) {
            j++;
        }

        if (x.getHijo(j).getCantidad() == 2 * orden - 1) {
            dividir(x, j, x.getHijo(j));

            if (dato > x.getDato(j)) {
                j++;
            }
        }

        insercionNoLlena(x.getHijo(j), dato);
    }
}
    public void insertar(ArbolB t, int dato) {
        NodoB r = t.raiz;
        if (r.getCantidad() == 2 * orden - 1) {
            NodoB s = new NodoB(orden, null);
            t.raiz = s;
            s.setHoja(false);
            s.setCantidad(0);
            s.setHijo(0, r);
            dividir(s, 0, r);
            insercionNoLlena(s, dato);
        } else {
            insercionNoLlena(r, dato);
        }
    }

   public void imprimir(NodoB n) {
    for (int i = 0; i < n.getCantidad(); i++) {
        System.out.print(n.getDato(i) + " ");
    }

    if (!n.esHoja()) {
        for (int j = 0; j <= n.getCantidad(); j++) {
            if (n.getHijo(j) != null) {
                System.out.println();
                imprimir(n.getHijo(j));
                if (j < n.getCantidad()) {
                    System.out.print(n.getDato(j) + " ");
                }
            }
        }
    }
}

    public void imprimirNodoEspecifico(ArbolB T, int x) {
        NodoB temp = new NodoB(orden, null);

        temp = buscar(T.raiz, x);

        if (temp == null) {
            System.out.println("Dato no existente");
        } else {
            imprimir(temp);
        }
    }

     public void eliminarLlave(ArbolB t, int llave) { //este metodo sirve aqui pones su funcionamiento claro y resumido
        NodoB temp = new NodoB(orden, null);
        temp = buscar(t.raiz, llave);

        if (temp != null && temp.esHoja() && temp.getCantidad() > orden - 1) {
            int i = 0;

            while (llave > temp.getDato(i)) {
                i++;
            }
            for (int j = i; j < 2 * orden - 2; j++) {
                temp.setDato(j, temp.getDato(j + 1));
            }
            temp.setCantidad(temp.getCantidad() - 1);
        } else {
            System.out.println("No se puede eliminar el dato. ¡No existe!");
        }
    }
      }
