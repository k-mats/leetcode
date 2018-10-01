/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
  /**
   * Dirty way
   * TC: O(n^2)
   * SC: O(n)
   */
  public int findCelebrity(int n) {
    // 0: Initial status: Not verified yet
    // 1: Known from everyone asked by `knows` so far
    // 2: Not known at least one person
    int[] known = new int[n];
    Set<Integer> celebrityCandidates = new HashSet<>();

    for (int i = 0; i < n; i++) {
      int[] newKnown = new int[n];
      System.arraycopy(known, 0, newKnown, 0, known.length);
      // Check the possibility of the celebrity
      // If the persion i doesn't know anyone, he/she may be the celebrity,
      // so we must not update `known` array by `newKnown`
      boolean atLeastOneKnown = false;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        } else {
          if (knows(i, j)) {
            atLeastOneKnown = true;
            if (newKnown[j] == 0) {
              newKnown[j] = 1;
            } else if (newKnown[j] == 1) {
              // do nothing; the j may be the celebrity
            } else if (newKnown[j] == 2) {
              // do nothing
            }
          } else {
            newKnown[j] = 2;
          }
        }
      }
      if (atLeastOneKnown) {
        known = newKnown;
      } else {
        celebrityCandidates.add(i);
      }
    }

    for (int i = 0; i < n; i++) {
      if (known[i] == 1 && celebrityCandidates.contains(i)) {
        return i;
      }
    }
    return -1;
  }
}
