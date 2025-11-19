package stralgo.pertemuan7dp;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

  class Item {
    int cost;
    int value;

    public Item(int cost, int value) {
      this.cost = cost;
      this.value = value;
    }
  }

  public Knapsack() {
    List<Item> items = new ArrayList<>();
    items.add(new Item(3, 8));
    items.add(new Item(1, 3));
    items.add(new Item(2, 4));
    items.add(new Item(4, 5));

    int[][] result = dp(items, 7);
    printArray(result);
  }

  int[][] dp(List<Item> items, int capacity) {
    int[][] dpResult = new int[items.size()][capacity + 1];
    for (int i = 0; i < items.size(); i++) {
      Item item = items.get(i);
      for (int j = 0; j < capacity + 1; j++) {
        int maxValue = 0;
        if (i > 0) {
          maxValue = Math.max(maxValue, dpResult[i - 1][j]);
        }
        if (j >= item.cost) {
          int base = 0;
          if (i >= 1) {
            base = dpResult[i - 1][j - item.cost];
          }
          maxValue = Math.max(maxValue, base + item.value);
        }
        dpResult[i][j] = maxValue;
      }
    }
    return dpResult;
  }

  void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    new Knapsack();
  }
}
