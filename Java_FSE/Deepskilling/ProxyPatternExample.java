public class ProxyPatternExample {

    public static void main(String[] args) {
        Image photo1 = new ProxyImage("sunset.jpg");
        Image photo2 = new ProxyImage("mountains.jpg");

        System.out.println("-- First display of sunset.jpg --");
        photo1.display(); // triggers a real download

        System.out.println();
        System.out.println("-- First display of mountains.jpg --");
        photo2.display(); // triggers a real download

        System.out.println();
        System.out.println("-- Second display of sunset.jpg --");
        photo1.display(); // served from cache, no download

        System.out.println();
        System.out.println("-- Requesting sunset.jpg again via a new proxy --");
        Image photo1Again = new ProxyImage("sunset.jpg");
        photo1Again.display(); // still served from cache
    }
}

/** Subject interface implemented by both the real image and its proxy. */
interface Image {
    void display();
}

/** Real subject. Loading from the "remote server" is expensive, so it only happens once, at construction. */
class RealImage implements Image {

    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Downloading " + fileName + " from remote server...");
        try {
            Thread.sleep(300); // simulate network latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(fileName + " downloaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

/**
 * Proxy that defers creating the expensive RealImage until display() is actually called
 * (lazy initialization), and reuses already-loaded images instead of re-downloading them (caching).
 */
class ProxyImage implements Image {

    // Shared cache so repeated requests for the same file don't hit the "server" again.
    private static final java.util.Map<String, RealImage> CACHE = new java.util.HashMap<>();

    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        RealImage realImage = CACHE.get(fileName);
        if (realImage == null) {
            realImage = new RealImage(fileName);
            CACHE.put(fileName, realImage);
        } else {
            System.out.println(fileName + " served from cache (no download needed).");
        }
        realImage.display();
    }
}
