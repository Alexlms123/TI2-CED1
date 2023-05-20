import java.util.List;
import java.util.Set;

public interface Grafo<T>{

    void agregarVertice(Vertice<T> v);
    void agregarArista(Vertice<T> origen, Vertice<T> destino);
    List<Vertice<T>> obtenerVertices();
    Vertice<T> buscarVertice(Vertice<T> vertice);
    List<T> bfs(Vertice<T> origen);
    List<T> dfs(Vertice<T> origen);
}
