import apis.ConjuntoTDA;
import apis.GrafoTDA;
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
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        // Agregar aristas
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 4, 1);
        grafo.agregarArista(2, 5, 1);
        grafo.agregarArista(4, 2, 1);
        grafo.agregarArista(5, 4, 1);
        grafo.agregarArista(3, 5, 1);
        grafo.agregarArista(3, 6, 1);
        grafo.agregarArista(6, 6, 1);


        DFS_Algoritmo dfs = new DFS_Algoritmo();

        dfs.DFS_FOREST(grafo);

    }
}
