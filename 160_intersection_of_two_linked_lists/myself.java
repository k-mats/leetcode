public class Solution {
  /**
   * Simple solution: Use set to search headA nodes
   * Time: O(n + mlogn)
   * Space: O(n)
   * where headA's size: n, headB's size: m
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set set = new HashSet<ListNode>();
    while (headA != null) {
      set.add(headA);
      headA = headA.next;
    }

    while (headB != null) {
      if (set.contains(headB)) {
        return headB;
      }
      headB = headB.next;
    }

    return null;
  }

  /**
   * Better solution: Trace lists twice then can ignore the difference of length
   * Time: O(n)
   * Space: O(1)
   */
    if (headA == null || headB == null) {
      return null;
    }

    ListNode x = headA;
    ListNode y = headB;

    while (x != y) {
      if (x != null) {
        x = x.next;
      } else {
        x = headB;
      }
      if (y != null) {
        y = y.next;
      } else {
        y = headA;
      }
    }
    return x;
  }
}
