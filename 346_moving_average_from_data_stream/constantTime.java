/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
class MovingAverage {
  int[] values;
  int maxSize;
  int currentSize;
  long sum;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    values = new int[size];
    maxSize = size;
  }

  public double next(int val) {
    int index = currentSize % maxSize;
    sum -= values[index];
    sum += val;
    values[index] = val;
    currentSize++;
    return (double) sum / (double) Math.min(currentSize, maxSize);
  }
}
