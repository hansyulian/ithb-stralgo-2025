package stralgo.pertemuan5shortestpath;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Util {
  public static final int CONSIDERED_INFINITY = 1000_000_000;

  public static List<Edge> getSampleGraph() {
    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(0, 1, 4)); // A-B 4
    edges.add(new Edge(0, 2, 5)); // A-C 5
    edges.add(new Edge(1, 2, 11)); // B-C 11
    edges.add(new Edge(1, 3, 9)); // B-D 9
    edges.add(new Edge(1, 4, 7)); // B-E 7
    edges.add(new Edge(2, 4, 3)); // C-E 3
    edges.add(new Edge(3, 5, 2)); // D-F 2
    edges.add(new Edge(3, 4, 13)); // D-E 13
    edges.add(new Edge(4, 5, 6)); // E-F 6
    return edges;
  }

  public static int[][] generateAdjacencyMatrix(List<Edge> edges) {
    int vertexBoundary = 0;
    for (Edge edge : edges) {
      if (edge.source > vertexBoundary) {
        vertexBoundary = edge.source;
      }
      if (edge.destination > vertexBoundary) {
        vertexBoundary = edge.destination;
      }
    }
    vertexBoundary += 1;
    int[][] adjacencyMatrix = new int[vertexBoundary][vertexBoundary];
    for (int i = 0; i < vertexBoundary; i++) {
      for (int j = 0; j < vertexBoundary; j++) {
        adjacencyMatrix[i][j] = CONSIDERED_INFINITY;
      }
      adjacencyMatrix[i][i] = 0;
    }
    // we assume bidirectional
    for (Edge edge : edges) {
      adjacencyMatrix[edge.source][edge.destination] = edge.weight;
      adjacencyMatrix[edge.destination][edge.source] = edge.weight;
    }
    return adjacencyMatrix;
  }

  public static <T> void print2DArray(T array) {
    if (!array.getClass().isArray() ||
        !array.getClass().getComponentType().isArray()) {
      throw new IllegalArgumentException("Input must be a 2D array");
    }

    int rows = Array.getLength(array);
    int cols = Array.getLength(Array.get(array, 0));

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int value = (int) Array.get(Array.get(array, i), j);
        if (value == CONSIDERED_INFINITY) {
          System.out.printf("%3s", "-");
        } else {
          System.out.printf("%3d", value);
        }
      }
      System.out.println();
    }
  }

}
