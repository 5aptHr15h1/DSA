/*
 *
 * Circular Queue Implementation using Arrays in Java
 *
 * Author: SaptHrishi (Hrishabh Mishra)
 *
 * This program implements a Circular Queue from scratch using a fixed-size
 * array. The circular nature of the queue allows efficient utilization of
 * array space by wrapping the front and rear indices using modulo arithmetic.
 *
 * Supported Operations:
 *
 *  * Enqueue (Add element to rear)
 *  * Dequeue (Remove element from front)
 *  * Queue Full Detection
 *  * Queue Empty Detection
 *  * Circular Traversal Logic
 *
 * Key Concepts:
 *
 *  * FIFO (First In, First Out)
 *  * Circular Queue
 *  * Array-Based Implementation
 *  * Modulo Arithmetic
 *
 * This implementation is intended for learning and practicing Data
 * Structures and Algorithms (DSA) concepts.
 *
 */

class Queue{
    protected int CAPACITY;
    protected int front;
    protected int rear;
    protected int[] queue;
    protected int size;

    public Queue(int CAP){
        this.CAPACITY = CAP;
        this.front = 0;
        this.rear = -1;
        this.queue = new int[CAPACITY];
        this.size = 0;
        System.out.println("[+] Queue Created.");
    }

    public void enqueue(int val){
        if(size == CAPACITY){
            System.out.println("[-] Queue is full.");
            return;
        }
        rear = (rear +1) % CAPACITY;
        queue[rear] = val;
        size++;
        System.out.println("[+] Element Added to queue : " + val);
    }

    public void dequeue(){
        if (size == 0){
            System.out.println("[-] Queue is empty.");
            return;
        }
        int data = queue[front];
        front = (front+1) % CAPACITY;
        size--;
        System.out.println("[+] Element removed to queue : " + data);
    }
}

public class QueueApp{
    public static void main(String args[]){
        Queue q1 = new Queue(10);
        q1.dequeue();
        q1.enqueue(5);
        q1.enqueue(10);
        q1.enqueue(52);
        q1.enqueue(13);
        q1.enqueue(12);
        q1.enqueue(16);
        q1.enqueue(45);
        q1.enqueue(98);
        q1.enqueue(43);
        q1.enqueue(23);
        q1.enqueue(76);
        q1.enqueue(65);
        q1.enqueue(78);
        q1.enqueue(48);
        q1.dequeue();
    }
}