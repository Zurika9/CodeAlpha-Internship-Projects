import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private HashMap<String, Integer> holdings;

    // Constructor
    public Portfolio() {
        holdings = new HashMap<>();
    }

    // Buy stock
    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + quantity);
    }

    // Sell stock
    public boolean sellStock(String symbol, int quantity) {

        if (!holdings.containsKey(symbol)) {
            return false;
        }

        int currentQuantity = holdings.get(symbol);

        if (quantity > currentQuantity) {
            return false;
        }

        if (quantity == currentQuantity) {
            holdings.remove(symbol);
        } else {
            holdings.put(symbol, currentQuantity - quantity);
        }

        return true;
    }

    // Get quantity of a stock
    public int getQuantity(String symbol) {
        return holdings.getOrDefault(symbol, 0);
    }

    // Display portfolio
    public void displayPortfolio(Market market) {

        ConsoleUI.printTitle("YOUR PORTFOLIO");

        if (holdings.isEmpty()) {
            System.out.println("📭 Your portfolio is empty.");
            ConsoleUI.printDoubleLine();
            return;
        }

        System.out.printf("%-12s %-10s %-15s %-15s%n",
                "Stock",
                "Shares",
                "Price (₹)",
                "Value (₹)");

        ConsoleUI.printLine();

        double totalValue = 0;

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            String symbol = entry.getKey();
            int quantity = entry.getValue();

            double price = market.getCurrentPrice(symbol);
            double value = quantity * price;

            totalValue += value;

            System.out.printf("%-12s %-10d ₹%-14,.2f ₹%-14,.2f%n",
                    symbol,
                    quantity,
                    price,
                    value);
        }

        ConsoleUI.printLine();

        System.out.printf("%-39s ₹%,.2f%n",
                "Total Portfolio Value:",
                totalValue);

        ConsoleUI.printDoubleLine();
    }

    // Getter
    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }
}