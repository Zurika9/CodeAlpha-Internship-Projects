import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class FileManager {

    private static final String PORTFOLIO_FILE = "data/portfolio.txt";

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
}