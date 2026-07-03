/**
 * Represents a user of the Stock Trading Platform.
 *
 * A user maintains an account balance, a portfolio
 * of owned stocks, and a transaction history.
 *
 * The class provides operations for buying and
 * selling stocks, viewing account details, and
 * tracking portfolio performance.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
public class User
{

    private String name;
    private double balance;
    private final Portfolio portfolio;
    private final List<Transaction> transactions;

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

        System.out.printf(
                "✅ Successfully purchased %d shares of %s.%n",
                quantity,
                stock.getSymbol());

        System.out.printf("Remaining Balance: ₹%,.2f%n", balance);
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

        System.out.printf(
                "✅ Successfully sold %d shares of %s.%n",
                quantity,
                stock.getSymbol());

        System.out.printf("Updated Balance: ₹%,.2f%n", balance);
    }

    public void displayTransactionHistory() {

        if (transactions.isEmpty()) {
            System.out.println("\nNo transactions found.");
            return;
        }

        ConsoleUI.printTitle("TRANSACTION HISTORY");

        System.out.printf(
                "%-8s %-10s %-8s %-13s %-15s %-20s%n",
                "Type",
                "Symbol",
                "Qty",
                "Price",
                "Total",
                "Date & Time"
        );

        ConsoleUI.printLine();

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
        }

        ConsoleUI.printDoubleLine();
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

        ConsoleUI.printTitle("PORTFOLIO PERFORMANCE");

        System.out.printf("%-12s %-10s %-18s%n",
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

            System.out.printf("%-12s %-10d %-18s%n",
                    symbol,
                    quantity,
                    String.format("₹%,.2f", value));
        }

        ConsoleUI.printLine();

        System.out.printf("Investment : %s%n",
                String.format("₹%,.2f", totalInvestment));

        System.out.printf("Current    : %s%n",
                String.format("₹%,.2f", currentValue));

        double profit = currentValue - totalInvestment;

        if (profit >= 0)
            System.out.printf("Profit     : +%s%n",
                    String.format("₹%,.2f", profit));
        else
            System.out.printf("Loss       : -%s%n",
                    String.format("₹%,.2f", Math.abs(profit)));

        ConsoleUI.printDoubleLine();
    }

}