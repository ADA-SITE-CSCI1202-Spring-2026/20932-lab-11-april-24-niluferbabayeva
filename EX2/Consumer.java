package EX2;

public class Consumer implements Runnable {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int val = resource.get(); // blocks until Producer notifies
            System.out.println("Consumer got: " + val);
        }
    }
}
