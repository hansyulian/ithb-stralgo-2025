package stralgo.pertemuan5shortestpath;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

  class Item {
    public int vertex;
    public int distance;

    public Item(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }
  }

  Dijkstra() {
    int[][] adjacencyMatrix = Util.generateAdjacencyMatrix(Util.getSampleGraph());

    System.out.println("adjacency matrix:");
    Util.print2DArray(adjacencyMatrix);

    PriorityQueue<Item> priorityQueue = new PriorityQueue<>(new Comparator<Item>() {
      @Override
      public int compare(Item o1, Item o2) {
        return o1.distance - o2.distance;
      }
    });

    priorityQueue.add(new Item(0, 0)); // add A with distance 0
    int target = 5; // F is the index 5

    Item current = priorityQueue.poll();
    // if want to optimize visited, uncomment this and all ***
    // boolean hasBeenVisited[] = new boolean[adjacencyMatrix.length];
    while (current.vertex != target) {
      // if want to optimize visited, uncomment this and all ***
      // hasBeenVisited[current.vertex] = true;
      for (int i = 0; i < adjacencyMatrix[current.vertex].length; i++) {
        if (i == current.vertex) { // skip the current vertex
          continue;
        }
        // if want to optimize visited, uncomment this and all ***
        // if (hasBeenVisited[i]) {
        // continue;
        // }
        if (adjacencyMatrix[current.vertex][i] != 0) { //
          priorityQueue.add(new Item(i, current.distance + adjacencyMatrix[current.vertex][i]));
        }
      }
      current = priorityQueue.poll();
    }
    System.out.println("Distance from A to F is " + current.distance);
  }

  public static void main(String[] args) {
    new Dijkstra();
  }
}
