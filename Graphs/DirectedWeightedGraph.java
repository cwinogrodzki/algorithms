/**
Author: Claire Winogrodzki
This program implements a directed weighted graph, with vertices
represented as chars. Used by "GraphAlgorithms" program
4/15/2021
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DirectedWeightedGraph {

    //int vertices;
    Map<Character, ArrayList<Edge>> adjList;

    public DirectedWeightedGraph(){
        this.adjList = new HashMap<>();
    }

    class Edge{
        char src;
        char dst;
        int weight;

        public Edge(){};

        public Edge(char src, char dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        public char getDst(){
            return dst;
        }
    }

    public void addVertex(char v) {
        adjList.put(v, new ArrayList<>());
    }

    public void addEdge(char src, char dst, int weight) {
        if (!adjList.containsKey(src)) {
            addVertex(src);
        }
        if (!adjList.containsKey(dst)) {
            addVertex(dst);
        }

        Edge edge = new Edge(src, dst, weight);
        adjList.get(src).add(edge);

    }

    public boolean existsEdge(char src, char dst, int weight) {
        for(Edge e: adjList.get(src)){
            if(e.dst == dst && e.weight == weight) return true;
        }

        return false;
    }

    public ArrayList getNeighbors(char src){
        return adjList.get(src);
    }


}
