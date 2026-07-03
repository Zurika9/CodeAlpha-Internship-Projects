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
    public void displayBalance()
    {
        System.out.printf("%nCurrent Balance: ₹%.2f%n", balance);
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

    public void displayTransactionHistory()
    {

        if (transactions.isEmpty())
        {
            System.out.println("\nNo transactions found.");
            return;
        }

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        for (Transaction transaction : transactions)
        {
            transaction.displayTransaction();
        }
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
}