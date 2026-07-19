/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next =  head;
        ListNode i = dummy, j = dummy;

        for (int k = 0; k <= n; k++) {
            j = j.next;
        }

        while(j != null) {
            j = j.next;
            i = i.next;
        }

        i.next = i.next.next;

        return dummy.next;
    }
}
