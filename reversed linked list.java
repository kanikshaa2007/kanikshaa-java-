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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode bst = null;
        ListNode st = head;
        int pos = 1;

        while (pos < left) {
            bst = st;
            st = st.next;
            pos++;
        }

        ListNode end = st;
        while (pos < right) {
            end = end.next;
            pos++;
        }

        ListNode endNext = end.next;

        ListNode prev = null;
        ListNode curr = st;

        // 🔑 THIS LOOP IS CRITICAL
        while (curr != endNext) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (bst != null) bst.next = end;
        else head = end;

        st.next = endNext;

        return head;
    }
}
