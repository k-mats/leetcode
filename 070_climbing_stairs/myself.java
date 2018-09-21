/**
 * Recursion + Memoization
 */
class Solution {
  Map<Integer, Integer> map = new HashMap<>();

  public int climbStairs(int n) {
    if (n == 1) {
      map.put(1, 1);
      return 1;
    }
    if (n == 2) {
      map.put(2, 2);
      return 2;
    }

    int n1 = 0;
    int n2 = 0;
    if (map.get(n - 1) != null) {
      n1 = map.get(n - 1);
    } else {
      n1 = climbStairs(n - 1);
      map.put(n - 1, n1);
    }
    if (map.get(n - 2) != null) {
      n2 = map.get(n - 2);
    } else {
      n2 = climbStairs(n - 2);
      map.put(n - 2, n2);
    }

    return n1 + n2;
  }
}
