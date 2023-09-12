package Pila;

/**
 *
 * @author Alee
 */
public class Pila<T> {
    
    private Object[] elementos; 
    private int tamaño;
    private static final int CAPACIDAD_INICIAL = 10;

    public Pila() {
        elementos = new Object[CAPACIDAD_INICIAL];
        tamaño = 0;
    }

   
    public void insertar(T elemento) {
        if (tamaño == elementos.length) {
            redimensionar(elementos.length * 2);
        }
        elementos[tamaño++] = elemento;
    }

    
    public T quitar() {
        if (estaVacia()) {
           
        }
        T elemento = obtenerCima();
        elementos[--tamaño] = null; // Liberar la referencia
        if (tamaño > 0 && tamaño == elementos.length / 4) {
            // Reducir la capacidad si la pila está menos del 25% llena
            redimensionar(elementos.length / 2);
        }
        return elemento;
    }

    
    public boolean estaVacia() {
        return tamaño == 0;
    }

   
    public void vaciar() {
        for (int i = 0; i < tamaño; i++) {
            elementos[i] = null; 
        }
        tamaño = 0;
    }

    
    public T obtenerCima() {
        if (estaVacia()) {
        }
        return (T) elementos[tamaño - 1];
    }

   
    public int obtenerTamaño() {
        return tamaño;
    }

    
    private void redimensionar(int capacidad) {
        Object[] nuevoArreglo = new Object[capacidad];
        for (int i = 0; i < tamaño; i++) {
            nuevoArreglo[i] = elementos[i];
        }
        elementos = nuevoArreglo;
    }
}
    
    
