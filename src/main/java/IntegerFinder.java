import java.io.IOException;
import java.util.concurrent.Callable;

public class IntegerFinder implements Callable<Integer> {
    private Integer biggestInteger;

    public IntegerFinder(int i) {
        biggestInteger = i;
    }

    public synchronized void setBiggestInteger(Integer biggestInteger) {
        this.biggestInteger = biggestInteger;
    }

    public synchronized Integer getBiggestInteger() {
        return biggestInteger;
    }

    public synchronized Integer findNumberOfDivisors(){
        int numberOfDivisors = 0;
        for (int k = 1; k < Math.sqrt(biggestInteger); k++)
            if (biggestInteger % k == 0) {
                numberOfDivisors++;
            }
        numberOfDivisors++;

        return numberOfDivisors;
    }

    @Override
    public Integer call() throws IOException{
            return findNumberOfDivisors();
    }
}
