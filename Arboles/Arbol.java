//Nuestra clase Arbol generico
public class Arbol<T> {

  // Definición de variables
  private NodoArbol<T> raiz;
  private boolean esBinario = false;

  /**
   * Constructor de la clase Arbol.
   * dato : El dato que se asignará a la raíz del árbol.
   * esBinario : Indica si el árbol es binario o no.
   */
  public Arbol(T dato, boolean esBinario) {
    raiz = new NodoArbol<T>(dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  /**
   * Obtiene la raíz del árbol.
   * y retorna La raíz del árbol.
   */
  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  /**
   * Verifica si el árbol es binario.
   * returne true si es binario y false de lo contrario
   */
  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Agrega un nodo al árbol.
   * nodoRaiz: El nodo al que se le agregará el nuevo nodo.
   *NodoAgregado: El nuevo nodo que se agregará al árbol.
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * Imprime el árbol según el tipo de recorrido especificado.
   * recorrido: El tipo de recorrido (Prefijo siendo 0, Infijo siendo 1, Posfijo siendo 2) que se realizará en el árbol.
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;

      default:
        break;
    }
  }
}

