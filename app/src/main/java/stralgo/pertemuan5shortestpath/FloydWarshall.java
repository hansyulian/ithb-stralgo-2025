package stralgo.pertemuan5shortestpath;

public class FloydWarshall {

  FloydWarshall() {
    int[][] adjacencyMatrix = Util.generateAdjacencyMatrix(Util.getSampleGraph());
    System.out.println("adjacency matrix:");
    Util.print2DArray(adjacencyMatrix);

    for (int i = 0; i < adjacencyMatrix.length; i++) {
      for (int j = 0; j < adjacencyMatrix.length; j++) {
        for (int k = 0; k < adjacencyMatrix.length; k++) {
          adjacencyMatrix[j][k] = Math.min(adjacencyMatrix[j][k], adjacencyMatrix[j][i] + adjacencyMatrix[i][k]);
        }
      }
    }

    System.out.println("shortest path matrix:");
    Util.print2DArray(adjacencyMatrix);
  }

  public static void main(String[] args) {
    new FloydWarshall();
  }
}
