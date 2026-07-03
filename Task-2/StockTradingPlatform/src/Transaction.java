import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a stock trading transaction.
 * A transaction records the details of a stock purchase
 * or sale performed by the user.
 *
 * Each transaction stores the transaction type,
 * stock symbol, quantity, price, and timestamp.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public class Transaction {

    /**
     * Transaction type (BUY or SELL).
     */
    private final String type;

    /**
     * Stock symbol involved in the transaction.
     */
    private final String stockSymbol;

    /**
     * Number of shares traded.
     */
    private final int quantity;

    /**
     * Price per share at the time of transaction.
     */
    private final double price;

    /**
     * Date and time when the transaction occurred.
     */
    private final LocalDateTime dateTime;

    /**
     * Creates a new transaction using the current date and time.
     *
     * @param type Transaction type (BUY or SELL)
     * @param stockSymbol Stock symbol
     * @param quantity Number of shares
     * @param price Price per share
     */
    public Transaction(String type,
                       String stockSymbol,
                       int quantity,
                       double price) {

        this(type, stockSymbol, quantity, price, LocalDateTime.now());
    }

    /**
     * Creates a transaction with a specified timestamp.
     * Useful when loading transaction history from a file.
     *
     * @param type Transaction type
     * @param stockSymbol Stock symbol
     * @param quantity Number of shares
     * @param price Price per share
     * @param dateTime Transaction timestamp
     */
    public Transaction(String type,
                       String stockSymbol,
                       int quantity,
                       double price,
                       LocalDateTime dateTime) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.dateTime = dateTime;
    }

    /**
     * Returns the transaction type.
     *
     * @return BUY or SELL
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the stock symbol.
     *
     * @return stock symbol
     */
    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * Returns the number of shares traded.
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the price per share.
     *
     * @return stock price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the total transaction amount.
     *
     * @return quantity × price
     */
    public double getTotalAmount() {
        return quantity * price;
    }

    /**
     * Returns the transaction timestamp.
     *
     * @return transaction date and time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Checks whether this is a BUY transaction.
     *
     * @return true if BUY, otherwise false
     */
    public boolean isBuyTransaction() {
        return type.equalsIgnoreCase("BUY");
    }

    /**
     * Displays the transaction in a formatted table row.
     */
    public void displayTransaction() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        String formattedPrice = String.format("₹%,.2f", price);
        String formattedTotal = String.format("₹%,.2f", getTotalAmount());

        System.out.printf(
                "%-8s %-10s %-8d %-15s %-15s %-20s%n",
                type,
                stockSymbol,
                quantity,
                formattedPrice,
                formattedTotal,
                dateTime.format(formatter)
        );
    }

    /**
     * Returns a string representation of the transaction.
     *
     * @return formatted transaction details
     */
    @Override
    public String toString() {

        return String.format(
                "%s %d shares of %s at ₹%,.2f on %s",
                type,
                quantity,
                stockSymbol,
                price,
                dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
        );
    }
}