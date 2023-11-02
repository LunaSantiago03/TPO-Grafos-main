package GrafoNoDirigido;

import apis.ConjuntoTDA;
import impl.GrafoMA;

public class testDFS {
    public static void main(String[] args) {
        GrafoMA grafo = new GrafoMA();
        grafo.inicializarGrafo();


        // Agregar vértices
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        // Agregar aristas
        grafo.agregarArista(0, 1, 1);
        grafo.agregarArista(0, 2, 5);
        grafo.agregarArista(1, 2, 3);
        grafo.agregarArista(2, 0, 6);
        grafo.agregarArista(2, 3, 7);
        grafo.agregarArista(3, 3, 2);


        // Mostrar vértices adyacentes
        System.out.println("Vértices adyacentes al vértice 0:");


    }
}
