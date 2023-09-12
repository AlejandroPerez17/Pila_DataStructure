package Pila

/**
 *
 * @author Alee
 */
public class Nodo {
    private int dato;
    private Nodo siguiente;
    
    private Nodo() {
        this.dato = 0; 
        this.siguiente = null;
    }
    
    private Nodo(int dato){
        this.dato = dato;
        this.siguiente = null;       
    }
    
    public int getDato() {
        return dato;
    }

  
    public void setDato(int dato) {
        this.dato = dato;
    }

    
    public Nodo getSiguiente() {
        return siguiente;
    }

    
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    
    
    
}
