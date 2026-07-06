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
    public ListNode reverseKGroup(ListNode head, int k) {
        int no = count(head);
        int itr = no / k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (itr > 0) {
            ListNode groupStart = groupPrev.next;

            ListNode groupNext = groupStart;
            for (int i = 0; i < k; i++) {
                groupNext = groupNext.next;
            }

            ListNode prev = groupNext;
            ListNode root = groupStart;

            int grp = k;
            while (grp > 0) {
                ListNode temp = root.next;
                root.next = prev;
                prev = root;
                root = temp;
                grp--;
            }

            groupPrev.next = prev;

            groupPrev = groupStart;

            itr--;
        }

        return dummy.next;
    }

    public int count(ListNode root) {
        int nodes = 0;

        while (root != null) {
            nodes++;
            root = root.next;
        }

        return nodes;
    }
}