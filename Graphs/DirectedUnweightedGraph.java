/*
Claire Winogrodzki
Implementation of a directed unweighted graph using HashMap data structure.
3/30/2021
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedUnweightedGraph {

    Map<Character, ArrayList<Character>> map;

    public DirectedUnweightedGraph() {

        this.map = new HashMap<>();
    }

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

}
