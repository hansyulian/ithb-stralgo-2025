package stralgo.pertemuan4;

public class BinarySearch {

  int search(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] == target) {
        System.out.println("Info: Target found at index " + mid);
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
      System.out.println("Info: Searching on new section: " + left + " - " + right);
    }
    System.out.println("Info: Target not found");
    return -1;
  }

  public BinarySearch() {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int target = 5;
    int index = search(arr, target);
    if (index == -1) {
      System.out.println("Target not found");
    } else {
      System.out.println("Target found at index " + index);
    }
  }

  public static void main(String[] args) {
    new BinarySearch();
  }
}
