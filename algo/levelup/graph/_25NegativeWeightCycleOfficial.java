import java.io.*;
import java.util.*;

public class _25NegativeWeightCycleOfficial {

	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int n = scn.nextInt();
        int[][] edges = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++) {
                edges[i][j] = scn.nextInt();
            }
        }
        System.out.println(negativeEdge(v, edges));
	}
	
	private static int negativeEdge(int n,int[][] edges) {
	    int[] path = new int[n];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[0] = 0;
	    
	    for(int[] edge : edges) {
	        int u = edge[0];
	        int v = edge[1];
	        int cost = edge[2];
	        
	        if(path[u] != Integer.MAX_VALUE && path[u] + cost < path[v]) {
	            path[v] = path[u] + cost;
	        }
	    }
	    for(int[] edge : edges) {
	        int u = edge[0];
	        int v = edge[1];
	        int cost = edge[2];
	        
	        if(path[u] != Integer.MAX_VALUE && path[u] + cost < path[v]) {
	            return 1;
	        }
	    }
	    return 0;
	}
}