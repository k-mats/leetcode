/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
  /**
   * Concise way
   * TC: O(n)
   * SC: O(1)
   */
   public int findCelebrity(int n) {
      int candidate = 0;
      // Step 1: Pick up the only one celebrity candidate
      for (int i = 0; i < n; i++) {
        if (i == candidate) continue;
        if (knows(candidate, i)) {
          candidate = i;
        }
      }

      // Step 2: Check if the candidate knows others with smaller index
      // knows(candidate, x) where x > candidate is already checked above
      for (int i = 0; i < candidate; i++) {
        if (knows(candidate, i)) {
          // The only candidate is not the celebrity, there are celebrities here.
          return -1;
        }
      }

      // Step 3: Check if everyone knows the candidate
      for (int i = 0; i < n; i++) {
        if (i == candidate) continue;
        if (!knows(i, candidate)) {
          return -1;
        }
      }

      return candidate;
   }
 }
