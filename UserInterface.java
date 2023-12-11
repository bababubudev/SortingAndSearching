import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class ComparisonCounter {
  private long comparisons;

  public void incrementComparison() {
    comparisons++;
  }

  public long getComparisons() {
    return comparisons;
  }

  public void reset() {
    comparisons = 0;
  }
}

public class UserInterface<T extends Comparable<T>> {
  private int callOption = 0;
  private T[] data;
  private int length;

  UserOptions uo;
  ComparisonCounter counter = new ComparisonCounter();

  public UserInterface(int _callOption, T[] _data) {
    callOption = _callOption;
    data = _data;
    length = this.data.length;
    uo = new UserOptions();
  }

  public void callByInput() {
    boolean found = false;
    boolean flaggable = false;
    int input = -1;

    switch (callOption) {
      case 1:
        input = uo.ShowAskPrompt(length, "linear search");
        found = input == -1 ? false : linearSearch(0, length - 1, this.data[input]);
        break;
      case 2:
        input = uo.ShowAskPrompt(length, "binary search");
        Arrays.sort(data);
        found = input == -1 ? false : binarySearch(data, 0, length - 1, this.data[input]);
        break;
      case 3:
        flaggable = true;
        int[] nums = uo.GetRandomInts("bubble sorting");
        int[] sortedNums = onSqrSort(nums);
        uo.ShowSortedResults("bubble sorting", sortedNums);
        break;
      case 4:
        flaggable = true;
        int[] rands = uo.GetRandomInts("quick sorting");
        quickSort(rands, 0, rands.length - 1);
        uo.ShowSortedResults("quick sorting", rands);
        break;
      case 5:
        flaggable = true;
        showOptionFive(1000, 10);
        break;
      case 6:
        flaggable = false;
        createCSV();
        break;
      default:
        break;
    }

    if (flaggable)
      return;

    if (found)
      System.out.println("\nFound\n");
    else if (!found)
      System.out.println("\nNot found\n");
  }

  public void showOptionFive(int baseAmount, int iterationSteps) {
    StringBuilder header = new StringBuilder("\t\t");
    StringBuilder bubbleCompare = new StringBuilder("bs, rnd, cmp\t|");
    StringBuilder bubbleMs = new StringBuilder("bs, rnd, ms\t|");
    StringBuilder quickCompare = new StringBuilder("qs, rnd, cmp\t|");
    StringBuilder quickMs = new StringBuilder("qs, rnd, ms\t|");
    StringBuilder mergeCompare = new StringBuilder("ms, rnd, cmp\t|");
    StringBuilder mergeMs = new StringBuilder("ms, rnd, ms\t|");
    StringBuilder selectCompare = new StringBuilder("ss, rnd, cmp\t|");
    StringBuilder selectMs = new StringBuilder("ss, rnd, ms\t|");

    for (int i = 1; i <= iterationSteps; i++) {
      header.append(" " + baseAmount * i + "\t");
    }

    for (int i = 1; i <= iterationSteps; i++) {
      int size = baseAmount * i;

      counter.reset();
      long startTime = System.nanoTime();
      int[] array = uo.GetRandomInts(size);
      bubbleSort(uo.GetRandomInts(size));
      long endTime = System.nanoTime();

      long elapsedBubbleTime = endTime - startTime;
      long bubbleComparisions = counter.getComparisons();

      counter.reset();
      startTime = System.nanoTime();
      array = uo.GetRandomInts(size);
      quickSort(array.clone(), 0, array.length - 1);
      endTime = System.nanoTime();

      long elapsedQuickTime = endTime - startTime;
      long quickComparisons = counter.getComparisons();

      counter.reset();
      startTime = System.nanoTime();
      array = uo.GetRandomInts(size);
      selectionSort(array.clone());
      endTime = System.nanoTime();

      long elapsedSelectionTime = endTime - startTime;
      long selectComparisons = counter.getComparisons();

      counter.reset();
      startTime = System.nanoTime();
      array = uo.GetRandomInts(size);
      mergeSort(array.clone());
      endTime = System.nanoTime();

      long elapsedMergeTime = endTime - startTime;
      long mergeComparisons = counter.getComparisons();

      bubbleCompare.append(bubbleComparisions).append("\t|");
      bubbleMs.append(elapsedBubbleTime / 1e6).append("\t|");
      quickCompare.append(quickComparisons).append("\t|");
      quickMs.append(elapsedQuickTime / 1e6).append("\t|");
      selectCompare.append(selectComparisons).append("\t|");
      selectMs.append(elapsedSelectionTime / 1e6).append("\t|");
      mergeCompare.append(mergeComparisons).append("\t|");
      mergeMs.append(elapsedMergeTime / 1e6).append("\t|");
    }

    System.out.println(header);
    // System.out.println(bubbleCompare);
    System.out.println(bubbleMs);
    // System.out.println(quickCompare);
    System.out.println(quickMs);
    // System.out.println(selectCompare);
    System.out.println(selectMs);
    // System.out.println(mergeCompare);
    System.out.println(mergeMs);
    System.out.println();
  }

  public void createCSV() {
    int baseAmount = 1000;
    int iterationSteps = 10;

    StringBuilder header = new StringBuilder("\t,");
    StringBuilder bubbleCompare = new StringBuilder("bs_comparisons,");
    StringBuilder quickCompare = new StringBuilder("qs_comparisons,");
    StringBuilder mergeCompare = new StringBuilder("ms_comparisons,");
    StringBuilder selectCompare = new StringBuilder("ss_comparisons,");

    StringBuilder bubbleMs = new StringBuilder("bubble_sort,");
    StringBuilder quickMs = new StringBuilder("quick_sort,");
    StringBuilder mergeMs = new StringBuilder("merge_sort,");
    StringBuilder selectMs = new StringBuilder("selection_sort,");

    StringBuilder csvBuilder = new StringBuilder();

    for (int i = 1; i <= iterationSteps; i++) {
      header.append(baseAmount * i + ",");
    }

    for (int i = 1; i <= iterationSteps; i++) {
      int size = baseAmount * i;

      counter.reset();
      long startTime = System.nanoTime();
      int[] array = uo.GetRandomInts(size);
      bubbleSort(uo.GetRandomInts(size));
      long endTime = System.nanoTime();

      long elapsedBubbleTime = endTime - startTime;
      long bubbleComparisions = counter.getComparisons();

      counter.reset();
      startTime = System.nanoTime();
      array = uo.GetRandomInts(size);
      quickSort(array.clone(), 0, array.length - 1);
      endTime = System.nanoTime();

      long elapsedQuickTime = endTime - startTime;
      long quickComparisons = counter.getComparisons();

      counter.reset();
      startTime = System.nanoTime();
      array = uo.GetRandomInts(size);
      selectionSort(array.clone());
      endTime = System.nanoTime();

      long elapsedSelectionTime = endTime - startTime;
      long selectComparisons = counter.getComparisons();

      counter.reset();
      startTime = System.nanoTime();
      array = uo.GetRandomInts(size);
      mergeSort(array.clone());
      endTime = System.nanoTime();

      long elapsedMergeTime = endTime - startTime;
      long mergeComparisons = counter.getComparisons();

      bubbleMs.append(elapsedBubbleTime / 1e6).append(",");
      quickMs.append(elapsedQuickTime / 1e6).append(",");
      selectMs.append(elapsedSelectionTime / 1e6).append(",");
      mergeMs.append(elapsedMergeTime / 1e6).append(",");

      bubbleCompare.append(bubbleComparisions).append(",");
      quickCompare.append(quickComparisons).append(",");
      selectCompare.append(selectComparisons).append(",");
      mergeCompare.append(mergeComparisons).append(",");
    }

    csvBuilder.append(header + "\n");
    csvBuilder.append(bubbleMs + "\n").append(quickMs + "\n").append(selectMs + "\n").append(mergeMs + "\n");
    csvBuilder.append(bubbleCompare + "\n").append(quickCompare + "\n").append(selectCompare + "\n")
        .append(mergeCompare + "\n\n");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("SortingData.csv"))) {
      writer.write(csvBuilder.toString());
      System.out.println("CSV file created!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean linearSearch(int min, int max, T target) {
    int index = min;
    boolean found = false;

    while (!found && index <= max) {
      found = data[index].equals(target);
      index++;
    }

    return found;
  }

  public boolean binarySearch(T[] data, int min, int max, T target) {
    if (min > max)
      return false;
    int midpoint = (min + max) / 2;

    if (data[midpoint].equals(target)) {
      return true;
    } else if (data[midpoint].compareTo(target) > 0) {
      return binarySearch(data, min, midpoint - 1, target);
    } else {
      return binarySearch(data, midpoint + 1, max, target);
    }
  }

  public int[] onSqrSort(int[] data) {
    int n = data.length;
    int[] sortedArray = data.clone();

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (sortedArray[j] > sortedArray[j + 1]) {
          int temp = sortedArray[j];
          sortedArray[j] = sortedArray[j + 1];
          sortedArray[j + 1] = temp;
        }

      }
    }

    return sortedArray;
  }

  private void bubbleSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
        }
        counter.incrementComparison();
      }
    }
  }

  public void quickSort(int[] data, int min, int max) {
    if (min < max) {
      int divide = divide(data, min, max);

      quickSort(data, min, divide - 1);
      quickSort(data, divide + 1, max);
    }
  }

  private void selectionSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
        counter.incrementComparison();
      }
      swap(array, i, minIndex);
    }
  }

  private void mergeSort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;

      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      merge(array, left, mid, right);
    }
  }

  private void merge(int[] array, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    for (int i = 0; i < n1; ++i) {
      leftArray[i] = array[left + i];
    }
    for (int j = 0; j < n2; ++j) {
      rightArray[j] = array[mid + 1 + j];
    }

    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        array[k] = leftArray[i];
        i++;
      } else {
        array[k] = rightArray[j];
        j++;
      }
      k++;
      counter.incrementComparison();
    }

    while (i < n1) {
      array[k] = leftArray[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = rightArray[j];
      j++;
      k++;
    }
  }

  public int divide(int[] data, int min, int max) {
    int pivot = data[max];
    int index = min - 1;

    for (int i = min; i < max; i++) {
      if (data[i] < pivot) {
        index++;
        swap(data, index, i);
      }
      counter.incrementComparison();
    }

    swap(data, index + 1, max);
    return index + 1;
  }

  public void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}