import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;

public class FileManager {

    private static final String PORTFOLIO_FILE = "data/portfolio.txt";
    private static final String USER_FILE = "data/user.txt";
    private static final String TRANSACTION_FILE = "data/transactions.txt";

    // Save portfolio to file
    public static void savePortfolio(User user) {

        try {
            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            FileWriter writer = new FileWriter(PORTFOLIO_FILE);

            writer.write(user.getName() + "\n");
            writer.write(user.getBalance() + "\n");

            for (Map.Entry<String, Integer> entry :
                    user.getPortfolio().getHoldings().entrySet()) {

                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            writer.close();

            System.out.println("Portfolio saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving portfolio.");
        }
    }

    // Load portfolio from file
    public static void loadPortfolio(User user, Market market) {

        try {

            File file = new File(PORTFOLIO_FILE);

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            // Skip name and balance (we'll improve this later)
            if (scanner.hasNextLine()) scanner.nextLine();
            if (scanner.hasNextLine()) scanner.nextLine();

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(",");

                String symbol = parts[0];
                int quantity = Integer.parseInt(parts[1]);

                user.getPortfolio().buyStock(symbol, quantity);
            }

            scanner.close();

            System.out.println("Portfolio loaded successfully.");

        } catch (Exception e) {

            System.out.println("Error loading portfolio.");
        }
    }

    public static void saveUser(User user)
    {

        try (FileWriter writer = new FileWriter(USER_FILE))
        {

            writer.write(user.getName() + "\n");
            writer.write(user.getBalance() + "\n");

        }
        catch (IOException e)
        {

            System.out.println("Error saving user data.");
        }
    }

    public static void loadUser(User user) {

        try {

            File file = new File(USER_FILE);

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            user.setName(scanner.nextLine());
            user.setBalance(Double.parseDouble(scanner.nextLine()));

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error loading user data.");
        }
    }

    public static void saveTransactions(User user) {

        try (FileWriter writer = new FileWriter(TRANSACTION_FILE)) {

            for (Transaction t : user.getTransactions()) {

                writer.write(
                        t.getType() + "," +
                                t.getStockSymbol() + "," +
                                t.getQuantity() + "," +
                                t.getPrice() + "," +
                                t.getDateTime() + "\n"
                );
            }

        } catch (IOException e) {

            System.out.println("Error saving transactions.");
        }
    }

    public static void loadTransactions(User user) {

        try {

            File file = new File(TRANSACTION_FILE);

            if (!file.exists())
                return;

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String[] parts = scanner.nextLine().split(",");

                Transaction transaction =
                        new Transaction(
                                parts[0],
                                parts[1],
                                Integer.parseInt(parts[2]),
                                Double.parseDouble(parts[3]),
                                LocalDateTime.parse(parts[4])
                        );

                user.addTransaction(transaction);
            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error loading transactions.");
        }
    }
}