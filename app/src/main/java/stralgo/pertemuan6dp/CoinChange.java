package stralgo.pertemuan6dp;

public class CoinChange {

  void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  int dp(int sum, int coins[]) {
    int[][] arr = new int[coins.length][sum + 1];
    // initialize, all arr[coin][0] = 1;
    for (int i = 0; i < coins.length; i++) {
      arr[i][0] = 1;
    }
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= sum; j++) {
        int value = 0;
        if (i > 0) { // if there is no previous row, just consider 0
          value = arr[i - 1][j];
        }
        if (j >= coins[i]) {
          value += arr[i][j - coins[i]];
        }
        arr[i][j] = value;
      }
    }
    printArray(arr);
    return arr[coins.length - 1][sum];
  }

  CoinChange() {
    System.out.println(dp(5, new int[] { 1, 2, 4 }));
    System.out.println(dp(10, new int[] { 1, 2, 5 }));
    System.out.println(dp(5, new int[] { 4, 2 }));
  }

  public static void main(String[] args) {
    new CoinChange();
  }
}
