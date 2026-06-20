public class AdapterPatternExample {

    public static void main(String[] args) {
        PaymentProcessor viaPayPal = new PayPalAdapter(new PayPalGateway());
        System.out.println(viaPayPal.processPayment(8300.0));

        PaymentProcessor viaStripe = new StripeAdapter(new StripeGateway());
        System.out.println(viaStripe.processPayment(4150.0));
    }
}
interface PaymentProcessor {
    String processPayment(double amountInRupees);
}
class PayPalGateway {
    public String sendPaymentInDollars(double amountInDollars) {
        return "PayPal: paid $" + amountInDollars;
    }
}
class StripeGateway {
    public String chargeCard(double amountInCents) {
        return "Stripe: charged " + (long) amountInCents + " cents";
    }
}

class PayPalAdapter implements PaymentProcessor {

    private static final double RUPEES_TO_DOLLARS = 83.0;
    private final PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String processPayment(double amountInRupees) {
        double dollars = amountInRupees / RUPEES_TO_DOLLARS;
        return gateway.sendPaymentInDollars(Math.round(dollars * 100.0) / 100.0);
    }
}
class StripeAdapter implements PaymentProcessor {

    private static final double RUPEES_TO_DOLLARS = 83.0;
    private final StripeGateway gateway;

    public StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String processPayment(double amountInRupees) {
        double cents = (amountInRupees / RUPEES_TO_DOLLARS) * 100.0;
        return gateway.chargeCard(cents);
    }
}
