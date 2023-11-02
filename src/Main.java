import GrafoNoDirigido.GrafoND;
import apis.ConjuntoTDA;
import impl.ConjuntoTA;

public class Main {



    public static void main(String[] args) {

        Prim prim = new Prim();

        GrafoND grafo = new GrafoND();
        grafo.inicializarGrafo();
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);



        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 25);
        grafo.agregarArista(1, 4, 30);
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(2, 5, 5);
        grafo.agregarArista(2, 3, 20);
        grafo.agregarArista(3, 5, 40);
        grafo.agregarArista(5, 4, 12);

        ConjuntoTDA conjunto = new ConjuntoTA();

        conjunto.inicializarConjunto();

        conjunto = grafo.vertices();



        while(!conjunto.conjuntoVacio()){
            int c = conjunto.elegir();
            conjunto.sacar(c);
            System.out.println(c);
        }







        prim.prim(grafo);





    }
}