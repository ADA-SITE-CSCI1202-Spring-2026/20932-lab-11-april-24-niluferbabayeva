package EX2;

public class SharedResource {
    private int value;
    private boolean bChanged = false;

    // Consumer calls this — waits until Producer sets a value
    public synchronized int get() {
        while (!bChanged) {
            try {
                wait(); // releases lock and waits for notify()
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        bChanged = false; // reset for next round
        return value;
    }

    // Producer calls this — sets value and wakes up Consumer
    public synchronized void set(int value) {
        this.value = value;
        bChanged = true;
        notify(); // wake up the waiting Consumer
    }
}