import java.util.Arrays;

public class Algorithms<T extends Comparable<T>> {
  private int searchOption = 0;
  private T[] data;
  private int length;

  UserOptions uo;

  public Algorithms(int _searchOption, T[] _data) {
    searchOption = _searchOption;
    data = _data;
    length = this.data.length;
    uo = new UserOptions();
  }

  public void searchByInput() {
    boolean found = false;
    boolean flaggable = false;
    int input = -1;

    switch (searchOption) {
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
        int[] sortedNums = OnsqrSort(nums);
        uo.ShowSortedResults("bubble sorting", sortedNums);
        break;
      case 4:
        flaggable = true;
        int[] rands = uo.GetRandomInts("quick sorting");
        quickSort(rands, 0, rands.length - 1);
        uo.ShowSortedResults("quick sorting", rands);
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

  public int[] OnsqrSort(int[] data) {
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

  public void quickSort(int[] data, int min, int max) {
    if (min < max) {
      int divide = divide(data, min, max);

      quickSort(data, min, divide - 1);
      quickSort(data, divide + 1, max);
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