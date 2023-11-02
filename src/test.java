import java.util.ArrayList;
import java.util.List;

public class test {

    static class Grafo {
        int vertices;
        List<List<Arista>> listaAdyacencia;

        class Arista {
            int origen;
            int destino;
            int peso;

            public Arista(int origen, int destino, int peso) {
                this.origen = origen;
                this.destino = destino;
                this.peso = peso;
            }
        }

        public Grafo(int vertices) {
            this.vertices = vertices;
            listaAdyacencia = new ArrayList<>(vertices);

            for (int i = 0; i < vertices; i++) {
                listaAdyacencia.add(new ArrayList<>());
            }
        }

        public void agregarArista(int origen, int destino, int peso) {
            listaAdyacencia.get(origen).add(new Arista(origen, destino, peso));
            listaAdyacencia.get(destino).add(new Arista(destino, origen, peso));
        }

        public void arbolRecubrimientoMinimo() {
            boolean[] visitado = new boolean[vertices];
            Arista[] resultado = new Arista[vertices];
            int[] pesos = new int[vertices];

            for (int i = 0; i < vertices; i++) {
                resultado[i] = new Arista(-1, -1, Integer.MAX_VALUE);
                pesos[i] = Integer.MAX_VALUE;
            }

            pesos[0] = 0;
            resultado[0] = new Arista(0, 0, 0);

            for (int i = 0; i < vertices - 1; i++) {
                int verticeMinimo = encontrarVerticeMinimo(visitado, pesos);
                visitado[verticeMinimo] = true;

                for (Arista arista : listaAdyacencia.get(verticeMinimo)) {
                    int destino = arista.destino;
                    int peso = arista.peso;

                    if (!visitado[destino] && peso < pesos[destino]) {
                        resultado[destino] = new Arista(verticeMinimo, destino, peso);
                        pesos[destino] = peso;
                    }
                }
            }
            imprimirArbolRecubrimiento(resultado);
        }

        public int encontrarVerticeMinimo(boolean[] visitado, int[] pesos) {
            int minPeso = Integer.MAX_VALUE;
            int verticeMinimo = -1;

            for (int i = 0; i < vertices; i++) {
                if (!visitado[i] && pesos[i] < minPeso) {
                    minPeso = pesos[i];
                    verticeMinimo = i;
                }
            }
            return verticeMinimo;
        }

        public void imprimirArbolRecubrimiento(Arista[] resultado) {
            int costoTotal = 0;
            System.out.println("Árbol de Recubrimiento Mínimo:");
            for (int i = 1; i < vertices; i++) {
                if (resultado[i].origen != -1 && resultado[i].destino != -1) {
                    System.out.println("Nodo Padre: " + resultado[i].origen + " - Nodo Hijo: " + resultado[i].destino + " Peso: " + resultado[i].peso);
                    costoTotal += resultado[i].peso;
                }
            }
            System.out.println("Costo total mínimo = " + costoTotal);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Grafo grafo = new Grafo(vertices);
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 25);
        grafo.agregarArista(1, 4, 30);
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(2, 5, 5);
        grafo.agregarArista(2, 3, 20);
        grafo.agregarArista(3, 5, 40);
        grafo.agregarArista(5, 4, 12);
        grafo.arbolRecubrimientoMinimo();
    }
}