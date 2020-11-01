package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11IsGraphBipartite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        int[] visited = new int[vtces];
        Arrays.fill(visited,-1);
        for (int src = 0; src < vtces; src++) {
            if(visited[src] == -1) {
                boolean isBiPartite = isBiPartite(graph,src,visited);
                if(isBiPartite) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    private static boolean isBiPartite(List<Edge>[] graph,int src,int[] visited){
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,src+"",0));

        while (q.size() > 0) {
            Pair rm = q.removeFirst();
            if(visited[rm.wsf] != -1) {
                if(rm.level != visited[rm.wsf]) {
                    return false;
                }
            } else {
                visited[rm.wsf] = rm.level;
            }
            for (Edge edge : graph[rm.wsf]){
                if(visited[edge.nbr] != -1) {
                    q.add(new Pair(edge.nbr,rm.psf+edge.nbr,rm.level + 1));
                }
            }
        }
        return true;
    }
    static class Pair implements Comparable<graph.Pair> {
        int wsf;
        String psf;
        int level;

        Pair(int wsf,String psf,int level) {
            this.psf = psf;
            this.wsf = wsf;
            this.level = level;
        }

        public int compareTo(graph.Pair o) {
            return this.wsf - o.wsf;
        }
    }
}
