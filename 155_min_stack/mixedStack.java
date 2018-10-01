/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {
  /** initialize your data structure here. */
  Stack<Integer> stack;
  int min = Integer.MAX_VALUE;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int x) {
    // Record the history of min too in the same stack
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    // Pop twice and update min back if we find the history of min
    if (stack.pop() == min) {
      min = stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
