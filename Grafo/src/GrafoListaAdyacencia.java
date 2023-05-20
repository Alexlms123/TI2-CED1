import java.util.*;

public class GrafoListaAdyacencia<T> implements Grafo<T> {
    private ArrayList<Vertice<T>> vertices;

    public GrafoListaAdyacencia() {
        vertices = new ArrayList<Vertice<T>>();
    }

    public ArrayList<Vertice<T>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public void agregarVertice(Vertice<T> v) {
        vertices.add(v);
    }

    public void agregarArista(Vertice<T> origen, Vertice<T> destino) {
        Vertice<T> v1 = buscarVertice(origen);
        Vertice<T> v2 = buscarVertice(destino);

        if (v1 != null && v2 != null) {
            v1.agregarAdyacente(v2);
            v2.agregarAdyacente(v1);
        }
    }

    public List<Vertice<T>> obtenerVertices() {
        return vertices;
    }

    public Vertice<T> buscarVertice(Vertice<T> vertice) {
        int indice = vertices.indexOf(vertice);
        if (indice != -1) {
            return vertices.get(indice);
        } else {
            return null;
        }
    }

    public List<T> bfs(Vertice<T> origen) {
        List<T> resultado = new ArrayList<>();
        Queue<Vertice<T>> cola = new LinkedList<>();
        Set<Vertice<T>> visitados = new HashSet<>();

        Vertice<T> v = buscarVertice(origen);

        if (v == null) {
            return resultado;
        }

        cola.offer(v);
        visitados.add(v);

        while (!cola.isEmpty()) {
            v = cola.poll();
            resultado.add(v.getId());

            for(int i = 0; i < v.getAdyacentes().size(); i++) {
                Vertice<T> ady = v.getAdyacentes().get(i);
                if (!visitados.contains(ady)) {
                    cola.offer(ady);
                    visitados.add(ady);
                }
            }
        }

        return resultado;
    }

    public List<T> dfs(Vertice<T> origen) {
        List<T> resultado = new ArrayList<>();
        Set<Vertice<T>> visitados = new HashSet<>();

        Vertice<T> v = buscarVertice(origen);

        if (v == null) {
            return resultado;
        }

        dfsRecursivo(v, visitados, resultado);

        return resultado;
    }

    private void dfsRecursivo(Vertice<T> v, Set<Vertice<T>> visitados, List<T> resultado) {
        visitados.add(v);
        resultado.add(v.getId());

        for (int i = 0; i < v.getAdyacentes().size(); i++) {
            Vertice<T> ady = v.getAdyacentes().get(i);
            if (!visitados.contains(ady)) {
                dfsRecursivo(ady, visitados, resultado);
            }
        }
    }
}

