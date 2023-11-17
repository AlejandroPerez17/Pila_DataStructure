public class Main {
    public static void main(String[] args) {
        ArbolB Arbolitobb = new ArbolB(3); // t = orden 3 del árbol 

        // Insertar valores en el árbol
        Arbolitobb.insertar(6);
        Arbolitobb.insertar(20);
        Arbolitobb.insertar(5);
        Arbolitobb.insertar(6);
        Arbolitobb.insertar(12);
        Arbolitobb.insertar(105);
        Arbolitobb.insertar(290);
        Arbolitobb.insertar(57);
        Arbolitobb.insertar(61);
        Arbolitobb.insertar(123);
         Arbolitobb.insertar(15);
        Arbolitobb.insertar(22);
        Arbolitobb.insertar(50);
        Arbolitobb.insertar(64);
        Arbolitobb.insertar(1200);

        // Buscar un nodo en el árbol
        Arbolitobb.buscar(57);

        // Eliminar un nodo del árbol
        Arbolitobb.eliminar(1200);

        // Imprimir el árbol para verificar su estado
        Arbolitobb.imprimirArbol();

        
      
        
    }
}
