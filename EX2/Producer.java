package EX2;

public class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.set(i);
            System.out.println("Producer set: " + i);
            try {
                Thread.sleep(500); // simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}