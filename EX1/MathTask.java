public class MathTask implements Runnable {
    private final int threadId;

    public MathTask(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = 0; i < 10_000_000; i++) {
            sum += (long)(i * i * i) + (long)(i * threadId);
        }
        // Prevent JIT from optimizing the loop away
        if (sum == -1) System.out.println("never");
    }
}