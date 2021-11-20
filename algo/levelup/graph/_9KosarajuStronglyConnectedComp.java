import java.io.*;
import java.util.*;

public class _9KosarajuStronglyConnectedComp {
	public static void main(String args[]) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int v1 = scn.nextInt() - 1;
            int v2 = scn.nextInt() - 1;

            // add directed edge 
            graph.get(v1).add(v2);
        }

        int count = stronglyConnectedComp(graph);
        System.out.println(count);
	}
	private static int stronglyConnectedComp(ArrayList<ArrayList<Integer>> graph) {
	    // 1. iterate on vertex and add vertex in stack while backtracking
	    Stack<Integer> st = new Stack<>();
	    boolean[] vis = new boolean[graph.size()];
	    
	    for(int v=0; v < graph.size(); v++) {
	        if(!vis[v]) {
	            dfsForStack(graph,v,vis,st);
	        }
	    }
	    
	    // 2. reverse all edge
	    ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
	    for(int i = 0; i < graph.size(); i++) {
            revGraph.add(new ArrayList<>());
        } 
	    for(int v=0; v < graph.size(); v++) {
	        for(int u : graph.get(v)) {
	            revGraph.get(u).add(v);
	        }
	    }
	    // 3. iterate on vertex in order of stack and count number of calls
	    int count = 0;
	    vis = new boolean[graph.size()];
	    while(st.size() > 0) {
	        int top = st.pop();
	        if(!vis[top]) {
	            count++;
	            dfsForCount(revGraph,top,vis);
	        }
	    }
	    return count;
	}
	
	private static void dfsForStack(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis,Stack<Integer> st) {
	    vis[src] = true;
	    for(int nbr : graph.get(src)) {
	        if(!vis[nbr]) {
	            dfsForStack(graph,nbr,vis,st);
	        }
	    }
	    st.push(src);
	}
	
	private static void dfsForCount(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis) {
	    vis[src] = true;
	    for(int nbr : graph.get(src)) {
	        if(!vis[nbr]) {
	            dfsForCount(graph,nbr,vis);
	        }
	    }
	}

}
