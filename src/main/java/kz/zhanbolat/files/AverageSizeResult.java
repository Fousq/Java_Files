package kz.zhanbolat.files;

public class AverageSizeResult {
    private long sum;
    private long counter;

    public void add(long size) {
        sum += size;
    }

    public void merge(AverageSizeResult result) {
        sum += result.getSum();
        counter += result.getCounter();
    }

    public void incrementCounter() {
        counter++;
    }

    public double averageSize() {
        return (sum == 0 || counter == 0) ? 0d : (double) sum / counter;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }
}
