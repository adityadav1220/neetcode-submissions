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
        ArrayList<ListNode> arr=new ArrayList<>();
        ListNode temphead=head;
        while(temphead!=null){
            arr.add(temphead);
            temphead=temphead.next;
        }

        temphead=head;
        int n=0;
        boolean even=true;
        if(arr.size()%2==0){
            n=(arr.size()/2)-1;
        }
        else{
            n=(arr.size()-1)/2;
            even=false;
        }
        int i=arr.size()-1;
        ListNode tempo=temphead.next;
        while(n>0){
            ListNode x=arr.get(i);
            temphead.next=x;
            x.next=tempo;
            temphead=tempo;
            tempo=tempo.next;
            i--;
            n--;
        }
        if(even==true){tempo.next=null;}
        else{temphead.next=null;}
        
        //return head;
    }
}
