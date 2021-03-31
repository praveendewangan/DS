package practice.stackAndQueue;

import java.util.Stack;

public class _10CelebrityProblem {
    // O(n),O(n)
    int celebrity(int M[][], int n){
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<M.length;i++) {
    	    st.push(i);
    	} 
    	while(st.size() >= 2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    if(M[i][j] == 1){
    	        st.push(j);
    	    } else {
    	        st.push(i);
    	    }
    	}
    	int pot = st.pop();
    	for(int i=0;i < M.length;i++){
    	    if(i != pot){
    	        if(M[i][pot] == 0 || M[pot][i] == 1){
    	            return -1;
    	        }
    	    }
    	}
    	return pot;
    }
}
