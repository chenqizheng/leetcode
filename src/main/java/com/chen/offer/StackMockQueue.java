package com.chen.offer;

import java.util.Stack;

public class StackMockQueue {

    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();


    private void offer(int item) {
        getCurrentStack().push(item);

    }

    private Stack<Integer> getCurrentStack() {
        Stack stack = null;
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack = stack1;
        } else if (!stack1.isEmpty()) {
            stack = stack1;
        } else if (!stack2.isEmpty()) {
            stack = stack2;
        }
        return stack;
    }

    private int poll() {
        Stack<Integer> stack = getCurrentStack();
        Stack<Integer> otherStack = stack == stack1 ? stack2 : stack1;
        while (!stack.isEmpty()) {
            otherStack.push(stack.pop());
        }
        if (otherStack.isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        int result = otherStack.pop();
        while (!otherStack.isEmpty()) {
            stack.push(otherStack.pop());
        }
        return result;
    }


    public static void main(String[] args) {
        StackMockQueue stackMockQueue = new StackMockQueue();
        stackMockQueue.offer(1);
        stackMockQueue.offer(2);
        stackMockQueue.offer(3);
        stackMockQueue.offer(4);
        stackMockQueue.offer(5);
        System.out.println(stackMockQueue.poll());
        stackMockQueue.offer(6);
        System.out.println(stackMockQueue.poll());
        System.out.println(stackMockQueue.poll());
        System.out.println(stackMockQueue.poll());
        System.out.println(stackMockQueue.poll());
        System.out.println(stackMockQueue.poll());
        System.out.println(stackMockQueue.poll());
    }
}
