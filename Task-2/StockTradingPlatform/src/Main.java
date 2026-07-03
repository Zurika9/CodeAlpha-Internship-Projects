public class Main {

    public static void main(String[] args) {

        Market market = new Market();

        User user = new User("Bhavya", 100000);

        market.displayMarket();

        Stock stock = market.getStockBySymbol("TCS");

        user.buyStock(stock, 5);

        user.getPortfolio().displayPortfolio();

        user.displayBalance();

        user.sellStock(stock, 2);

        user.getPortfolio().displayPortfolio();

        user.displayBalance();
    }
}