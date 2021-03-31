package practice.stackAndQueue;

import java.util.Stack;

public class _21QueueUsingTwoStacks {
    // O(n),O(1)
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
	   s1.push(x);
    }
	
    
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        if(s1.size()==0) {
            return -1;
        } else if(s1.size() == 1) {
            return s1.pop();
        } else {
            while(s1.size() != 1) {
                s2.push(s1.pop());
            }
            int data = s1.pop();
            while(s2.size() != 0){
                s1.push(s2.pop());
            }
            return data;
        }
    }
}
