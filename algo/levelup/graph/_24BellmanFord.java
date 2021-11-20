import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _24BellmanFord {
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
        int[] ans = bellmanFord(v, edges);
        for(int i=1; i < ans.length; i++){
            if(ans[i] != Integer.MAX_VALUE)
                System.out.print(ans[i] + " ");
        }
        System.out.println();
	}
	
	private static int[] bellmanFord(int n,int[][] edges) {
	    int[] path = new int[n];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[0] = 0;
	    
	    for(int[] edge : edges) {
	        int u = edge[0]-1;
	        int v = edge[1]-1;
	        int cost = edge[2];
	        
	        if(path[u] != Integer.MAX_VALUE && path[u] + cost < path[v]) {
	            path[v] = path[u] + cost;
	        }
	    }
	    return path;
	}
	
}
