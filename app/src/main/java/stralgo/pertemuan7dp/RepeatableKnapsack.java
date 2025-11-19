package stralgo.pertemuan7dp;

import java.util.ArrayList;
import java.util.List;

public class RepeatableKnapsack {

  class Item {
    int cost;
    int value;

    public Item(int cost, int value) {
      this.cost = cost;
      this.value = value;
    }
  }

  public RepeatableKnapsack() {
    List<Item> items = new ArrayList<>();
    items.add(new Item(2, 4));
    items.add(new Item(3, 5));
    items.add(new Item(4, 7));
    items.add(new Item(5, 9));

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
          if (j >= item.cost) {
            maxValue = Math.max(maxValue, dpResult[i - 1][j - item.cost] + item.value);
          }
        }
        if (j >= item.cost) {
          maxValue = Math.max(maxValue, dpResult[i][j - item.cost] + item.value);
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
    new RepeatableKnapsack();
  }
}
