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
        Algorithms<String> so = new Algorithms<String>(searchOption, values);

        so.searchByInput();
      } catch (NumberFormatException e) {
        System.out.println("\nNot found\n");
      }
    } while (true);
  }
}