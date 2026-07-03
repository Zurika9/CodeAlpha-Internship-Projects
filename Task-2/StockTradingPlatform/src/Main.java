public class Main {

    public static void main(String[] args) {

        Market market = new Market();

        User user = new User("Bhavya", 100000);

        market.displayMarket();

        Stock tcs = market.getStockBySymbol("TCS");
        Stock infy = market.getStockBySymbol("INFY");

        user.buyStock(tcs, 5);
        user.buyStock(infy, 3);

        user.sellStock(tcs, 2);

        user.getPortfolio().displayPortfolio();

        user.displayBalance();

        user.displayTransactionHistory();
    }
}