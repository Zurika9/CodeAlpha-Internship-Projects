import java.util.ArrayList;
import java.util.List;

/**
 * Represents the stock market.
 * Maintains a list of available stocks and provides
 * operations to display stocks, search for stocks,
 * and simulate market price fluctuations.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public class Market {

    /**
     * List of stocks available in the market.
     */
    private final List<Stock> stocks;

    /**
     * Constructs a Market object and loads the default stocks.
     */
    public Market() {
        stocks = new ArrayList<>();
        loadDefaultStocks();
    }

    /**
     * Loads predefined stocks into the market.
     * These stocks are available for trading when
     * the application starts.
     */
    private void loadDefaultStocks() {

        stocks.add(new Stock("TCS", "Tata Consultancy Services", 3500));
        stocks.add(new Stock("INFY", "Infosys", 1600));
        stocks.add(new Stock("WIPRO", "Wipro", 500));
        stocks.add(new Stock("HCL", "HCL Technologies", 1400));
        stocks.add(new Stock("RELIANCE", "Reliance Industries", 2800));
    }

    /**
     * Displays all available market stocks
     * in a formatted table.
     */
    public void displayMarket() {

        ConsoleUI.printTitle("STOCK MARKET");

        System.out.printf("%-12s %-35s %-12s%n",
                "Symbol",
                "Company",
                "Price");

        ConsoleUI.printLine();

        for (Stock stock : stocks) {
            stock.displayStock();
        }

        ConsoleUI.printDoubleLine();
    }

    /**
     * Searches for a stock using its symbol.
     *
     * @param symbol Stock symbol
     * @return Stock object if found, otherwise null
     */
    public Stock getStockBySymbol(String symbol) {

        for (Stock stock : stocks) {

            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }

        return null;
    }

    /**
     * Simulates market fluctuations by changing
     * each stock price randomly between -5% and +5%.
     */
    public void updateMarketPrices() {

        for (Stock stock : stocks) {

            double percentageChange = (Math.random() * 10) - 5;

            stock.updatePrice(percentageChange);
        }
    }

    /**
     * Returns the current market price of a stock.
     *
     * @param symbol Stock symbol
     * @return Current stock price or 0 if not found
     */
    public double getCurrentPrice(String symbol) {

        Stock stock = getStockBySymbol(symbol);

        return (stock != null) ? stock.getPrice() : 0;
    }
}