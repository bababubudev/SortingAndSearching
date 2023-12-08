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
}
