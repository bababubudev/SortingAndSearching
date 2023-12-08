import java.util.Random;
import java.util.Scanner;

public class UserOptions {
  private static final Scanner scan = new Scanner(System.in);

  public void showMainMenu() {
    System.out.println("Menu of Searching and Sorting Testbed.");
    System.out.println();
    System.out.println("1) Linear searching");
    System.out.println("2) Binary searching");
    System.out.println("3) O(n^2) type of sorting");
    System.out.println("4) O(n*log(n)) type of sorting");
    System.out.println("5) Sorting performance");
    System.out.println();
    System.out.println("q/Q) Quit");
    System.out.print("\nYour choice: ");
  }

  public int getInput() {
    int input = scan.nextInt();
    scan.nextLine();
    return input;
  }

  public int getInput(int min, int max) {
    int input = scan.nextInt();
    scan.nextLine();

    if (input < min || input > max) {
      return -1;
    }

    return input;
  }

  public String getStrInput() {
    String input = scan.nextLine();
    return input;
  }

  public int ShowAskPrompt(int length, String type) {
    System.out.print("In the list are values 0, ..., " + (length - 1) + ";");
    System.out.print(" which value would you like to search with " + type + "? ");
    return getInput(0, length - 1);
  }

  public int[] GetRandomInts(String type) {
    System.out.println("\nData set before " + type + ": ");
    Random random = new Random();
    int[] randomNums = new int[10];

    for (int i = 0; i < 10; i++) {
      randomNums[i] = random.nextInt(-100, 100);
      System.out.print(randomNums[i] + " ");
    }

    System.out.println();
    return randomNums;
  }

  public void ShowSortedResults(String type, int[] values) {
    System.out.println("\nData set after " + type + ": ");
    for (int i = 0; i < values.length; i++) {
      System.out.print(values[i] + " ");
    }
    System.out.println("\n");
  }
}
