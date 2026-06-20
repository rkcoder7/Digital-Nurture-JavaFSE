public class DecoratorPatternExample {

    public static void main(String[] args) {
        System.out.println("-- Email only --");
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Server CPU usage above 90%");

        System.out.println();
        System.out.println("-- Email + SMS --");
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSms.send("Database backup failed");

        System.out.println();
        System.out.println("-- Email + SMS + Slack --");
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        allChannels.send("Production deployment completed");
    }
}

/** Component interface shared by the base notifier and every decorator. */
interface Notifier {
    void send(String message);
}

/** Concrete component - the base behaviour that decorators will add functionality on top of. */
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

/**
 * Abstract decorator. Wraps another Notifier and delegates to it,
 * so concrete decorators only need to add their own extra behaviour.
 */
abstract class NotifierDecorator implements Notifier {

    protected final Notifier wrappedNotifier;

    protected NotifierDecorator(Notifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SLACK message: " + message);
    }
}
