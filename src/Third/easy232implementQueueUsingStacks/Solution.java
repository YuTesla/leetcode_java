package Third.easy232implementQueueUsingStacks;

import java.util.Stack;

public class Solution {
    class MyQueue {
        public Stack<Integer> s1;
        public Stack<Integer> s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1=new Stack<Integer>();
            s2=new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty()&&s2.isEmpty();
        }
    }

}
