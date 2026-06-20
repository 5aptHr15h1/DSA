/*

* Singly Linked List Implementation in Java
*
* Author: SaptHrishi (Hrishabh Mishra)
*
* This program implements a Singly Linked List from scratch without using
* Java's built-in LinkedList class. It supports common linked list operations:
*
* * Insert at the beginning
* * Insert at the end
* * Insert at a specific position
* * Delete by position
* * Delete by value
* * Search for an element
* * Display the linked list
*
* This implementation is intended for learning and practicing Data Structures
* and Algorithms (DSA) concepts.
  */


import java.util.*;

class LinkNode{
    private int data;
    private LinkNode next;

    public LinkNode(int data){
        this.data = data;
        this.next = null;
    }

    public void setData(int d){
        this.data = d;
    }
    public int getData(){
        return this.data;
    }
    public void setNext(LinkNode node){
        this.next = node;
    }
    public LinkNode getNext(){
        return this.next;
    }
}

class LinkedList{
    private LinkNode head;
    private int length;

    public LinkedList(){
        head = null;
        length = 0;
    }

    public void insertAtTheBeginning(int data){
        LinkNode node = new LinkNode(data);

        if(head==null){
            head = node;
            length++;
            System.out.println("[+] LinkedList created");
            System.out.println("[+] New node added in the beginning");
            return;
        }

        node.setNext(head);
        head = node;
        length++;
        System.out.println("[+] New node added in the beginning");
    }

    public void insertAtTheEnd(int data){
        LinkNode node = new LinkNode(data);

        if(head == null){
            head = node;
            length++;
            System.out.println("[+] LinkedList created");
            return;
        }

        LinkNode temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(node);
        length++;
        System.out.println("[+] New node added at the end");
    }

    public void insertAtPosition(int data,int position){
        if(head == null || position <= 1){
            System.out.println("[+] Element added as the first element");
            insertAtTheBeginning(data);
            return;
        }
        if (position > (length+1)){
            System.out.println("[-] Position does not exist");
            System.out.println("[+] Adding as the last element of the list");
            insertAtTheEnd(data);
            return;
        }
        LinkNode node = new LinkNode(data);
        LinkNode temp = head;
        int j=1;
        while(j<position-1){
            temp = temp.getNext();
            j++;
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
        length++;
        System.out.println("[+] Node added at position "+ position);
    }

    public void deleteByPosition(int position){
        if(head == null){
            return;
        }
        if(position < 1 || position > length){
            System.out.println("[-] Invalid Position");
            return;
        }
        if (position == 1){
            head = head.getNext();
            length--;
            System.out.println("[+] Element Deleted from index" + position);
            return;
        }

        LinkNode temp = head;
        int count = 1;
        while(count < (position-1)){
            temp = temp.getNext();
            count++;
        }
        temp.setNext(temp.getNext().getNext());
        length --;
        System.out.println("[+] Element Deleted from index" + position);
    }

    public void deleteByValue(int val){
        if (head == null){
            System.out.println("[-] Linked List has no elements");
            return;
        }
        if(head.getData() == val){
            head = head.getNext();
            length--;
            System.out.println("[+] Element Deleted with value" + val);
            return;
        }
        LinkNode temp = head;
        while(temp.getNext()!=null && temp.getNext().getData() != val ){
            temp = temp.getNext();
        }
        if(temp.getNext() == null){
            System.out.println("[-] Element not found");
            return;
        }
        temp.setNext(temp.getNext().getNext());
        length --;
        System.out.println("[+] Element Deleted with value" + val);
    }

    public void searchValue(int val){
        LinkNode temp = head;

        while(temp != null){
            if(temp.getData() == val){
                System.out.println("[+] Element found");
                return;
            }
            temp = temp.getNext();
        }

        System.out.println("[-] Element not found");
        return;
    }

    public void display(){
        if (head == null){
            System.out.println("[-] Linked List has no elements");
            return;
        }
        LinkNode temp = head;
        System.out.print("[+] Linked list : ");
        while(temp != null){
            System.out.print(temp.getData() + " --> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }
}

public class LinkedListApp{
    public static void main(String args[]){
        LinkedList l1 = new LinkedList();
        l1.insertAtTheBeginning(48);
        l1.insertAtTheBeginning(52);
        l1.insertAtTheEnd(46);
        l1.insertAtTheEnd(47);
        l1.insertAtPosition(32,1);
        l1.insertAtPosition(45,9);
        l1.insertAtPosition(56,3);
        l1.deleteByPosition(4);
        l1.deleteByValue(47);
        l1.searchValue(32);
        l1.display();
    }
}