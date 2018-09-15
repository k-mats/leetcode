class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    boolean allNull = true;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        allNull = false;
        break;
      }
    }
    if (allNull) {
      return null;
    }

    ListNode l = new ListNode(0);
    ListNode answer = l;
    ListNode prevL = null;

    while (true) {
      boolean minFound = false;
      int minVal = Integer.MAX_VALUE;
      int minListIndex = 0;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null && lists[i].val < minVal) {
          minFound = true;
          minVal = lists[i].val;
          minListIndex = i;
        }
      }

      if (minFound) {
        l.val = minVal;
        l.next = new ListNode(0);
        prevL = l;
        l = l.next;
        lists[minListIndex] = lists[minListIndex].next;
      } else {
        prevL.next = null;
        return answer;
      }
    }
  }
}
