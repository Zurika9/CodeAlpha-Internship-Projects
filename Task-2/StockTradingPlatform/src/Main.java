public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock("TCS", "Tata Consultancy Services", 3500);

        stock.displayStock();

        stock.updatePrice(10); // price increases by 10%

        stock.displayStock();

        Market market = new Market();

        market.displayMarket();

        System.out.println("\nFinding INFY stock...");
        Stock s = market.getStockBySymbol("INFY");

        if (s != null)
        {
            System.out.println("Found: " + s);
        }
    }
}