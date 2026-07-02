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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val,b.val)
        );
        for(ListNode node : lists){
            if(node != null){
                minHeap.offer(node);
            }
        }

        ListNode res=new ListNode();
        ListNode root=res;

        while(minHeap.size() != 0){
            ListNode temp=minHeap.poll();
            root.next=temp;
            root=temp;
            if(temp.next!=null){
                minHeap.offer(temp.next);
            }
        }

        return res.next;

    }
}
