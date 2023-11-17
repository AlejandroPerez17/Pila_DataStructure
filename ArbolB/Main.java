import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Crear un árbol B con un orden de 3
        ArbolB arbolB = new ArbolB(3);

        // Insertar algunas llaves
        System.out.println("Cuantos datos quieres insertar?");
        int cantidadLlaves = leer.nextInt();

        for (int i = 0; i < cantidadLlaves; i++) {
            System.out.println("Ingrese los datos " + i + ":");
            int llave = leer.nextInt();
            arbolB.insertar(arbolB, llave);
        }

        // Imprimir el árbol después de las inserciones
        System.out.println("arbol B despues de inserciones:");
        arbolB.imprimir(arbolB.raiz);
        System.out.println();

        // Buscar un nodo específico
        System.out.println("Buscar nodo con dato:");
        int llaveBuscar = leer.nextInt();
        arbolB.imprimirNodoEspecifico(arbolB, llaveBuscar);
        System.out.println();

        // Eliminar una llave
        System.out.println("Arbol B antes de eliminar el Dato:");
        arbolB.imprimir(arbolB.raiz);
        System.out.println();
        System.out.println("Ingrese el dato que deseas eliminar:");
        int llaveEliminar = leer.nextInt();
        arbolB.eliminarLlave(arbolB, llaveEliminar);
        System.out.println("Arbol B despues de eliminar el dato:");
        arbolB.imprimir(arbolB.raiz);
        System.out.println();
        
        System.out.println("");
        
        
    }
}
