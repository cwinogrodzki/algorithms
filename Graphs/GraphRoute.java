/*
Author: Claire Winogrodzki
Uses DirectedUnweightedGraph.java
Based on my professor's outline.
3/30/2021
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class GraphRoute {


    /**
     * An algorithm that determines whether there is a path from node src to node dst in a given graph
     * @param graph - a given graph represented as an adjacency list
     * @param src - source of the edge to be checked
     * @param dst - destination of the edge to be checked
     * @return - true if an edge exists between src and dst
     */
    public static boolean hasPath(DirectedUnweightedGraph graph, char src, char dst) {
        HashSet<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        queue.add(src);

        while(!queue.isEmpty()){
            char node = queue.peek();
            if(!visited.contains(node)){
                visited.add(node);

                //if destination is in visited, then there is a path
                if(node == dst) return true;

                for(char neighbor: graph.getNeighbors(node)){
                    if(!visited.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
            queue.poll();
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedUnweightedGraph graph = new DirectedUnweightedGraph();
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'A');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'H');
        graph.addEdge('D', 'E');
        graph.addEdge('D', 'F');
        graph.addEdge('E', 'D');
        graph.addEdge('E', 'G');
        graph.addEdge('F', 'G');
        graph.addEdge('G', 'H');

        System.out.println(hasPath(graph, 'A', 'A'));
        System.out.println(hasPath(graph, 'A', 'H'));
    }
}
