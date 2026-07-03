public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock("TCS", "Tata Consultancy Services", 3500);

        stock.displayStock();

        stock.updatePrice(10); // price increases by 10%

        stock.displayStock();
    }
}