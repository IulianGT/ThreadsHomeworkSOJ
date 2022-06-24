import java.util.concurrent.*;

public class MultithreadSolution {

    public static void main(String[] args) throws InterruptedException {

        IntegerFinder integerFinder = new IntegerFinder(0);
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer>[] results = new Future[100000];
        Integer[] integersResulted = new Integer[100000];
        int biggestNumber = 0;
        for (int i = 1; i < 100000; i++) {
            integerFinder = new IntegerFinder(i);
            results[i] = es.submit(integerFinder);
            integersResulted[i] = i;
        }


        int maxNumberOfDivisors = 0;
        int position = 1;
        for (Future<Integer> result : results) {
            try {
                int numberOfDivisors = result.get();
                if (numberOfDivisors >= maxNumberOfDivisors) {
                    maxNumberOfDivisors = numberOfDivisors;
                    biggestNumber = position;
                }
                position ++;
            } catch (Exception e) {
                Throwable functionException = e.getCause();
            }
        }

        System.out.println(biggestNumber + " with " + maxNumberOfDivisors + " divisors");

        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }
}
