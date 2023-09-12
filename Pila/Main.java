package Pila;

/**
 *
 * @author Alee
 */
public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        
        pila.insertar(14); //FONDO
        pila.insertar(27);
        pila.insertar(1);
        pila.insertar(15);
        pila.insertar(10);
        pila.insertar(90);
        pila.insertar(71);
        pila.insertar(37);
        pila.insertar(2);
        pila.insertar(48); // CIMA

      
        System.out.println("Tamaño de la Pila: " + pila.obtenerTamaño());

    
        for (int i = 0; i < 4; i++) {
            pila.quitar();
        }

        System.out.println("Elemento en la Cima: " + pila.obtenerCima());

        
        pila.vaciar();

    
        System.out.println("La Pila está vacía: " + pila.estaVacia());
    }
}
