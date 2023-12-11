class Program {
  private final static UserOptions uo = new UserOptions();
  private final static String[] values = {
      "Mike", "Afton",
      "Apple", "Banana",
      "Pear", "Six",
      "Lower", "Fox",
      "Sly", "Fast"
  };

  public static void main(String[] args) {
    do {
      uo.showMainMenu();
      String menuOption = uo.getStrInput().toLowerCase();

      if (menuOption.toLowerCase().equals("q")) {
        break;
      }

      try {
        int searchOption = Integer.parseInt(menuOption);
        UserInterface<String> ui = new UserInterface<String>(searchOption, values);

        ui.callByInput();
      } catch (NumberFormatException e) {
        System.out.println("\nNot found\n");
      }
    } while (true);
  }
}