class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev=null;
    }
}

class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            if(n.prev==null){
                return n.val;
            }
            else if(n.next==null){
                n.prev.next=null;
                tail=n.prev;
                n.prev=null;
                n.next=head;
                head.prev=n;
                head=n;
                return n.val;
            }
            else{
                n.prev.next=n.next;
                n.next.prev=n.prev;
                n.prev=null;
                n.next=head;
                head.prev=n;
                head=n;
                return n.val;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node ad=map.get(key);
            ad.val=value;
            if(ad.prev==null){
                return;
            }

            if(ad.next==null){
                tail=ad.prev;
                tail.next=null;
            }
            else{
                ad.prev.next=ad.next;
                ad.next.prev=ad.prev;
            }

            ad.prev=null;
            ad.next=head;
            head.prev=ad;
            head=ad;
        }
        else{
            int size=map.size();
            if(size==capacity){
                map.remove(tail.key);
                if(head==tail){
                    head=null;
                    tail=null;
                }
                else{
                    tail=tail.prev;
                    tail.next=null;
                }
                if(head==null){
                    head=new Node(key,value);
                    tail=head;
                }
                else{
                    head.prev=new Node(key,value);
                    Node temp=head;
                    head=head.prev;
                    head.next=temp;
                }
                map.put(key,head);
            }
            else if(size==0){
                head=new Node(key,value);
                tail=head;
                map.put(key,head);
            }
            else{
                head.prev=new Node(key,value);
                Node temp=head;
                head=head.prev;
                head.next=temp;
                head.key=key;
                head.val=value;
                map.put(key,head);
            }

        }
    }
}
