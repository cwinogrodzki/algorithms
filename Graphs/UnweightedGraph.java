/**
Author: Claire Winogrodzki
 Implementation of an unweighted, undirected graph using a HashMap structure,
 represented as an adjacency list. Nodes are type char. The main method
 prints an example graph. Method headers were created by my teacher Dr. Zhang
3/11/2021
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnweightedGraph {
    public HashMap<Character, ArrayList<Character>> m;

    public UnweightedGraph() {
        m = new HashMap<>();
    }

    /**
     * Add the given vertex to the graph
     * @param v - name of vertex
     */
    public void addVertex(char v) {
        m.put(v, new ArrayList<>());
    }

    /**
     * Remove the given vertex from the graph
     * @param v - name of vertex
     */
    public void removeVertex(char v) {
        m.remove(v);
    }

    /**
     * Add the edge specified by the two vertices to the undirected graph
     * @param from - one vertex of the edge
     * @param to - another vertex of the edge
     */
    public void addEdge(char from, char to) {
        if(!m.containsKey(from)) addVertex(from);
        if(!m.containsKey(to)) addVertex(to);

        m.get(from).add(to);
        m.get(to).add(from);
    }

    /**
     * Remove the edge specified by the two vertices from the undirected graph
     * @param from - one vertex of the edge
     * @param to - another vertex of the edge
     */
    public void removeEdge(char from, char to) {
        m.get(from).remove(to);
        m.get(to).remove(from);
    }

    /**
     * Check to see if an edge specified by the given two vertices
     * @param from - one vertex of the edge
     * @param to - another vertex of the edge
     * @return true if the specified edge exists and false otherwise
     */
    public boolean existsEdge(char from, char to) {
        if(m.get(from).contains(to)) return true;
        else return false;
    }

    /**
     * Prints the graph as an adjacency list representation
     */
    public void printGraph() {
        //iterate through map
        for (Map.Entry<Character, ArrayList<Character>> entry : m.entrySet()) {
            Character key = entry.getKey();
            ArrayList value = entry.getValue();

            //iterate through list values
            System.out.print("\n[" + key + "]");
            for (int i = 0; i < value.size(); i++) {
                System.out.print(" -> " + value.get(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UnweightedGraph graph = new UnweightedGraph();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('C', 'B');
        graph.addEdge('D', 'C');
        graph.addEdge('C', 'E');
        graph.addEdge('A', 'E');

        graph.printGraph();

//        Your console output should look like the following:
//        [A] -> B -> C -> E
//        [B] -> A -> C
//        [C] -> A -> B -> D -> E
//        [D] -> C
//        [E] -> C -> A

    }
}
