/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){return null;}
        Node res=new Node(0);
        Node restemp=res;
        Node temp=head;
        while(temp!=null){
            restemp.val=temp.val;
            if(temp.next==null){
                restemp.next=null;
            }
            else{
                restemp.next=new Node(0);
            }
            temp=temp.next;
            restemp=restemp.next;
        }

        temp=head;
        restemp=res;
        HashMap<Node,Node> map=new HashMap<>();
        while(temp!=null){
            map.put(temp,restemp);
            temp=temp.next;
            restemp=restemp.next;
        }
        temp=head;
        restemp=res;
        while(temp!=null){
            if(temp.random==null){restemp.random=null;}
            else{
                restemp.random=map.get(temp.random);
            }
            temp=temp.next;
            restemp=restemp.next;
        }
        return res;
    }
}
