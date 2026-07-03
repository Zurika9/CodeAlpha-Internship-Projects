public class Stock
{

    private String symbol;
    private String companyName;
    private double price;

    // Constructor
    public Stock(String symbol, String companyName, double price)
    {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
    }

    // Getters
    public String getSymbol()
    {
        return symbol;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public double getPrice()
    {
        return price;
    }

    // Setter for price (important for market simulation)
    public void setPrice(double price)
    {
        if (price > 0)
        {
            this.price = price;
        }
    }

    // Simulate price change (market behavior)
    public void updatePrice(double percentageChange)
    {
        this.price += this.price * percentageChange / 100;
    }

    // Display stock info
    public void displayStock()
    {
        System.out.println(symbol + " | " + companyName + " | ₹" + price);
    }

    @Override
    public String toString()
    {
        return symbol + " - " + companyName + " : ₹" + price;
    }
}