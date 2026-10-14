package LinkedList;
import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int val){
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}
class Dll{
    ListNode head;
    ListNode tail;
    int size;
    void display(){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();


    }
    void addAtFirst(int val){
        ListNode a=new ListNode(val);
        if(head==null) {
            head=a;
            tail=a;
        }
        else {
            a.next = head;
            head.prev = a;
            head=a;
        }
        size++;
    }
    void addAtLast(int val){
        ListNode a=new ListNode(val);
        if(size==0){
            head=tail=a;
        }
        else{
            tail.next=a;
            a.prev=tail;
            tail=a;

        }
        size++;
    }
    void deleteFirst(){
        if(size==0) return ;
        else if(size==1){
            head=tail=null;
        }
        else {
            ListNode temp=head.next;
            temp.prev=null;
            head=temp;
        }
        size--;


    }
    void deleteLast(){
        if(size==0) return ;
        else if(size==1){
            head=tail=null;
        }
        else {
            ListNode temp=tail.prev;
            temp.next=null;
            tail=temp;
        }
        size--;


    }

}
class DoublyLinkedList{
    static void main(String[] args) {
        Dll list=new Dll();
        list.addAtFirst(10);
        list.addAtFirst(20);
        list.addAtLast(30);
        list.display();
        list.deleteFirst();

        list.display();
        list.deleteLast();

        list.display();
    }
}
