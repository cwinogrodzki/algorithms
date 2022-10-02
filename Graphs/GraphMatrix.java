/**
Author: Claire Winogrodzki
An unweighted, undirected graph represented as an adjacency matrix. Vertices are type
int (first vertex value is 0). This program prints out an example of a graph matrix
with 5 vertices.
3/25/2021
 */

public class GraphMatrix {
    /**
     * Initialize a graph with a known number of vertices
     * @param numVertices - the number of vertices in the graph
     */
    int[][] matrix;
    int vertices;

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
        matrix[dst][src] = 1;
    }

    public void removeEdge(int src, int dst) {
        matrix[src][dst] = 0;
        matrix[dst][src] = 0;
    }

    /**
     * Prints out the adjacency matrix to the console
     */
    public void printGraph() {
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                if (matrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
                else System.out.print(0 + " ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(5);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}
