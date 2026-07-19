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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head, slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next;
            if (fast != null) fast = fast.next;

            slow = slow.next;
        }

        ListNode curr = null, prev = null, next = slow.next;

        while (next != null) {
            prev = curr;
            curr = next;
            next = next.next;
            curr.next = prev;
        }

        ListNode head2 = curr;
        slow.next = null;

        ListNode next1 = head, next2 = head2, curr1 = null, curr2 = null;
        while(next1 != null && next2 != null) {
            curr1 = next1;
            next1 = next1.next;
            curr2 = next2;
            next2 = next2.next;

            curr1.next = curr2;
            curr2.next = next1;
        }
    }
}
