import java.util.LinkedHashMap;

import java.util.Map;

/**
 * Represents a user's investment portfolio.
 * Stores the stocks owned by the user along with
 * the quantity of shares for each stock.
 *
 * Provides functionality to buy, sell, and display
 * portfolio holdings.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public class Portfolio {

    /**
     * Stores stock symbol as key and
     * number of shares as value.
     */
    private final Map<String, Integer> holdings;

    /**
     * Constructs an empty portfolio.
     */
    public Portfolio() {
        holdings = new LinkedHashMap<>();
    }

    /**
     * Adds purchased shares to the portfolio.
     *
     * @param symbol   Stock symbol
     * @param quantity Number of shares purchased
     */
    public void buyStock(String symbol, int quantity) {

        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + quantity);
    }

    /**
     * Sells shares from the portfolio.
     *
     * @param symbol   Stock symbol
     * @param quantity Number of shares to sell
     * @return true if sale is successful, otherwise false
     */
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

    /**
     * Returns the number of shares owned
     * for a given stock.
     *
     * @param symbol Stock symbol
     * @return Quantity owned
     */
    public int getQuantity(String symbol) {

        return holdings.getOrDefault(symbol, 0);
    }

    /**
     * Displays the user's portfolio in a
     * formatted table showing stock symbol,
     * shares owned, current price,
     * and total value.
     *
     * @param market Market object used to
     *               retrieve current prices
     */
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

            String formattedPrice = String.format("₹%,.2f", price);
            String formattedValue = String.format("₹%,.2f", value);

            System.out.printf("%-12s %-10d %-15s %-15s%n",
                    symbol,
                    quantity,
                    formattedPrice,
                    formattedValue);
        }

        ConsoleUI.printLine();

        System.out.printf("%-39s %s%n",
                "Total Portfolio Value:",
                String.format("₹%,.2f", totalValue));

        ConsoleUI.printDoubleLine();
    }

    /**
     * Returns all portfolio holdings.
     *
     * @return Map containing stock symbols
     *         and quantities owned
     */
    public Map<String, Integer> getHoldings() {

        return holdings;
    }
}