/**
 Author: Claire Winogrodzki
 A collection of graph algorithms, including Depth-First Search, Topological Sort,
 and cycle detection. Main method creates 2 directed unweighted graphs, and
 prints results of each algorithm.
 3/18/2021
 */

import java.util.*;

public class GraphAlgorithms{

    //directed unweighted graph
    Map<Character, ArrayList<Character>> map;
    public GraphAlgorithms() { this.map = new HashMap<>(); } //graph constructor

    //graph methods
    public void addVertex(char v) {
        map.put(v, new ArrayList<>());
    }

    public void addEdge(char from, char to) {
        if (!map.containsKey(from)) {
            addVertex(from);
        }
        if (!map.containsKey(to)) {
            addVertex(to);
        }
        List<Character> edges = map.get(from);
        if (!edges.contains(to)) {
            edges.add(to);
        }
    }

    public ArrayList<Character> getNeighbors(char node){
        return map.get(node);
    }

    public void visit(char v) {
        System.out.println(v);
    }

    /**
    * Performs DFS traversal of a graph using a helper method
    */
    public void dfsTraversal() {
        Set<Character> visited = new HashSet<>();

        for (Character v: map.keySet()) {
            dfs(v, visited);
        }
    }

    /**
     * A DFS helper method that recursively 'visits' every vertex by going 'deep' into a path from a given vertex
     * @param v - start DFS from this vertex
     * @param visited - a set of already visited nodes
     */
    public void dfs(char v, Set<Character> visited) {
        if (visited.contains(v)) return;

        visit(v);
        visited.add(v);

        for (char n: map.get(v)) {
            if (!visited.contains(n)) {
                dfs(n, visited); }
        }
    }

    /**
     * A topsort helper method that uses DFS to find the ordering from a given vertex
     * @param v - start DFS from this vertex
     * @param visited - a set of already visited nodes
     */
    public void topsortDFS(char v, Set<Character> visited) {
        //use stack to keep track of order and pop to get sorted

        if (visited.contains(v)) return;

        visit(v);
        visited.add(v);

        for (char n: map.get(v)) {
            if (!visited.contains(n)) {
                dfs(n, visited); }
        }
    }

    /**
     * Topological sort algorithm that returns one topological ordering of the graph nodes
     * Hint: you can self-check by following your output ordering to see if the result meets all the order constraints
     * defined by the directed edges
     * @return an array that represents the topological ordering of the digraph
     */
    public char[] topsort() {
        char[] ordering = new char[map.keySet().size()]; //
        Set<Character> visited = new HashSet<>();

        for (Character v: map.keySet()) {
        topsortDFS(v, visited);
        }

        return ordering;
    }

    /**
     * A hasCycle helper method that uses DFS to detect if a digraph contains a cycle
     * @param v - start DFS from this vertex
     * @param visited - a set of already visited nodes
     * @return true if cycle detected and false otherwise
     */
    public boolean hasCycleDFS(char v, Set<Character> visited, Set<Character> rec_stack) {

        if (visited.contains(v)) return false;

        visit(v);
        visited.add(v);
        rec_stack.add(v);

        for (char n: map.get(v)) {
            if (!visited.contains(n) && hasCycleDFS(n, visited, rec_stack)) {
                return true;}
            else if(rec_stack.contains(n)) return true;
        }
        rec_stack.remove(v);
        return false;
    }

    /**
     * An algorithm that detects if a digraph contains a cycle
     * @return true if cycle detected and false otherwise
     */
    public boolean hasCycle() {
        Set<Character> visited = new HashSet<>();
        Set<Character> rec_stack = new HashSet<>();

        for (Character v: map.keySet()) {
            if(hasCycleDFS(v, visited, rec_stack)){
                return true; }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphAlgorithms graph = new GraphAlgorithms();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'A');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'D');

        System.out.println("Graph 1 DFS traversal:");
        graph.dfsTraversal();

        System.out.println("Check for cycle: ");
        System.out.println(graph.hasCycle() + "\n");

        GraphAlgorithms graph1 = new GraphAlgorithms();
        graph1.addEdge('B', 'A');
        graph1.addEdge('A', 'C');
        graph1.addEdge('D', 'A');
        graph1.addEdge('D', 'C');
        graph1.addEdge('E', 'D');
        graph1.addEdge('C', 'E');

        System.out.println("Graph 2 topological sort: ");
        graph1.topsort();
        System.out.println("Check for cycle: ");
        System.out.println(graph1.hasCycle());
    }
}
