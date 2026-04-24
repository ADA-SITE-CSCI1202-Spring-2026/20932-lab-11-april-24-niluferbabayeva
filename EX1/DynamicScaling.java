public class DynamicScaling {

    static long runWithThreads(int numThreads) throws InterruptedException {
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new MathTask(i));
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Logical processors available: " + cores);

        long time1 = runWithThreads(1);
        System.out.println("Time with  1 thread : " + time1 + " ms");

        long timeMax = runWithThreads(cores);
        System.out.println("Time with " + cores + " threads: " + timeMax + " ms");

        double speedup = (double) time1 / timeMax;
        System.out.printf("Speedup: %.2fx%n", speedup);
    }
}