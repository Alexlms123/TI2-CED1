package com.example.airlinegraph.graph;

import javafx.util.Pair;

import java.util.Map;

public interface IGraph<E> {

    void addVertex(E element);
    void addEdge(E source, E destination, double weight);

    Vertex<E> searchVertex(E element);

    Double searchEdge(E source, E destination);

    void deleteVertex(E element);

    void deleteEdge(E source, E destination);

    boolean BFS(E sourceElement);
    int DFS();
    Edge<E> dijkstra(E source, E destination);

    Map<Pair<E, E>, Edge<E>> floydWarshall();

    double prim(E source);

    double kruskal();

}
