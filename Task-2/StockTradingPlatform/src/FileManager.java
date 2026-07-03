import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

/**
 * Utility class responsible for saving and loading
 * application data from text files.
 *
 * This class manages:
 * - User information
 * - Portfolio holdings
 * - Transaction history
 *
 * Data is stored inside the "data" directory.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public final class FileManager {

    /**
     * File paths used for data persistence.
     */
    private static final String PORTFOLIO_FILE = "data/portfolio.txt";
    private static final String USER_FILE = "data/user.txt";
    private static final String TRANSACTION_FILE = "data/transactions.txt";

    /**
     * Prevent instantiation of this utility class.
     */
    private FileManager() {
    }

    /**
     * Creates the data directory if it does not already exist.
     */
    private static void createDataFolder() {

        File folder = new File("data");

        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    /**
     * Saves the user's portfolio holdings.
     *
     * @param user User whose portfolio is to be saved
     */
    public static void savePortfolio(User user) {

        createDataFolder();

        try (FileWriter writer = new FileWriter(PORTFOLIO_FILE)) {

            writer.write(user.getName() + "\n");
            writer.write(user.getBalance() + "\n");

            for (Map.Entry<String, Integer> entry :
                    user.getPortfolio().getHoldings().entrySet()) {

                writer.write(entry.getKey()
                        + ","
                        + entry.getValue()
                        + "\n");
            }

            System.out.println("✅ Portfolio saved successfully.");

        } catch (IOException e) {

            System.out.println("❌ Error saving portfolio: "
                    + e.getMessage());
        }
    }

    /**
     * Loads portfolio holdings from file.
     *
     * @param user User whose portfolio is to be restored
     */
    public static void loadPortfolio(User user) {

        File file = new File(PORTFOLIO_FILE);

        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {

                String[] parts = scanner.nextLine().split(",");

                if (parts.length != 2) {
                    continue;
                }

                String symbol = parts[0];
                int quantity = Integer.parseInt(parts[1]);

                user.getPortfolio().buyStock(symbol, quantity);
            }

            System.out.println("✅ Portfolio loaded successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error loading portfolio: "
                    + e.getMessage());
        }
    }

    /**
     * Saves user information.
     *
     * @param user User to be saved
     */
    public static void saveUser(User user) {

        createDataFolder();

        try (FileWriter writer = new FileWriter(USER_FILE)) {

            writer.write(user.getName() + "\n");
            writer.write(user.getBalance() + "\n");

            System.out.println("✅ User data saved successfully.");

        } catch (IOException e) {

            System.out.println("❌ Error saving user data: "
                    + e.getMessage());
        }
    }

    /**
     * Loads user information.
     *
     * @param user User object to populate
     */
    public static void loadUser(User user) {

        File file = new File(USER_FILE);

        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {

            if (scanner.hasNextLine()) {
                user.setName(scanner.nextLine());
            }

            if (scanner.hasNextLine()) {
                user.setBalance(
                        Double.parseDouble(scanner.nextLine()));
            }

            System.out.println("✅ User data loaded successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error loading user data: "
                    + e.getMessage());
        }
    }

    /**
     * Saves the user's transaction history.
     *
     * @param user User whose transactions are to be saved
     */
    public static void saveTransactions(User user) {

        createDataFolder();

        try (FileWriter writer = new FileWriter(TRANSACTION_FILE)) {

            for (Transaction transaction : user.getTransactions()) {

                writer.write(
                        transaction.getType() + ","
                                + transaction.getStockSymbol() + ","
                                + transaction.getQuantity() + ","
                                + transaction.getPrice() + ","
                                + transaction.getDateTime() + "\n"
                );
            }

            System.out.println("✅ Transactions saved successfully.");

        } catch (IOException e) {

            System.out.println("❌ Error saving transactions: "
                    + e.getMessage());
        }
    }

    /**
     * Loads transaction history from file.
     *
     * @param user User whose transaction history is to be restored
     */
    public static void loadTransactions(User user) {

        File file = new File(TRANSACTION_FILE);

        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {

                String[] parts = scanner.nextLine().split(",");

                if (parts.length != 5) {
                    continue;
                }

                Transaction transaction = new Transaction(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3]),
                        LocalDateTime.parse(parts[4])
                );

                user.addTransaction(transaction);
            }

            System.out.println("✅ Transactions loaded successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error loading transactions: "
                    + e.getMessage());
        }
    }
}