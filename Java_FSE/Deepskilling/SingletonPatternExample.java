public class SingletonPatternExample {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Processing user request");

        Logger logger3 = Logger.getInstance();
        logger3.log("Application shutting down");

        System.out.println();
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
        System.out.println("logger2 == logger3 ? " + (logger2 == logger3));
        System.out.println("Total log entries via logger1: " + logger1.getLogCount());
        System.out.println("Total log entries via logger3: " + logger3.getLogCount());

        if (logger1 == logger2 && logger2 == logger3 && logger1.getLogCount() == 3) {
            System.out.println("SUCCESS: Singleton pattern verified - only one Logger instance exists.");
        } else {
            System.out.println("FAILURE: More than one Logger instance was created!");
        }
    }
}
class Logger {
    private static Logger instance;
    private int logCount;
    private Logger() {
        System.out.println("[Logger] Instance created.");
        this.logCount = 0;
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
