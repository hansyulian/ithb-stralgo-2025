package stralgo.pertemuan4;

public class MergeSort {

  int[] merge(int[] leftArr, int[] rightArr) {
    int[] merged = new int[leftArr.length + rightArr.length];
    int leftIndex = 0;
    int rightIndex = 0;
    int mergedIndex = 0;
    while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
      if (leftArr[leftIndex] < rightArr[rightIndex]) {
        merged[mergedIndex++] = leftArr[leftIndex++];
      } else {
        merged[mergedIndex++] = rightArr[rightIndex++];
      }
    }
    while (leftIndex < leftArr.length) {
      merged[mergedIndex++] = leftArr[leftIndex++];
    }
    while (rightIndex < rightArr.length) {
      merged[mergedIndex++] = rightArr[rightIndex++];
    }
    return merged;
  }

  int[] mergeSort(int[] arr, int left, int right) {
    if (left == right) {
      return arr; // can't split anymore, just return
    }
    int mid = (left + right) / 2;
    int[] leftArr = mergeSort(arr, left, mid);
    int[] rightArr = mergeSort(arr, mid + 1, right);
    return merge(leftArr, rightArr);

  }

  public MergeSort() {
    int[] arr = { 6, 5, 12, 10, 9, 1 };
    int[] sorted = mergeSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(sorted[i]);
    }
  }

  public static void main(String[] args) {
    new MergeSort();
  }

}
