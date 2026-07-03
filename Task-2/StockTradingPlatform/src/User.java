import java.util.ArrayList;
import java.util.List;
public class User
{

    private String name;
    private double balance;
    private Portfolio portfolio;
    private List<Transaction> transactions;

    // Constructor
    public User(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
        this.portfolio = new Portfolio();
        this.transactions = new ArrayList<>();
    }

    // Getters
    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return balance;
    }

    public Portfolio getPortfolio()
    {
        return portfolio;
    }

    // Display user balance
    public void displayBalance() {

        ConsoleUI.printTitle("ACCOUNT BALANCE");

        System.out.printf("%-22s : ₹%,.2f%n",
                "Available Balance",
                balance);

        ConsoleUI.printDoubleLine();
    }

    // Buy stock
    public void buyStock(Stock stock, int quantity)
    {

        if (stock == null)
        {
            System.out.println("Stock not found.");
            return;
        }

        double totalCost = stock.getPrice() * quantity;

        if (totalCost > balance)
        {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= totalCost;
        portfolio.buyStock(stock.getSymbol(), quantity);

        transactions.add(
                new Transaction
                        (
                            "BUY",
                            stock.getSymbol(),
                            quantity,
                            stock.getPrice()
                        )
        );

        System.out.println("Successfully purchased " + quantity +
                " shares of " + stock.getSymbol());

        System.out.printf("Remaining Balance: ₹%.2f%n", balance);
    }

    // Sell stock
    public void sellStock(Stock stock, int quantity)
    {

        if (stock == null)
        {
            System.out.println("Stock not found.");
            return;
        }

        boolean sold = portfolio.sellStock(stock.getSymbol(), quantity);

        if (!sold)
        {
            System.out.println("You do not own enough shares.");
            return;
        }

        double amount = stock.getPrice() * quantity;
        balance += amount;

        transactions.add(
                new Transaction(
                        "SELL",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                )
        );

        System.out.println("Successfully sold " + quantity +
                " shares of " + stock.getSymbol());

        System.out.printf("Updated Balance: ₹%.2f%n", balance);
    }

    public void displayTransactionHistory() {

        if (transactions.isEmpty()) {
            System.out.println("\nNo transactions found.");
            return;
        }

        System.out.println("\n==============================================================================================");
        System.out.println("                              TRANSACTION HISTORY");
        System.out.println("==============================================================================================");

        System.out.printf(
                "%-8s %-10s %-8s %-13s %-15s %-20s%n",
                "Type",
                "Symbol",
                "Qty",
                "Price",
                "Total",
                "Date & Time"
        );

        System.out.println("----------------------------------------------------------------------------------------------");

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
        }

        System.out.println("==============================================================================================");
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void displayPortfolioPerformance(Market market) {

        double totalInvestment = 0;
        double currentValue = 0;

        System.out.println("\n========== PORTFOLIO PERFORMANCE ==========");

        System.out.printf("%-10s %-8s %-15s%n",
                "Stock",
                "Quantity",
                "Current Value");

        for (String symbol : portfolio.getHoldings().keySet()) {

            int quantity = portfolio.getHoldings().get(symbol);

            double currentPrice = market.getCurrentPrice(symbol);

            double value = quantity * currentPrice;

            currentValue += value;

            double investment = 0;

            for (Transaction t : transactions) {

                if (t.isBuyTransaction()
                        && t.getStockSymbol().equals(symbol)) {

                    investment +=
                            t.getPrice() * t.getQuantity();
                }
            }

            totalInvestment += investment;

            System.out.printf("%-10s %-8d ₹%.2f%n",
                    symbol,
                    quantity,
                    value);
        }

        System.out.println("-------------------------------------");

        System.out.printf("Investment : ₹%.2f%n", totalInvestment);

        System.out.printf("Current    : ₹%.2f%n", currentValue);

        double profit = currentValue - totalInvestment;

        if (profit >= 0)
            System.out.printf("Profit     : +₹%.2f%n", profit);
        else
            System.out.printf("Loss       : -₹%.2f%n", Math.abs(profit));
    }
}