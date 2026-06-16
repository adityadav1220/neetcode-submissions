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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode();
        boolean add=false;
        ListNode h1=l1;
        ListNode h2=l2;
        ListNode hr=res;
        int sum=0;
        while(h1!=null && h2!=null){
            sum=h1.val+h2.val;
            if(add==true){sum=sum+1;}
            hr.val=sum%10;
            if(sum>9){add=true;}
            else{add=false;}

            if(h1.next!=null && h2.next!=null){
                hr.next=new ListNode();
                hr=hr.next;
            }
            else{
                hr.next=null;
            }
            h1=h1.next;
            h2=h2.next;
        }
        if(h1==null && h2==null && add==true){
            hr.next=new ListNode(1);
            hr=hr.next;
            add=false;
        }
        else if(h1!=null && h2==null){
            while(h1!=null){
                if(add==true){
                    sum=h1.val+1;
                    hr.next=new ListNode(sum%10);
                    if(sum>9){add=true;}
                    else{add=false;}
                }
                else{
                    hr.next=new ListNode(h1.val);
                }
                h1=h1.next;
                hr=hr.next;
            }
        }
        else if(h2!=null && h1==null){
            while(h2!=null){
                if(add==true){
                    sum=h2.val+1;
                    hr.next=new ListNode(sum%10);
                    if(sum>9){add=true;}
                    else{add=false;}
                }
                else{
                    hr.next=new ListNode(h2.val);
                }
                h2=h2.next;
                hr=hr.next;
            }
        }
        if(add==true){hr.next=new ListNode(1);}
        return res;
    }
}
