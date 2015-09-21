package Algorithm_Part1;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	
	public static Queue<Integer> queue = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public static void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while(size-->1){
        	queue.offer(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public static void pop() {
        queue.poll();
    }

    // Get the top element.
    public static int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public static boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args){
    	MyStack stack = new MyStack();
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
    	
    	stack.pop();
    	System.out.println(stack.top());
    	
    	
    }

}
