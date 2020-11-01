package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _10IsGraphCyclic {
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

        boolean[] visited = new boolean[vtces];
        for (int src = 0; src < vtces; src++) {
            if(!visited[src]) {
                boolean isCycle = isCyclic(graph,src,visited);
                if(isCycle) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    private static boolean isCyclic(List<Edge>[] graph,int src,boolean[] visited){
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,src+""));

        while (q.size() > 0) {
            Pair rm = q.removeFirst();
            if(visited[rm.wsf]) {
                return true;
            }
            visited[rm.wsf] = true;
            for (Edge edge : graph[rm.wsf]){
                if(!visited[edge.nbr]) {
                    q.add(new Pair(edge.nbr,rm.psf+edge.wt));
                }
            }
        }
        return false;
    }
}
