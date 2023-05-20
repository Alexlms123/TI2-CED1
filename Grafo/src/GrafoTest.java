import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GrafoTest {

    @Test
    public void testBfsConGrafoVacio() {
        Grafo<Integer> grafo = new GrafoListaAdyacencia<>();
        Vertice<Integer> origen = new Vertice<>(1);
        assertEquals(0, grafo.bfs(origen).size());
    }

    @Test
    public void testBfsConGrafoNoConexo() {
        Grafo<Integer> grafo = new GrafoListaAdyacencia<>();
        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);

        grafo.agregarArista(v1, v2);
        grafo.agregarArista(v3, v4);

        Vertice<Integer> origen = new Vertice<>(5);
        assertEquals(0, grafo.bfs(origen).size());
    }

    @Test
    public void testBfsConexo() {
        // Crear grafo conexo
        GrafoListaAdyacencia<Integer> grafo = new GrafoListaAdyacencia<>();
        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarArista(v1, v2);
        grafo.agregarArista(v2, v3);
        grafo.agregarArista(v3, v4);

        // Verificar que el grafo es conexo usando bfs
        List<Integer> resultado = grafo.bfs(v1);
        assertEquals(4, resultado.size());
    }

    @Test
    public void testDfsConVerticeNoExistenteDeberiaRetornarListaVacia() {
        // Arrange
        Grafo<Integer> grafo = new GrafoListaAdyacencia<>();
        Vertice<Integer> v1 = new Vertice<>(1);
        grafo.agregarVertice(v1);
        Vertice<Integer> v2 = new Vertice<>(2);
        grafo.agregarVertice(v2);
        grafo.agregarArista(v1, v2);

        // Act
        List<Integer> resultado = grafo.dfs(new Vertice<>(3));

        // Assert
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testDfsConGrafoNoConexoDeberiaRetornarRecorridoDelSubgrafoConectadoAlOrigen() {
        // Arrange
        Grafo<Integer> grafo = new GrafoListaAdyacencia<>();
        Vertice<Integer> v1 = new Vertice<>(1);
        grafo.agregarVertice(v1);
        Vertice<Integer> v2 = new Vertice<>(2);
        grafo.agregarVertice(v2);
        Vertice<Integer> v3 = new Vertice<>(3);
        grafo.agregarVertice(v3);
        Vertice<Integer> v4 = new Vertice<>(4);
        grafo.agregarVertice(v4);
        grafo.agregarArista(v1, v2);
        grafo.agregarArista(v2, v1);
        grafo.agregarArista(v3, v4);
        grafo.agregarArista(v4, v3);

        // Act
        List<Integer> resultado = grafo.dfs(v1);

        // Assert
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(1));
        assertTrue(resultado.contains(2));
    }

    @Test
    public void testDfsConGrafoCiclicoDeberiaRetornarRecorridoCompletoDelGrafo() {
        // Arrange
        Grafo<Integer> grafo = new GrafoListaAdyacencia<>();
        Vertice<Integer> v1 = new Vertice<>(1);
        grafo.agregarVertice(v1);
        Vertice<Integer> v2 = new Vertice<>(2);
        grafo.agregarVertice(v2);
        Vertice<Integer> v3 = new Vertice<>(3);
        grafo.agregarVertice(v3);
        grafo.agregarArista(v1, v2);
        grafo.agregarArista(v2, v3);
        grafo.agregarArista(v3, v1);

        // Act
        List<Integer> resultado = grafo.dfs(v1);

        // Assert
        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(1));
        assertTrue(resultado.contains(2));
        assertTrue(resultado.contains(3));
    }

}

