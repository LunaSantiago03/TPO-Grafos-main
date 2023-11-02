package DFS;

public class DFS_Algoritmo {
    public void DFS(int origen, GrafoMA grafo, int[] marca, int[] p){
        marca[origen] = 1; // marca como gris

        ConjuntoTDA adyacentes = grafo.Adyacentes(origen);
        while (!adyacentes.ConjuntoVacio()) {
            int v = adyacentes.Elegir();
            adyacentes.Sacar(v);
            if (marca[v] == 0) {
                p[v] = origen;
                System.out.println("El predecesor de " + v + " es " + origen);
                DFS(v, grafo, marca, p);
            }
        }
        marca[origen] = 2; // marca como negro
    }
    public void DFS_FOREST(GrafoMA grafo) {
        int v = grafo.getCantNodos(); // Obtener el tamaño de la matriz de adyacencia
        int[] marca = new int[v];
        int[] p = new int[v];

        // Inicializar todos los vértices como no visitados
        for (int i = 0; i < v; i++) {
            marca[i] = 0;
        }

        // Iterar sobre todos los vértices
        for (int i = 0; i < v; i++) {
            if (marca[i] == 0) {
                DFS(i, grafo, marca, p);
            }
        }
    }
}
