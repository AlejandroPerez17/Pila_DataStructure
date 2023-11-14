public class Main {
    public static void main(String[] args) {
        // Crear un árbol no binario de tipo String
        Arbol<String> arbol = new Arbol<>("A", false);
        
        // CREACION DE NUESTROS NODOS no binario
        NodoArbol<String> nodoB = new NodoArbol<>("B");
        NodoArbol<String> nodoC = new NodoArbol<>("C");
        NodoArbol<String> nodoD = new NodoArbol<>("D");
        NodoArbol<String> nodoE = new NodoArbol<>("E");
        NodoArbol<String> nodoF = new NodoArbol<>("F");
        NodoArbol<String> nodoG = new NodoArbol<>("G");
        NodoArbol<String> nodoH = new NodoArbol<>("H");
        NodoArbol<String> nodoI = new NodoArbol<>("I");
        NodoArbol<String> nodoJ = new NodoArbol<>("J");
        NodoArbol<String> nodoK = new NodoArbol<>("K");
        NodoArbol<String> nodoL = new NodoArbol<>("L");
        NodoArbol<String> nodoM = new NodoArbol<>("M");
        NodoArbol<String> nodoN = new NodoArbol<>("N");
        NodoArbol<String> nodoO = new NodoArbol<>("O");
        NodoArbol<String> nodoP = new NodoArbol<>("P");
        NodoArbol<String> nodoQ = new NodoArbol<>("Q");

       //INICIALIZAMOS LOS 3 NODOS HIJOS DE NUESTRA RAIZ PRINICIPAL A
       arbol.agregarNodoArbol(arbol.obtenerRaiz(), nodoB);
       arbol.agregarNodoArbol(arbol.obtenerRaiz(), nodoC);
       arbol.agregarNodoArbol(arbol.obtenerRaiz(), nodoD);
        
        //AGREGAMOS LOS SUBHIJOS DE NUESTRO NODOB QUE ES AHORA NUESTRA RAIZ EL(NODO B)
        arbol.agregarNodoArbol(nodoB, nodoE);
        arbol.agregarNodoArbol(nodoB, nodoF);
        
        //AGREGAMOS LOS SUBHIJOS DE NUESTRO NODOF QUE ES AHORA NUESTRA RAIZ EL (NODO F)
        arbol.agregarNodoArbol(nodoF, nodoJ);
        arbol.agregarNodoArbol(nodoF, nodoK);
        arbol.agregarNodoArbol(nodoF, nodoL);
        
        //AGREGAMOS LOS SUBHIJOS DE NUESTRO NODOD QUE ES AHORA NUESTRA RAIZ EL (NODO D)
        arbol.agregarNodoArbol(nodoD, nodoG);
        arbol.agregarNodoArbol(nodoD, nodoH);
        arbol.agregarNodoArbol(nodoD, nodoI);
        
        //AGREGAMOS LOS SUBHIJOS DE NUESTRO NODOG QUE ES AHORA NUESTRA RAIZ EL (NODO G)
        arbol.agregarNodoArbol(nodoG, nodoM);
        
        //AGREGAMOS LOS SUBHIJOS DE NUESTRO NODOM QUE ES AHORA NUESTRA RAIZ EL (NODO M)
        arbol.agregarNodoArbol(nodoM, nodoP);
        arbol.agregarNodoArbol(nodoM, nodoQ);
        
        //AGREGAMOS LOS SUBHIJOS DE NUESTRO NODOI QUE ES AHORA NUESTRA RAIZ EL (NODO I)
        arbol.agregarNodoArbol(nodoI, nodoN);
        arbol.agregarNodoArbol(nodoI, nodoO);
        

     
        
    // Imprimir el árbol en diferentes recorridos
    
        System.out.println("\n ARBOL NO BINARIO");
        System.out.println("Recorrido Prefijo: ");
        arbol.imprimirArbol(Recorrido.PREFIJO);
  
        System.out.println("\nRecorrido Infijo: ");
        arbol.imprimirArbol(Recorrido.INFIJO);
        
        System.out.println("\nRecorrido Posfijo: ");
        arbol.imprimirArbol(Recorrido.POSFIJO);
                
        
        
        
        System.out.println("\n------------------------------------------------------");
        System.out.println("\n");
        
        System.out.println("ARBOL BINARIO");
          // CREACION DE NUESTROS NODOS no binario       
        Arbol<String> arbolbi = new Arbol<>("A", true);
        
        
        NodoArbol<String> nodoBbin = new NodoArbol<>("B");
        NodoArbol<String> nodoCbin = new NodoArbol<>("C");
        NodoArbol<String> nodoDbin = new NodoArbol<>("D");
        NodoArbol<String> nodoEbin = new NodoArbol<>("E");
        NodoArbol<String> nodoFbin = new NodoArbol<>("F");
        NodoArbol<String> nodoGbin = new NodoArbol<>("G");
        NodoArbol<String> nodoHbin = new NodoArbol<>("H");
        NodoArbol<String> nodoIbin = new NodoArbol<>("I");
        NodoArbol<String> nodoJbin = new NodoArbol<>("J");
        NodoArbol<String> nodoKbin = new NodoArbol<>("K");
        NodoArbol<String> nodoLbin = new NodoArbol<>("L");
        NodoArbol<String> nodoMbin = new NodoArbol<>("M");
        NodoArbol<String> nodoNbin = new NodoArbol<>("N");
        NodoArbol<String> nodoObin = new NodoArbol<>("O");
        NodoArbol<String> nodoPbin = new NodoArbol<>("P");
        NodoArbol<String> nodoQbin = new NodoArbol<>("Q");
    
       arbolbi.agregarNodoArbol(arbolbi.obtenerRaiz(), nodoBbin);
       
         arbolbi.agregarNodoArbol(nodoBbin, nodoEbin);
        arbolbi.agregarNodoArbol(nodoBbin, nodoCbin);

        arbolbi.agregarNodoArbol(nodoEbin, nodoFbin);
        arbolbi.agregarNodoArbol(nodoFbin, nodoJbin);
        arbolbi.agregarNodoArbol(nodoJbin, nodoKbin);
        arbolbi.agregarNodoArbol(nodoKbin, nodoLbin);

        arbolbi.agregarNodoArbol(nodoCbin, nodoDbin);
        arbolbi.agregarNodoArbol(nodoDbin, nodoGbin);
        
        arbolbi.agregarNodoArbol(nodoGbin, nodoMbin);
        arbolbi.agregarNodoArbol(nodoGbin, nodoHbin);
        
        arbolbi.agregarNodoArbol(nodoMbin, nodoPbin);
        arbolbi.agregarNodoArbol(nodoPbin, nodoQbin);
        
        arbolbi.agregarNodoArbol(nodoHbin, nodoIbin);
        arbolbi.agregarNodoArbol(nodoIbin, nodoNbin);
        arbolbi.agregarNodoArbol(nodoNbin, nodoObin);

          // Imprimir el árbol en diferentes recorridos
        System.out.println("\nRecorrido Prefijo: ");
        arbolbi.imprimirArbol(Recorrido.PREFIJO);
  
        System.out.println("\nRecorrido Infijo: ");
        arbolbi.imprimirArbol(Recorrido.INFIJO);
        
        System.out.println("\nRecorrido Posfijo: ");
        arbolbi.imprimirArbol(Recorrido.POSFIJO);      
                
        
        System.out.println("\nEl arbol binario esta vacio: " + arbolbi.estaVacio());

        // Obtener la altura del árbol binario
        System.out.println("Altura del arbol binario: " + arbolbi.alturaArbol());

        
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        // Imprimir subárbol a partir del nodo 'B'
        arbolbi.imprimirSubArbol(nodoBbin);
        
       
    }
}
