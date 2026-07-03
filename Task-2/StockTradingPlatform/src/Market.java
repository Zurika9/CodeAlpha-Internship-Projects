import java.util.ArrayList;
import java.util.List;

public class Market {

    private List<Stock> stocks;

    // Constructor → initialize market
    public Market() {
        stocks = new ArrayList<>();
        loadDefaultStocks();
    }

    // Add some dummy stocks (market data)
    private void loadDefaultStocks() {
        stocks.add(new Stock("TCS", "Tata Consultancy Services", 3500));
        stocks.add(new Stock("INFY", "Infosys", 1600));
        stocks.add(new Stock("WIPRO", "Wipro", 500));
        stocks.add(new Stock("HCL", "HCL Technologies", 1400));
        stocks.add(new Stock("RELIANCE", "Reliance Industries", 2800));
    }

    // Display all stocks
    public void displayMarket() {

        ConsoleUI.printTitle("STOCK MARKET");

        System.out.printf("%-12s %-35s %-12s%n",
                "Symbol",
                "Company",
                "Price");

        ConsoleUI.printLine();

        for (Stock stock : stocks) {

            System.out.printf("%-12s %-35s ₹%,.2f%n",
                    stock.getSymbol(),
                    stock.getCompanyName(),
                    stock.getPrice());
        }

        ConsoleUI.printDoubleLine();
    }

    // Find stock by symbol (VERY IMPORTANT for buy/sell)
    public Stock getStockBySymbol(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null; // not found
    }

    // Optional: simulate market fluctuation
    public void updateMarketPrices() {
        for (Stock stock : stocks) {
            double change = (Math.random() * 10) - 5; // -5% to +5%
            stock.updatePrice(change);
        }
    }

    public double getCurrentPrice(String symbol) {

        Stock stock = getStockBySymbol(symbol);

        if (stock != null) {
            return stock.getPrice();
        }

        return 0;
    }
}