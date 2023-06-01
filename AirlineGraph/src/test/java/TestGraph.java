import com.example.airlinegraph.graph.IGraph;
import com.example.airlinegraph.graph.ListAdjacencyGraph;
import com.example.airlinegraph.graph.Edge;
import com.example.airlinegraph.graph.MatrixAdjacencyGraph;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestGraph {

    private IGraph<String> graph;

    public void setUpStage1() {

        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("a");

        graph.addEdge("a", "b", 10);
        graph.addEdge("a", "c", 5);
        graph.addEdge("b", "d", 1);
        graph.addEdge("c", "b", 3);
        graph.addEdge("c", "e", 2);
        graph.addEdge("c", "d", 9);
        graph.addEdge("e", "d", 6);
        graph.addEdge("e", "a", 2);

    }

    public void setUpStage2() {

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("z");

        graph.addEdge("a", "b", 4);
        graph.addEdge("a", "c", 2);
        graph.addEdge("b", "c", 1);
        graph.addEdge("d", "b", 5);
        graph.addEdge("c", "d", 8);
        graph.addEdge("c", "e", 10);
        graph.addEdge("d", "e", 2);
        graph.addEdge("d", "z", 6);
        graph.addEdge("e", "z", 3);

    }

    public void setUpStage3() {

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("S");
        graph.addVertex("T");

        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "E", 1);
        graph.addEdge("C", "D", 3);
        graph.addEdge("D", "E", 1);
        graph.addEdge("D", "T", 3);
        graph.addEdge("D", "F", 5);
        graph.addEdge("C", "E", 1);
        graph.addEdge("E", "G", 2);
        graph.addEdge("G", "E", 2);
        graph.addEdge("E", "T", 4);
        graph.addEdge("G", "T", 3);
        graph.addEdge("T", "F", 5);
        graph.addEdge("S", "A", 4);
        graph.addEdge("S", "D", 7);
        graph.addEdge("S", "B", 3);
        graph.addEdge("B", "S", 3);
        graph.addEdge("B", "D", 4);

    }

    public void setUpStage4() {

        graph.addVertex("francisco");
        graph.addVertex("new york");
        graph.addVertex("atlanta");
        graph.addVertex("denver");
        graph.addVertex("chicago");

        graph.addEdge("francisco", "new york", 2000);
        graph.addEdge("francisco", "chicago", 1200);
        graph.addEdge("chicago", "new york", 1000);
        graph.addEdge("francisco", "denver", 900);
        graph.addEdge("chicago", "denver", 1300);
        graph.addEdge("francisco", "atlanta", 2200);
        graph.addEdge("new york", "atlanta", 800);
        graph.addEdge("denver", "new york", 1600);
        graph.addEdge("chicago", "atlanta", 700);
        graph.addEdge("denver", "atlanta", 1400);

    }

    public void setUpStage5() {

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");

        graph.addEdge("a", "b", 1);
        graph.addEdge("c", "a", 4);
        graph.addEdge("c", "d", 1);
        graph.addEdge("d", "b", 3);
        graph.addEdge("a", "e", 2);
        graph.addEdge("e", "d", 2);
        graph.addEdge("c", "e", 3);
        graph.addEdge("b", "e", 3);

    }

    public void setUpStage6() {

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");
        graph.addVertex("g");
        graph.addVertex("h");
        graph.addVertex("i");
        graph.addVertex("j");
        graph.addVertex("k");
        graph.addVertex("l");

        graph.addEdge("a", "b", 2);
        graph.addEdge("b", "c", 3);
        graph.addEdge("c", "d", 1);
        graph.addEdge("d", "h", 5);
        graph.addEdge("h", "l", 3);
        graph.addEdge("l", "k", 1);
        graph.addEdge("k", "j", 3);
        graph.addEdge("i", "j", 3);
        graph.addEdge("i", "e", 4);
        graph.addEdge("e", "a", 3);
        graph.addEdge("e", "f", 4);
        graph.addEdge("f", "g", 3);
        graph.addEdge("g", "h", 3);
        graph.addEdge("b", "f", 1);
        graph.addEdge("f", "j", 2);
        graph.addEdge("c", "g", 2);
        graph.addEdge("g", "k", 4);

    }

    public void setUpStage7() {

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");

        graph.addEdge("a", "b", 1);

    }

    @Test
    public void testBFS1() {

        String source = "a";

        graph = new ListAdjacencyGraph<>(false);
        setUpStage2();
        assertTrue(graph.BFS(source));

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage2();
        assertTrue(graph.BFS(source));

    }

    @Test
    public void testBFS2() {

        String source = "denver";

        graph = new ListAdjacencyGraph<>(false);
        setUpStage4();
        assertTrue(graph.BFS(source));

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage4();
        assertTrue(graph.BFS(source));

    }

    @Test
    public void testBFS3() {

        String source = "a";

        graph = new ListAdjacencyGraph<>(false);
        setUpStage7();
        assertFalse(graph.BFS(source));

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage7();
        assertFalse(graph.BFS(source));
    }

    @Test
    public void testDFS1() {

        int expected = 1;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage2();

        assertEquals(graph.DFS(), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage2();

        assertEquals(graph.DFS(), expected);

    }

    @Test
    public void testDFS2() {
        int expected = 1;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage4();

        assertEquals(graph.DFS(), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage4();

        assertEquals(graph.DFS(), expected);

    }

    @Test
    public void testDFS3() {

        int expected = 3;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage7();

        assertEquals(graph.DFS(), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage7();

        assertEquals(graph.DFS(), expected);

    }

    @Test
    public void testDijkstra1() {

        double distanceExpected = 9.0;
        String[] edgeExpected = new String[]{"a", "c", "b", "d"};
        Edge<String> edge;

        graph = new ListAdjacencyGraph<>(true);
        setUpStage1();

        edge = graph.dijkstra("a", "d");

        assertTrue(verifyPath(edge, edgeExpected, distanceExpected));

        graph = new MatrixAdjacencyGraph<>(true);
        setUpStage1();

        edge = graph.dijkstra("a", "d");

        assertTrue(verifyPath(edge, edgeExpected, distanceExpected));
    }

    @Test
    public void testDijkstra2() {

        double distanceExpected = 13.0;
        String[] edgeExpected = new String[]{"a", "c", "b", "d", "e", "z"};
        Edge<String> edge;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage2();

        edge = graph.dijkstra("a", "z");

        assertTrue(verifyPath(edge, edgeExpected, distanceExpected));

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage2();

        edge = graph.dijkstra("a", "z");

        assertTrue(verifyPath(edge, edgeExpected, distanceExpected));

    }

    @Test
    public void testDijkstra3() {

        double distanceExpected = 10.0;
        String[] edgeExpected = new String[]{"S", "A", "C", "E", "T"};
        Edge<String> edge;

        graph = new ListAdjacencyGraph<>(true);
        setUpStage3();

        edge = graph.dijkstra("S", "T");

        verifyPath(edge, edgeExpected, distanceExpected);

        graph = new MatrixAdjacencyGraph<>(true);
        setUpStage3();

        edge = graph.dijkstra("S", "T");

        verifyPath(edge, edgeExpected, distanceExpected);

    }

    @Test
    public void testFloydWarshall1() {

        double distanceExpected = 9.0;
        String [] edgeExpected = new String[]{"a", "c", "b", "d"};
        Edge<String> edge;

        Pair<String, String> route = new Pair<>("a", "d");

        graph = new ListAdjacencyGraph<>(true);
        setUpStage1();

        edge = graph.floydWarshall().get(route);

        verifyPath(edge, edgeExpected, distanceExpected);

        graph = new MatrixAdjacencyGraph<>(true);
        setUpStage1();

        edge =  graph.floydWarshall().get(route);

        verifyPath(edge, edgeExpected, distanceExpected);

    }

    @Test
    public void testFloydWarshall2() {

        double distanceExpected = 13.0;
        String[] edgeExpected = new String[]{"a", "c", "b", "d", "e", "z"};
        Edge<String> edge;

        Pair<String, String> route = new Pair<>("a", "z");

        graph = new ListAdjacencyGraph<>(false);
        setUpStage2();

        edge = graph.floydWarshall().get(route);

        assertTrue(verifyPath(edge, edgeExpected, distanceExpected));

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage2();

        edge = graph.floydWarshall().get(route);

        verifyPath(edge, edgeExpected, distanceExpected);

        assertTrue(verifyPath(edge, edgeExpected, distanceExpected));

    }

    @Test
    public void testFloydWarshall3() {

        double distanceExpected = 10.0;
        String[] pathExpected = new String[]{"S", "D", "T"};
        Edge<String> edge;

        Pair<String, String> route = new Pair<>("S", "T");

        graph = new ListAdjacencyGraph<>(true);
        setUpStage3();

        edge = graph.floydWarshall().get(route);

        assertTrue(verifyPath(edge, pathExpected, distanceExpected));

        graph = new MatrixAdjacencyGraph<>(true);
        setUpStage3();

        edge = graph.floydWarshall().get(route);

        assertTrue(verifyPath(edge, pathExpected, distanceExpected));
    }

    @Test
    public void testPrim1() {

        String source = "atlanta";
        double expected = 3600.0;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage4();

        assertEquals(graph.prim("atlanta"), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage4();

        assertEquals(graph.prim(source), expected);

    }

    @Test
    public void testPrim2() {

        String source = "a";
        double expected = 6.0;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage5();

        assertEquals(graph.prim(source), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage5();

        assertEquals(graph.prim(source), expected);
    }

    @Test
    public void testPrim3() {

        String source = "a";
        double expected = 24.0;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage6();

        assertEquals(graph.prim(source), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage6();

        assertEquals(graph.prim(source), expected);

    }

    @Test
    public void testKruskal1() {

        double expected = 3600.0;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage4();

        assertEquals(graph.kruskal(), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage4();

        assertEquals(graph.kruskal(), expected);
    }

    @Test
    public void testKruskal2() {
        double expected = 6.0;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage5();

        assertEquals(graph.kruskal(), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage5();

        assertEquals(graph.kruskal(), expected);
    }

    @Test
    public void testKruskal3() {

        double expected = 24.0;

        graph = new ListAdjacencyGraph<>(false);
        setUpStage6();

        assertEquals(graph.kruskal(), expected);

        graph = new MatrixAdjacencyGraph<>(false);
        setUpStage6();

        assertEquals(graph.kruskal(), expected);

    }

    public boolean verifyPath(Edge<String> edge, String[] edgeExpected, double distanceExpected) {

        if (edge.getDistance() != distanceExpected) return false;

        for (int i = 0; i < edgeExpected.length; i++)
            if (!edge.getEdge().get(i).equals(edgeExpected[i]))
                return false;

        return true;
    }
}
