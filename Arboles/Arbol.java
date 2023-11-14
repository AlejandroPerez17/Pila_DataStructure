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
    // Se crea un nuevo nodo para la raíz con el dato proporcionado
    raiz = new NodoArbol<T>(dato);
    // Se establece si el árbol es binario o no
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  /**
   * Obtiene la raíz del árbol.
   * @return La raíz del árbol.
   */
  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  /**
   * Verifica si el árbol es binario.
   * @return true si es binario y false de lo contrario.
   */
  public boolean esBinario() {
    return esBinario;
  }
  
  /**
   * Imprime el subárbol a partir de un nodo dado.
   * @param nodo El nodo desde el cual se imprimirá el subárbol.
   */
  public void imprimirSubArbol(NodoArbol<T> nodo) {
    if (nodo != null) {
        System.out.println("\nImprimiendo Subarbol de " + nodo.getDato() + ":");
        System.out.println("Recorrido Prefijo: ");
        nodo.imprimirEnPrefijo();
        System.out.println("\nRecorrido Infijo: ");
        nodo.imprimirEnInfijo();
        System.out.println("\nRecorrido Posfijo: ");
        nodo.imprimirEnPosfijo();
    } else {
        System.out.println("El nodo proporcionado es nulo.");
    }
  }
  
  /**
   * Verifica si el árbol está vacío.
   * @return true si el árbol está vacío y false de lo contrario.
   */
  public boolean estaVacio() {
    return raiz == null;
  }
  
  /**
   * Obtiene la altura del árbol.
   * @return La altura del árbol.
   */
 public int alturaArbol() {

    return calcularAltura(raiz);

  }

  /**
   * Método para calcular la altura del árbol desde un nodo dado
   *
   * @param nodo El nodo a partir del cual se calculará la altura
   * @return La altura del árbol a partir del nodo dado
   */
  private int calcularAltura(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      int alturaMaxima = 0;
      while (hijo != null) {
        int alturaHijo = calcularAltura(hijo);
        alturaMaxima = Math.max(alturaMaxima, alturaHijo);
        hijo = hijo.obtenerSiguienteHermano();
      }
      return alturaMaxima + 1;
    }

  }

  /**
   * Agrega un nodo al árbol.
   * @param nodoRaiz El nodo al que se le agregará el nuevo nodo.
   * @param nodoAgregado El nuevo nodo que se agregará al árbol.
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * Imprime el árbol según el tipo de recorrido especificado.
   * @param recorrido El tipo de recorrido (Prefijo siendo 0, Infijo siendo 1, Posfijo siendo 2) que se realizará en el árbol.
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
