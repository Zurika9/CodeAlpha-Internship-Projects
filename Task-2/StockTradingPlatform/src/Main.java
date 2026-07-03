import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Market market = new Market();
        User user = new User("Bhavya", 100000);
        FileManager.loadUser(user);
        FileManager.loadPortfolio(user, market);
        FileManager.loadTransactions(user);

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("      STOCK TRADING PLATFORM");
            System.out.println("====================================");
            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Update Market Prices");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

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
                    user.displayBalance();
                    break;

                case 6:
                    user.displayTransactionHistory();
                    break;

                case 7:
                    market.updateMarketPrices();
                    System.out.println("Market prices updated successfully.");
                    break;

                case 8:

                    FileManager.saveUser(user);
                    FileManager.savePortfolio(user);
                    FileManager.saveTransactions(user);

                    System.out.println("Thank you for using Stock Trading Platform.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

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
        int quantity = scanner.nextInt();

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
        int quantity = scanner.nextInt();

        user.sellStock(stock, quantity);
    }
}