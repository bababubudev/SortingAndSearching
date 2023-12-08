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
    String menuOption = "";

    do {
      uo.showMainMenu();
      menuOption = uo.getStrInput().toLowerCase();

      int searchOption = Integer.parseInt(menuOption);
      SearchAlgorithm<String> so = new SearchAlgorithm<String>(searchOption, values);

      so.searchByInput();
    } while (!menuOption.toLowerCase().equals("q"));
  }

}