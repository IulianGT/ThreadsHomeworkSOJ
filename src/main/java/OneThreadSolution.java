/*Write a program that uses multiple threads to find the integer in the range 1 to 100000 that has the largest number of divisors. The maximum number of threads to be used at the same time is 10.
        Compare the results to a single threaded solution*/

import java.util.concurrent.*;

public class OneThreadSolution {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        IntegerFinder integerFinder = new IntegerFinder(0);
        int biggestNumber=0;
        int maxNumberOfDivisors=0;
        for(int i=1;i<100000;i++){
            integerFinder = new IntegerFinder(i);
            if(integerFinder.findNumberOfDivisors() >= maxNumberOfDivisors){
                maxNumberOfDivisors = integerFinder.findNumberOfDivisors();
                biggestNumber = i;
            }
        }
        integerFinder = new IntegerFinder(biggestNumber);
        System.out.println("Result: " + biggestNumber + " with " + integerFinder.findNumberOfDivisors() + " divisors");


    }
}

