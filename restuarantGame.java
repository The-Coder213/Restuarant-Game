import java.util.Scanner;
import java.util.Random;


public class restuarantGame {
    public static Scanner scanner = new Scanner(System.in);
    static int coins = 0;

    public static class configFries {
        String mainFriesSize;
        boolean salt;
        boolean blackPepper;
        
        public configFries(String mainFriesSize, boolean salt, boolean blackPepper){
            this.mainFriesSize = mainFriesSize;
            this.salt = salt;
            this.blackPepper = blackPepper;
        }

        public void displayInfo() {
            System.err.println("Fries Size: " + mainFriesSize);
            System.out.println("Salt: " + salt);
            System.out.println("Black Pepper: " + blackPepper);
        }

        public void askQuestionsAndCheckAnswers() {
            System.out.println("Type Fries Size: ");
            String userFriesSize = scanner.next();
            
            System.out.println("Salt: ");
            boolean userSalt =  scanner.nextBoolean();

            System.out.println("Black Pepper: ");
            boolean userBlackPepper =  scanner.nextBoolean();

            if (userFriesSize.equals(mainFriesSize)) {
                if (userSalt == salt) {
                    if (userBlackPepper == blackPepper) {
                        System.out.println("Amaing You Got The Correct Meal");
                        coins += 10;
                    } else {
                        System.out.println("Wrong Black Pepper!");
                    }
                } else {
                    System.out.println("Wrong Salt!");
                }
            } else {
                System.out.println("Wrong Fries Size!");
            }
        }

    public static class configBurger {
        String mainPattyType;
        boolean mainSauces;
        boolean mainCheese;

        public configBurger(String mainPattyType, boolean mainSauces, boolean mainCheese) {
            this.mainPattyType = mainPattyType;
            this.mainSauces = mainSauces;
            this.mainCheese = mainCheese;
        }

        public void displayInfo() {
            System.out.println("Patty Type: " + mainPattyType);
            System.out.println("Sauces: "+  mainSauces);
            System.out.println("Cheese: " + mainCheese);
        }

        public void askQuestionsAndCheckAnswers() {
            System.out.println("Type Patty Type Here: ");
            String userPattyType = scanner.next();
            
            System.out.println("Sauces: ");
            boolean userSauce =  scanner.nextBoolean();

            System.out.println("Cheese: ");
            boolean userCheese =  scanner.nextBoolean();

            if (userPattyType.equals(mainPattyType)) {
                if (userSauce == mainSauces) {
                    if (userCheese == mainCheese) {
                        System.out.println("Amaing You Got The Correct Meal");
                        coins += 10;
                    } else {
                        System.out.println("Wrong Cheese!");
                    }
                } else {
                    System.out.println("Wrong Sauce!");
                }
            } else {
                System.out.println("Wrong Patty Type!");
            }
        }

    }

    public static class configCake {
        String mainFlavour;
        boolean mainSprinkles;
        boolean mainIcing;

        public configCake(String mainFlavour, boolean mainSprinkles, boolean mainIcing) {
            this.mainFlavour = mainFlavour;
            this.mainSprinkles = mainSprinkles;
            this.mainIcing = mainIcing;
        }

        public void displayInfo() {
            System.out.println("Flavour: " + mainFlavour);
            System.out.println("Sprinkles: " + mainSprinkles);
            System.out.println("Icing: " + mainIcing);
        }

        public void askQuestionsAndCheckAnswers() {
            System.out.println("Type Flavor: ");
            String userFlavour = scanner.next();
            
            System.out.println("Sprinkles: ");
            boolean userSprinkles =  scanner.nextBoolean();

            System.out.println("Icing: ");
            boolean userIcing =  scanner.nextBoolean();

            if (userFlavour.equals(mainFlavour)) {
                if (userSprinkles == mainSprinkles) {
                    if (userIcing == mainIcing) {
                        System.out.println("Amaing You Got The Correct Meal");

                        coins += 10;
                    } else {
                        System.out.println("Wrong Icing!");
                    }
                } else {
                    System.out.println("Wrong Sprinkles!");
                }
            } else {
                System.out.println("Wrong Flavour!");
            }
        }
    }

    public static void main(String[] args) {
        
    String firesSizes[] = {"small", "medium", "large"};
    String pattyTypes[] = {"normal", "vegan", "gluten-free"};
    String cakeFlavours[] = {"chocolate", "vanilla", "strawberry", "lemon", "mint"};

    boolean bools[] = {true, false};
        Random rand = new Random();

        boolean order = false;

        
        while (true) {
            if (order == false) {
                System.out.println("New Order Alert!!!");
                order = true;

                try {
                    Thread.sleep(2500);
                    
                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt(); // Restore interrupted status
                }


                int foodItemIndex = rand.nextInt(3);
                int boolIndexOne = rand.nextInt(2);
                int boolIndexTwo = rand.nextInt(2);
                
                if (foodItemIndex == 0) {
                    System.out.println("Food: Fries");
                    String friesSize = firesSizes[rand.nextInt(3)];

                     configFries newOrder = new configFries(friesSize, bools[boolIndexOne], bools[boolIndexTwo]);
                     newOrder.displayInfo();

                     newOrder.askQuestionsAndCheckAnswers();

                     System.out.println("Coins Value: " + coins);
                     order = false;

                } else if (foodItemIndex == 1) {
                    System.out.println("Food: Burger");
                    String pattyType = pattyTypes[rand.nextInt(3)];

                    configBurger newOrder = new configBurger(pattyType, bools[boolIndexOne], bools[boolIndexTwo]);
                    newOrder.displayInfo();

                    newOrder.askQuestionsAndCheckAnswers();

                    System.out.println("Coins Value: " + coins);
                    order = false;
                } else{
                    System.out.println("Food: Cake");
                    String cakeFlavour = cakeFlavours[rand.nextInt(6)];

                    configCake newOrder = new configCake(cakeFlavour, bools[boolIndexOne], bools[boolIndexTwo]);
                    newOrder.displayInfo();

                    newOrder.askQuestionsAndCheckAnswers();

                    System.out.println("Coins Value: " + coins);
                    order = false;
                }
              }
            }
          }
        }
     }

