public class Main {
    public static void main(String[] args) {
        // Crear un árbol no binario de tipo String
        Arbol<String> arbol = new Arbol<>("A", false);

        // CREACION DE NUESTROS NODOS 
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
        System.out.println("Recorrido Prefijo: ");
        arbol.imprimirArbol(Recorrido.PREFIJO);
  
        System.out.println("\nRecorrido Infijo: ");
        arbol.imprimirArbol(Recorrido.INFIJO);
        
        System.out.println("\nRecorrido Posfijo: ");
        arbol.imprimirArbol(Recorrido.POSFIJO);
        
       
    }
}

