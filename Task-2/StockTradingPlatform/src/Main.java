import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Entry point of the Stock Trading Platform application.
 *
 * This class initializes the market and user,
 * displays the main menu,
 * processes user input,
 * and coordinates all application operations.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public class Main {

    /**
     * Menu option used to exit the application.
     */
    private static final int EXIT = 9;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize application
        Market market = new Market();
        User user = new User("Bhavya", 100000);

        // Load saved data
        FileManager.loadUser(user);
        FileManager.loadPortfolio(user);
        FileManager.loadTransactions(user);

        int choice;

        do {

            ConsoleUI.printTitle("STOCK TRADING PLATFORM");

            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Portfolio Performance");
            System.out.println("6. View Balance");
            System.out.println("7. View Transaction History");
            System.out.println("8. Update Market Prices");
            System.out.println("9. Exit");

            ConsoleUI.printLine();

            choice = readMenuChoice(scanner);

            switch (choice) {

                case 1:
                    market.displayMarket();
                    break;

                case 2:
                    buyStock(scanner, market, user);
                    break;

                case 3:
                    sellStock(scanner, market, user);
                    break;

                case 4:
                    user.getPortfolio().displayPortfolio(market);
                    break;

                case 5:
                    user.displayPortfolioPerformance(market);
                    break;

                case 6:
                    user.displayBalance();
                    break;

                case 7:
                    user.displayTransactionHistory();
                    break;

                case 8:
                    market.updateMarketPrices();
                    System.out.println("✅ Market prices updated successfully.");
                    break;

                case EXIT:

                    FileManager.saveUser(user);
                    FileManager.savePortfolio(user);
                    FileManager.saveTransactions(user);

                    ConsoleUI.printDoubleLine();
                    System.out.println("Thank you for using the Stock Trading Platform!");
                    System.out.println("Have a great day!");
                    ConsoleUI.printDoubleLine();
                    break;

                default:
                    System.out.println("❌ Invalid menu option.");
            }

        } while (choice != EXIT);

        scanner.close();
    }

    /**
     * Reads a positive integer from the user.
     *
     * @param scanner Scanner object
     * @param prompt Prompt to display
     * @return Valid positive integer
     */
    private static int readPositiveInteger(Scanner scanner, String prompt) {

        while (true) {

            System.out.print(prompt);

            try {

                int value = scanner.nextInt();

                if (value > 0) {
                    return value;
                }

                System.out.println("❌ Please enter a positive number.");

            } catch (InputMismatchException e) {

                System.out.println("❌ Invalid input! Numbers only.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Reads a valid menu option.
     *
     * @param scanner Scanner object
     * @return Menu choice between 1 and 9
     */
    private static int readMenuChoice(Scanner scanner) {

        while (true) {

            System.out.print("Enter your choice: ");

            try {

                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= EXIT) {
                    return choice;
                }

                System.out.println("❌ Please enter a number between 1 and 9.");

            } catch (InputMismatchException e) {

                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Handles stock purchase.
     */
    private static void buyStock(Scanner scanner, Market market, User user) {

        System.out.print("Enter Stock Symbol: ");

        String symbol = scanner.next();

        Stock stock = market.getStockBySymbol(symbol);

        if (stock == null) {
            System.out.println("❌ Stock symbol not found.");
            return;
        }

        int quantity = readPositiveInteger(scanner, "Enter Quantity: ");

        user.buyStock(stock, quantity);
    }

    /**
     * Handles stock selling.
     */
    private static void sellStock(Scanner scanner, Market market, User user) {

        System.out.print("Enter Stock Symbol: ");

        String symbol = scanner.next();

        Stock stock = market.getStockBySymbol(symbol);

        if (stock == null) {
            System.out.println("❌ Stock symbol not found.");
            return;
        }

        int quantity = readPositiveInteger(scanner, "Enter Quantity: ");

        user.sellStock(stock, quantity);
    }
}