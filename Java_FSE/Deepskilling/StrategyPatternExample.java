public class StrategyPatternExample {

    public static void main(String[] args) {
        PaymentContext checkout = new PaymentContext(new CreditCardPayment("4111222233334444"));
        checkout.executePayment(250.00);

        // Customer switches payment method at checkout - swap the strategy, context stays the same.
        checkout.setStrategy(new PayPalPayment("mohan@example.com"));
        checkout.executePayment(89.99);
    }
}

/** Strategy interface - one algorithm "family" (how to pay), swappable at runtime. */
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        String masked = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid $" + amount + " using Credit Card ending in " + masked);
    }
}

class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

/** Context - holds a reference to whichever strategy is currently selected and delegates to it. */
class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            System.out.println("No payment method selected.");
            return;
        }
        strategy.pay(amount);
    }
}
