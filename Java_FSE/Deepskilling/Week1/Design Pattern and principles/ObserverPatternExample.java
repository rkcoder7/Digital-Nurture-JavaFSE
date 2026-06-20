public class ObserverPatternExample {

    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("Mohan");
        Observer web = new WebApp("SESSION-42");

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setStockPrice("INFY", 1525.50);
        market.setStockPrice("TCS", 3789.10);

        System.out.println("\n[Test] Deregistering the WebApp observer...");
        market.deregisterObserver(web);

        market.setStockPrice("INFY", 1532.75);
    }
}
interface Observer {
    void update(String stockSymbol, double newPrice);
}

/** Subject interface: lets observers register/deregister, and defines how they get notified. */
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

/** Concrete subject - holds the current prices and pushes updates to every registered observer. */
class StockMarket implements Stock {

    private final java.util.List<Observer> observers = new java.util.ArrayList<>();
    private String lastUpdatedSymbol;
    private double lastUpdatedPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(lastUpdatedSymbol, lastUpdatedPrice);
        }
    }

    /** Called whenever a price changes; updates state then pushes the change to all observers. */
    public void setStockPrice(String stockSymbol, double newPrice) {
        this.lastUpdatedSymbol = stockSymbol;
        this.lastUpdatedPrice = newPrice;
        System.out.println("\n[StockMarket] " + stockSymbol + " price changed to $" + newPrice);
        notifyObservers();
    }
}

class MobileApp implements Observer {

    private final String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.println("[MobileApp - " + userName + "] Push notification: "
                + stockSymbol + " is now $" + newPrice);
    }
}

class WebApp implements Observer {

    private final String sessionId;

    public WebApp(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.println("[WebApp - session " + sessionId + "] Live ticker updated: "
                + stockSymbol + " -> $" + newPrice);
    }
}
