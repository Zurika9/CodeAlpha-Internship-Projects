import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Market market = new Market();
        User user = new User("Bhavya", 100000);
        FileManager.loadUser(user);
        FileManager.loadPortfolio(user, market);
        FileManager.loadTransactions(user);

        int choice=0;

        do {

            System.out.println("\n====================================");
            System.out.println("      STOCK TRADING PLATFORM");
            System.out.println("====================================");
            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Portfolio Performance");
            System.out.println("6. View Balance");
            System.out.println("7. View Transaction History");
            System.out.println("8. Update Market Prices");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Invalid input! Please enter a number between 1 and 9.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

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
                    user.getPortfolio().displayPortfolio();
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
                    System.out.println("Market prices updated.");
                    break;

                case 9:
                    FileManager.saveUser(user);
                    FileManager.savePortfolio(user);
                    FileManager.saveTransactions(user);

                    System.out.println("Thank you for using Stock Trading Platform.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);

        scanner.close();
    }

    private static void buyStock(Scanner scanner, Market market, User user) {

        System.out.print("Enter Stock Symbol: ");
        String symbol = scanner.next();

        Stock stock = market.getStockBySymbol(symbol);

        if (stock == null) {
            System.out.println("Stock not found.");
            return;
        }

        System.out.print("Enter Quantity: ");

        int quantity;

        try {
            quantity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("❌ Quantity must be a whole number.");
            scanner.nextLine();
            return;
        }

        if (quantity <= 0) {
            System.out.println("❌ Quantity must be greater than zero.");
            return;
        }

        user.buyStock(stock, quantity);
    }

    private static void sellStock(Scanner scanner, Market market, User user) {

        System.out.print("Enter Stock Symbol: ");
        String symbol = scanner.next();

        Stock stock = market.getStockBySymbol(symbol);

        if (stock == null) {
            System.out.println("Stock not found.");
            return;
        }

        System.out.print("Enter Quantity: ");

        int quantity;

        try {
            quantity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("❌ Quantity must be a whole number.");
            scanner.nextLine();
            return;
        }

        if (quantity <= 0) {
            System.out.println("❌ Quantity must be greater than zero.");
            return;
        }

        user.sellStock(stock, quantity);
    }
}