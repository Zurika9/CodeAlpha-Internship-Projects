/**
 * Represents a stock available in the stock market.
 * Stores the stock symbol, company name, and current market price.
 *
 * This class also provides functionality to update stock prices
 * and display stock information in a formatted manner.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public class Stock {

    /**
     * Unique stock symbol (e.g., TCS, INFY).
     * Immutable after object creation.
     */
    private final String symbol;

    /**
     * Company name associated with the stock.
     * Immutable after object creation.
     */
    private final String companyName;

    /**
     * Current market price of the stock.
     */
    private double price;

    /**
     * Constructs a Stock object.
     *
     * @param symbol       Stock symbol
     * @param companyName  Company name
     * @param price        Initial market price
     */
    public Stock(String symbol, String companyName, double price) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
    }

    /**
     * Returns the stock symbol.
     *
     * @return stock symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the company name.
     *
     * @return company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Returns the current stock price.
     *
     * @return current market price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Updates the stock price.
     * The price is updated only if the new value is positive.
     *
     * @param price new stock price
     */
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    /**
     * Updates the stock price based on a percentage change.
     * Positive values increase the price, while negative values decrease it.
     * Ensures that the stock price never falls below ₹1.00.
     *
     * Example:
     * Current Price = ₹1000
     * Percentage Change = +5%
     * New Price = ₹1050
     *
     * @param percentageChange percentage increase or decrease
     */
    public void updatePrice(double percentageChange) {

        double newPrice = price + (price * percentageChange / 100);

        // Prevent invalid stock prices
        if (newPrice < 1) {
            newPrice = 1;
        }

        price = newPrice;
    }

    /**
     * Displays formatted stock details.
     */
    public void displayStock() {

        System.out.printf("%-12s %-35s ₹%,.2f%n",
                symbol,
                companyName,
                price);
    }

    /**
     * Returns a formatted string representation of the stock.
     *
     * @return formatted stock information
     */
    @Override
    public String toString() {

        return String.format("%s - %s (₹%,.2f)",
                symbol,
                companyName,
                price);
    }
}