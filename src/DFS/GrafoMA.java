package DFS;

public class GrafoMA implements GrafoTDA {
    static int n = 100;
    int[][] MAdy;
    int[] Etiqs;
    int cantNodos;

    public void InicializarGrafo() {
        MAdy = new int [n][n];
        Etiqs = new int[n];
        cantNodos = 0;

    }

    public int getCantNodos(){
        return MAdy.length;
    }

    public void AgregarVertice(int v) {
        Etiqs[cantNodos] = v;
        for(int i = 0; i <= cantNodos; i++){
            MAdy[cantNodos][i] = 0;
            MAdy[i][cantNodos] = 0;
        }
        cantNodos++;

    }
    private int Vert2Indice(int v){
        int i = cantNodos -1;
        while(i >= 0 && Etiqs[i] != v){
            i--;
        }
        return i;
    }


    public void EliminarVertice(int v) {
        int ind = Vert2Indice(v);
        for(int i = 0; i < cantNodos; i++)
            MAdy[i][ind] = MAdy[i][cantNodos-1];
        for(int i = 0; i < cantNodos; i++)
            MAdy[ind][i] = MAdy[cantNodos-1][i];
        Etiqs[ind] = Etiqs[cantNodos - 1];
        cantNodos--;
    }

    public void AgregarArista(int v1, int v2, int p){
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = p;

    }

    public void EliminarArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = 0;
    }


    public int PesoArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d];
    }


    public ConjuntoTDA Vertices() {
        ConjuntoTDA Vert = new ConjuntoLD();
        Vert.InicializarConjunto();
        for(int i = 0; i < cantNodos; i++){
            Vert.Agregar(Etiqs[i]);
        }
        return Vert;
    }


    public boolean ExisteArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return (MAdy[o][d] != 0);
    }

    public ConjuntoTDA Adyacentes(int v){
        ConjuntoTDA adyacentes = new ConjuntoLD();
        adyacentes.InicializarConjunto();
        for(int i = 0;i < cantNodos; i++){
            if(MAdy[v][i]!=0){
                adyacentes.Agregar(Etiqs[i]);
            }
        }
        return adyacentes;
    }

    /*
    //5) Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes
    public int mayorCostoAristaSaliente(int v1){
        int a = 0;
        int ind = Vert2Indice(v1);
        for(int i = 0; i < cantNodos; i++){
            int v2 = Etiqs[i];
            if(ExisteArista(v1,v2)){
                if(a < PesoArista(v1,v2)){
                    a = PesoArista(v1,v2);
                }
            }
        }

        return a;
    }

    //6) Dado un Grafo G y un vértice v, escribir un método que permita obtener el conjunto de los
    //Predecesores del vértice v en G.
    //Se define que un vértice o es predecesor de otro vértice d, si hay una arista que comienza
    //en o y termina en d.

    public ConjuntoTDA Predecesores(int v1){
        ConjuntoTDA Vert = new ConjuntoLD();
        Vert.InicializarConjunto();
        int aux = Vert2Indice(v1);
        for(int i = 0; i < cantNodos; i++){
            if(MAdy[i][aux] > 0){ //i recorre las filas, aux es la posicion en la columna de v1
                Vert.Agregar(Etiqs[i]);
            }
        }
        return Vert;
    }

    //Version para probar, la de arriba es el conjunto.
    public ArrayList<Integer> Predecesoresp(int v1){
        ArrayList<Integer> auxx = new ArrayList<>();
        int aux = Vert2Indice(v1);
        for(int i = 0; i < cantNodos; i++){
            if(MAdy[i][aux] > 0){
                auxx.add(Etiqs[i]);
            }
        }
        return auxx;
    }

    //7) Dado un Grafo G escribir un método que permita obtener el conjunto de los vértices aislados en G.
    //Se define que un vértice v es aislado si v no tiene aristas entrantes ni salientes.*/


}
