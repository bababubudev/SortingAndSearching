import java.util.Arrays;

public class SearchAlgorithm<T extends Comparable<T>> {
  private int searchOption = 0;
  private T[] data;
  private int length;

  UserOptions uo;

  public SearchAlgorithm(int _searchOption, T[] _data) {
    searchOption = _searchOption;
    data = _data;
    length = this.data.length;
    uo = new UserOptions();
  }

  public void searchByInput() {
    boolean found = false;
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
      default:
        break;
    }

    if (found)
      System.out.println("\nFound\n");
    else
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
}
