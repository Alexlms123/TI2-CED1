package com.example.airlinegraph.graph;

import java.util.List;

public class Edge<E> {

    private List<E> edge;
    private double distance;

    public Edge(List<E> edge, double distance){
        this.edge = edge;
        this.distance = Math.round(distance * 100.0) / 100.0;
    }

    public double getDistance() {
        return distance;
    }

    public List<E> getEdge() {
        return edge;
    }
}

