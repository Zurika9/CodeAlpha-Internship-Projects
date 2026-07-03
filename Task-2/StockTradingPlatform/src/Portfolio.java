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
    public void displayPortfolio() {

        if (holdings.isEmpty()) {
            System.out.println("\nYour portfolio is empty.");
            return;
        }

        System.out.println("\n===== YOUR PORTFOLIO =====");

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + " : "
                    + entry.getValue() + " shares");
        }
    }

    // Getter
    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }
}