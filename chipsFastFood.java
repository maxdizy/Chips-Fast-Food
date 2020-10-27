//Max Dizy
//October 31, 2020
//ICS4U
//Mr. Hofstatter
//Allow user to order food from Chip's Fast Food Emporium including caloric information and nutritional suggestions

import java.util.Hashtable;
import java.util.Scanner;
public class chipsFastFood{

  public static boolean approved;

  //method to print menu
  public static void printMenu(String nameVar){
    //print hello statement
    System.out.println("\n" + "Hello " + nameVar + ", this is my menu.");
    //print menu
    System.out.println("\n" + "BURGERS                                             SIDE ORDERS");
    System.out.println("A. Cheese Burger   461 Calories     $3.99           A. Fries            100 Calories      $2.99");
    System.out.println("B. Fish Burger     431 Calories     $4.99           B. Baked Potato      57 Calories      $1.99");
    System.out.println("C: Veggie Burger   410 Calories     $4.99           C. Chef Salad        70 Calories      $2.99");
    System.out.println("D. No Burger         0 Calories                     D. No Side Order      0 Calories           ");
    System.out.println("\n" + "DRINKS                                              DESSERT");
    System.out.println("A. Soft Drink      130 Calories     $1.99           A. Apple Pie        167 Calories      $2.99");
    System.out.println("B. Orange Juice    160 Calories     $2.99           B. Sundae           266 Calories      $1.99");
    System.out.println("C: Milk            118 Calories     $2.50           C. Fruit Cup         75 Calories      $0.99");
    System.out.println("D. No Drink          0 Calories                     D. No Dessert         0 Calories           ");
  }

  //method to print Burger Menu
  public static String printBurgerMenu(){
    return ("\n" + "A. Cheese Burger   B. Fish Burger    C. Veggie Burger    D. No Burger");
  }

  //method to print Side Order Menu
  public static String printSideOrderMenu(){
    return ("\n" + "A. Fries   B. Baked Potato   C. Chef Salad   D. No Side Order");
  }

  //method to print Drink Menu
  public static String printDrinkMenu(){
    return ("\n" + "A. Soft Drink    B. Orange Juice   C. Milk   D. No Drink");
  }

  //method to print Dessert Menu
  public static String printDessertMenu(){
    return ("\n" + "A. Apple Pie   B. Sundae   C. Fruit Cup    D. No Dessert");
  }

  //method to check if input is a DOUBLE
  public static void checkIfDouble(String prompt, double doubleVar){
    Scanner scan = new Scanner(System.in);
    boolean ifDouble;
    System.out.print(prompt);
    do{
      if(scan.hasNextDouble()){
        doubleVar = scan.nextDouble();
        ifDouble = true;
      }else{
        System.out.println("invalid response. please enter a number and try again...");
        ifDouble = false;
        scan.next();
        System.out.print(prompt);
      }
    }while (!(ifDouble));
  }

  //method to check if name is compossed of letters
  public static boolean checkName(String name){
    Scanner scan = new Scanner(System.in);
    boolean confirmed = false;
    boolean ifString = false;
    char[] nameArray = name.toCharArray();
    char[] alph = "abcdefghijklmnopqrstuvwrxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    for (char digit : nameArray){
      confirmed = false;
      for (char letter : alph){
        if (digit == letter){
          confirmed = true;
        }
      }
      if (confirmed == false){
        System.out.println("Sorry I don\'t understand, Please only use letters and try again: ");
        return false;
      }
    }
    return true;
  }

  //method to check if input is a A, B, C OR D
  public static boolean checkChoice(String input){
    Scanner scan = new Scanner(System.in);
    boolean approved = false;
    char[] possibleEntries = {'A', 'B', 'C', 'D'};
    char[] inputArray = input.toCharArray();
    while(!(approved)){
      if (input.length() == 1){
        for (char letter : possibleEntries){
          if (inputArray[0] == letter){
            approved = true;
          }
        }
      }
      if (!(approved)){
        System.out.print("\n" + "Sorry I don\'t understand. Please enter \'A\', \'B\', \'C\' or \'D\' and try again: ");
        return approved;
      }
    }
    return approved;
  }

  public static void main(String[] args){
    //create menu item dictionarys
    Hashtable<String, Object> menuCal = new Hashtable<String, Object>();
    Hashtable<String, Object> menuPrice = new Hashtable<String, Object>();
    Hashtable<String, String> menuBurgerSymbol = new Hashtable<String, String>();
    Hashtable<String, String> menuSideOrderSymbol = new Hashtable<String, String>();
    Hashtable<String, String> menuDrinkSymbol = new Hashtable<String, String>();
    Hashtable<String, String> menuDessertSymbol = new Hashtable<String, String>();

    //burgers
    menuCal.put("Cheeseburger", 461);
    menuPrice.put("Cheeseburger", 3.99);
    menuBurgerSymbol.put("A", "Cheeseburger");
    menuCal.put("Fish Burger", 431);
    menuPrice.put("Fish Burger", 4.99);
    menuBurgerSymbol.put("B", "Fish Burger");
    menuCal.put("Veggie Burger", 420);
    menuPrice.put("Veggie Burger", 4.99);
    menuBurgerSymbol.put("C", "Veggie Burger");
    menuCal.put("No Burger", 0);
    menuPrice.put("No Burger", 0);
    menuBurgerSymbol.put("D", "No Burger");

    //side orders
    menuCal.put("Fries", 100);
    menuPrice.put("Fries", 2.99);
    menuSideOrderSymbol.put("A", "Fries");
    menuCal.put("Baked Potato", 57);
    menuPrice.put("Baked Potato", 1.99);
    menuSideOrderSymbol.put("B", "Baked Potato");
    menuCal.put("Chef Salad", 70);
    menuPrice.put("Chef Salad", 2.99);
    menuSideOrderSymbol.put("C", "Chef Salad");
    menuCal.put("No Side Order", 0);
    menuPrice.put("No Side Order", 0);
    menuSideOrderSymbol.put("D", "No Side Order");

    //drinks
    menuCal.put("Soft Drink", 130);
    menuPrice.put("Soft Drink", 1.99);
    menuDrinkSymbol.put("A", "Soft Drink");
    menuCal.put("Orange Juice", 160);
    menuPrice.put("Orange Juice", 2.99);
    menuDrinkSymbol.put("B", "Orange Juice");
    menuCal.put("Milk", 118);
    menuPrice.put("Milk", 2.50);
    menuDrinkSymbol.put("C", "Milk");
    menuCal.put("No Drink", 0);
    menuPrice.put("No Drink", 0);
    menuDrinkSymbol.put("D", "No Drink");

    //desserts
    menuCal.put("Apple Pie", 167);
    menuPrice.put("Apple Pie", 2.99);
    menuDessertSymbol.put("A", "Apple Pie");
    menuCal.put("Sundae", 266);
    menuPrice.put("Sundae", 1.99);
    menuDessertSymbol.put("B", "Sundae");
    menuCal.put("Fruit Cup", 75);
    menuPrice.put("Fruit Cup", 0.99);
    menuDessertSymbol.put("C", "Fruit Cup");
    menuCal.put("No Dessert", 0);
    menuPrice.put("No Dessert", 0);
    menuDessertSymbol.put("D", "No Dessert");

    //create Scanner
    Scanner scan = new Scanner(System.in);
    //Welcome Screen
    System.out.println("Welcome to Chip\'s Fast Food! My name is Rebecca, I\'ll be your waiter today!");

    //recieve user name
    String name = "";
    boolean ifString = false;
    while(!ifString){
      System.out.print("\n" + "Please enter you name to continue: ");
      name = scan.next();
      ifString = checkName(name);
    }

    //print menu
    printMenu(name);

    //take order
    //Burger
    String burgerChoice = "";
    approved = false;
    while (!approved){
      System.out.print("\n" + printBurgerMenu());
      System.out.print("\n" + "Please enter a Burger choice from the options above: ");
      burgerChoice = scan.next().toUpperCase();
      approved = checkChoice(burgerChoice);
    }
    burgerChoice = menuBurgerSymbol.get(burgerChoice);

    //Side Order
    String sideOrderChoice = "";
    approved = false;
    while (!approved){
      System.out.print("\n" + printSideOrderMenu());
      System.out.print("\n" + "Please enter a Side Order choice from the options above: ");
      sideOrderChoice = scan.next().toUpperCase();
      approved = checkChoice(sideOrderChoice);
    }
    sideOrderChoice = menuSideOrderSymbol.get(sideOrderChoice);

    //Drink
    String drinkChoice = "";
    approved = false;
    while (!approved){
      System.out.print("\n" + printDrinkMenu());
      System.out.print("\n" + "Please enter a Drink choice from the options above: ");
      drinkChoice = scan.next().toUpperCase();
      approved = checkChoice(drinkChoice);
    }
    drinkChoice = menuDrinkSymbol.get(drinkChoice);

    //Dessert
    String dessertChoice = "";
    approved = false;
    while (!approved){
      System.out.print("\n" + printDessertMenu());
      System.out.print("\n" + "Please enter a Dessert choice from the options above: ");
      dessertChoice = scan.next().toUpperCase();
      approved = checkChoice(dessertChoice);
    }
    dessertChoice = menuDessertSymbol.get(dessertChoice);

    System.out.println(burgerChoice + " " + sideOrderChoice + " " + drinkChoice + " " + dessertChoice);
  }
}
