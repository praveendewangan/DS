import java.io.*;
import java.util.*;


public class _8MotherVertex{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> graph){
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[N];
		count = 0;
		for(int v=0; v < N; v++) {
		    if(!vis[v]){
		        dfsForStack(graph,v,vis,stack);
		    }
		}
		
		int top = stack.peek();
		vis = new boolean[N];
		dfsForCount(graph,top,vis);
		// o base indexing so top+1
		return count == N ? top+1 : -1;
   	}
   	static int count = 0;
   	
    public static void dfsForStack(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis,Stack<Integer> stack){
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(!vis[nbr]) {
		        dfsForStack(graph,nbr,vis,stack);
            }
        }
        stack.push(src);
    }
    public static void dfsForCount(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis){
        vis[src] = true;
        count++;
        for(int nbr : graph.get(src)){
            if(!vis[nbr]) {
		        dfsForCount(graph,nbr,vis);
            }
        }
    }
}


