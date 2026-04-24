package EX2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(new Producer(resource));
        Thread consumer = new Thread(new Consumer(resource));

        consumer.start(); // start consumer first — it will wait
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("Done.");
    }
}
