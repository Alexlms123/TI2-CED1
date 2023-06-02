package com.example.airlinegraph.model;

import com.example.airlinegraph.graph.ListAdjacencyGraph;
import com.example.airlinegraph.graph.IGraph;
import com.example.airlinegraph.graph.Edge;
import com.example.airlinegraph.graph.Vertex;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

public class AirlineUSA {

    private IGraph<USAState> graph;

    private String PATH_STATES = "./db/States Of Usa.txt";
    private String PATH_CONNECTIONS = "./db/ConnectionStates.txt";
    private Map<String, USAState> states;

    public AirlineUSA(){
        graph = new ListAdjacencyGraph<>(true);
        states = new HashMap<>();

        loadStates();
        loadConnections();

    }

    public Edge<USAState> findFastestRoute(String from, String to){

        return graph.dijkstra(states.get(from), states.get(to));
    }

    public Edge<USAState> findShortestRoute(String from, String to){

        graph.BFS(states.get(from));

        List<USAState> shortestPath = new ArrayList<>();

        Vertex<USAState> current = graph.searchVertex(states.get(to));
        double numStations = current.getD() + 1;

        while (current != null){
            shortestPath.add(current.getElement());
            current = current.getPredecessor();
        }

        Collections.reverse(shortestPath);

        return new Edge<>(shortestPath, numStations);

    }

    public void loadStates(){
        try{

            File file = new File(PATH_STATES);

            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;

            while ((line = reader.readLine()) != null){
                USAState state = new USAState(line);
                states.put(line, state);
                graph.addVertex(state);
            }

            fis.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void loadConnections(){
        try{

            File file = new File(PATH_CONNECTIONS);

            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;

            while ((line = reader.readLine()) != null){
                String [] parts = line.split(",");
                graph.addEdge(
                        states.get(parts[0]),
                        states.get(parts[1]),
                        Double.parseDouble(parts[2])
                );
            }

            fis.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public Map<String, USAState> getStates() {
        return states;
    }

}
