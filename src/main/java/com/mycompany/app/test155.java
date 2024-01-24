package com.mycompany.app;

import java.util.Deque;
import java.util.LinkedList;

public class test155 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public test155() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.add(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
