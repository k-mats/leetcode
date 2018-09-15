class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode answer = l3;
        boolean carry = false;

        while (l1 != null || l2 != null || carry) {
          int l1Val = 0;
          if (l1 != null) {
            l1Val = l1.val;
            l1 = l1.next;
          }
          int l2Val = 0;
          if (l2 != null) {
            l2Val = l2.val;
            l2 = l2.next;
          }
          int l3Val = l1Val + l2Val;
          if (carry) {
            l3Val += 1;
            carry = false;
          }

          if (l3Val >= 10) {
            carry = true;
            l3Val -= 10;
          }

          l3.val = l3Val;

          if (l1 != null || l2 != null || carry) {
            l3.next = new ListNode(0);
            l3 = l3.next;
          }
        }

        return answer;
    }
}
