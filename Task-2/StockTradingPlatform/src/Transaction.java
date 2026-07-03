import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private LocalDateTime dateTime;

    public Transaction(String type, String stockSymbol, int quantity, double price) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.dateTime = LocalDateTime.now();
    }

    public Transaction(String type,
                       String stockSymbol,
                       int quantity,
                       double price,
                       LocalDateTime dateTime) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalAmount() {
        return quantity * price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void displayTransaction() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("--------------------------------------");
        System.out.println("Type      : " + type);
        System.out.println("Stock     : " + stockSymbol);
        System.out.println("Quantity  : " + quantity);
        System.out.printf("Price     : ₹%.2f%n", price);
        System.out.printf("Total     : ₹%.2f%n", getTotalAmount());
        System.out.println("Time      : " + dateTime.format(formatter));
    }

    public boolean isBuyTransaction() {
        return type.equalsIgnoreCase("BUY");
    }
}