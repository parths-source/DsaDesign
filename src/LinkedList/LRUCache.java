package LinkedList;
import java.util.*;
class ListNode{
    ListNode prev;
    ListNode next;
    int val;
    int key;
    public ListNode(int key,int val){
        this.val=val;
        this.next=null;
        this.prev=null;
        this.key=key;
    }

}
class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    HashMap<Integer,ListNode>map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else{
            ListNode find=map.get(key);
            movetohead(find);
            return find.val;
        }

    }

    public void put(int key, int val) {
        if (capacity == 0) return;
        ListNode add=new ListNode(key,val);
        if(map.size()==0){
            map.put(key,add);
            head=tail=add;
        }
        else if(map.containsKey(key)){
            ListNode n=map.get(key);
            n.val=val;
            movetohead(n);
        }
        else{
            if(map.size()>=capacity){
                ListNode del=tail;
                deleteNode(del);
                map.remove(del.key);
            }
            map.put(key,add);
            addtohead(add);

        }

    }
    public void addtohead(ListNode temp){
        if(head==null) head=tail=temp;
        else{
            temp.next=head;
            head.prev=temp;
            head=temp;
        }
    }
    public void movetohead(ListNode temp){
        deleteNode(temp);
        addtohead(temp);

    }
    public void deleteNode(ListNode temp){
        if(temp==head){
            head=temp.next;
        }
        if(temp==tail){
            tail=temp.prev;
        }
        if(temp.prev!=null) temp.prev.next=temp.next;
        if(temp.next!=null) temp.next.prev=temp.prev;
        temp.prev=null;
        temp.next=null;


    }
}