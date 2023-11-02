package DFS;

public class MainTestDFS {
    public static void main(String[] args) {
        GrafoMA grafo = new GrafoMA();
        grafo.InicializarGrafo();


        // Agregar vértices
        grafo.AgregarVertice(0);
        grafo.AgregarVertice(1);
        grafo.AgregarVertice(2);
        grafo.AgregarVertice(3);
        grafo.AgregarVertice(4);
        grafo.AgregarVertice(5);
        grafo.AgregarVertice(6);

        // Agregar aristas
        grafo.AgregarArista(1, 2, 1);
        grafo.AgregarArista(1, 4, 1);
        grafo.AgregarArista(2, 5, 1);
        grafo.AgregarArista(4, 2, 1);
        grafo.AgregarArista(5, 4, 1);
        grafo.AgregarArista(3, 5, 1);
        grafo.AgregarArista(3, 6, 1);
        grafo.AgregarArista(6, 6, 1);


        DFS_Algoritmo dfs = new DFS_Algoritmo();

        dfs.DFS_FOREST(grafo);

    }

}
