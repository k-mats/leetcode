/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
class MovingAverage {
  int[] values;
  int maxSize;
  int currentSize;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    values = new int[size];
    maxSize = size;
  }

  public double next(int val) {
    values[currentSize % maxSize] = val;
    currentSize++;
    double res = 0.0;
    int size = Math.min(maxSize, currentSize);
    for (int i = 0; i < size; i++) {
      res += (double) values[i];
    }
    return res / (double) size;
  }
}
