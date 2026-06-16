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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resHead=new  ListNode();
        ListNode tempHead=resHead;
        if(list1==null){return list2;}
        if(list2==null){return list1;}
        while(list1!=null || list2!=null){
            if(list1==null){break;}
            if(list2==null){break;}
            ListNode temp=new ListNode();
            if(list1.val<list2.val){
                temp.val=list1.val;
                list1=list1.next;
            }
            else{
                temp.val=list2.val;
                list2=list2.next;
            }
            tempHead.next=temp;
            tempHead=temp;
        }
        if(list1!=null){
            while(list1!=null){
                ListNode temp=new ListNode();
                temp.val=list1.val;
                list1=list1.next;
                tempHead.next=temp;
                tempHead=temp;
            }
        }
        if(list2!=null){
            while(list2!=null){
                ListNode temp=new ListNode();
                temp.val=list2.val;
                list2=list2.next;
                tempHead.next=temp;
                tempHead=temp;
            }
        }        
        return resHead.next;
    }
}