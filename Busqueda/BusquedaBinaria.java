
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Alee
 */

public class BusquedaBinaria {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int TotalDeNumeros = 1000;
        int[] arreglo = new int[TotalDeNumeros];
        Random random = new Random();
        Set<Integer> numerosGenerados = new HashSet<>(); 

        for (int i = 0; i < TotalDeNumeros; i++) {
            int numeroAleatorio;
            do {
                numeroAleatorio = random.nextInt(1001);
            } while (numerosGenerados.contains(numeroAleatorio)); 

            numerosGenerados.add(numeroAleatorio);
            arreglo[i] = numeroAleatorio;
        }

        System.out.println("Numeros Desordenados:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }

        bubbleSort(arreglo);

        System.out.println("\nNumeros ordenados:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println("");
        System.out.println("La cantidad de numeros que hay son de: " + TotalDeNumeros);
        System.out.println("");

        System.out.println("Que numero deseas buscar ?");
        int numeroBuscar = leer.nextInt();

        int resultado = busquedaBinaria(arreglo, numeroBuscar);

        if (resultado != -1) {
            System.out.println("El numero: " + numeroBuscar  +"   se encontro con exito , se encuentra en la posicion " + resultado);
        } else {
            System.out.println("El numero " + numeroBuscar + " no se encuentra en el arreglo.");
        }
    }

    public static void bubbleSort(int[] arr) {
        int tamanoArreglo = arr.length;
        for (int i = 0; i < tamanoArreglo - 1; i++) {
            for (int j = 0; j < tamanoArreglo - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int auxiliar = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = auxiliar;
                }
            }
        }
    }

    public static int busquedaBinaria(int[] arregl, int numeroBuscar) {
        int inicio = 0;
        int fin = arregl.length - 1;

        while (inicio <= fin) {
            int centro = inicio + (fin - inicio) / 2;

            if (arregl[centro] == numeroBuscar) {
                return centro;
            }

            if (arregl[centro] < numeroBuscar) {
                inicio = centro + 1;
            } else {
                fin = centro - 1;
            }
        }

        return -1;
    }
}
