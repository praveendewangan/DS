package practice.stackAndQueue;

import java.util.Stack;

public class _14SortAStack {
    // O(n2),O(1)
    public Stack<Integer> sort(Stack<Integer> s)
	{
	    if(s.isEmpty()) {
	        return s;
	    }
	    
	    int x = s.pop();
	    sort(s);
	    pushedInSortedForm(s,x);
        return s;
	}
	
	private void pushedInSortedForm(Stack<Integer> s,int x) {
	    if(s.isEmpty() || s.peek() < x) {
	        s.push(x);
	        return;
	    }
	    
	    int temp = s.pop();
	    pushedInSortedForm(s,x);
	    s.push(temp);
	}
}
