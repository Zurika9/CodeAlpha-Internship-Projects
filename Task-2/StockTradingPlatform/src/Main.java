public class Main {

    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio();

        portfolio.buyStock("TCS", 5);
        portfolio.buyStock("INFY", 2);
        portfolio.buyStock("TCS", 3);

        portfolio.displayPortfolio();

        portfolio.sellStock("TCS", 4);

        System.out.println();

        portfolio.displayPortfolio();
    }
}