/*
 * Array-Based Stack Implementation
 *
 * Author: SaptHrishi (Hrishabh Mishra)
 *
 * Built as part of my Data Structures and Algorithms (DSA) practice.
 *
 * This project demonstrates the implementation of a Stack using
 * a fixed-size array. The objective is to understand the internal
 * working of stack operations rather than relying on Java's
 * built-in collection classes.
 *
 * Features:
 *  - Push elements onto the stack
 *  - Pop elements from the stack
 *  - Peek the top element
 *  - Handle Stack Overflow
 *  - Handle Stack Underflow
 *
 * Principle Used:
 *  LIFO (Last In, First Out)
 *
 * Example:
 *  Push: 10, 20, 30
 *  Pop : 30
 *  Peek: 20
 *
 * A simple educational implementation for strengthening
 * core DSA fundamentals.
 */

import java.util.*;

class Stack{
    protected int CAPACITY;
    protected int top;
    protected int[] stack;

    public Stack(int CAP){
        this.CAPACITY = CAP;
        this.top = -1;
        this.stack = new int[CAP];
        System.out.println("[+] Stack created");
    }

    public void push(int val){
        if(top == CAPACITY -1){
            System.out.println("[-] Stack is full, cant add more elements");
            return;
        }
        this.stack[++top] = val;
        System.out.println("[+] Value Added to stack => "+ val);
    }

    public void pop(){
        if(top==-1){
            System.out.println("[-] Stack is empty");
            return;
        }
        int temp = this.stack[top];
        top--;
        System.out.println("[+] Popped value => "+ temp);
    }

    public void peek(){
       if(top==-1){
            System.out.println("[-] Stack is empty");
            return;
        } 
        System.out.println("[+] Top Value => " + this.stack[top]);
    }
}

public class StackMain {
    public static void main(String args[]){
        Stack s1 = new Stack(10);
        s1.pop();
        s1.push(10);
        s1.push(20);
         s1.push(30);
        s1.push(45);
        s1.push(67);
        s1.push(43);
         s1.push(78);
        s1.push(23);
        s1.push(43);
        s1.push(17);
         s1.push(67);
        s1.push(13);
        s1.pop();
        s1.pop();
        s1.peek();
    }
}
