package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _14Prism_AlgoFindMinPath {
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
        Queue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,-1,0));

        while (q.size() > 0) {
            Pair rm = q.remove();
            if(visited[rm.v]) {
                continue;
            }
            visited[rm.v] = true;
            if(rm.av != -1) {
                System.out.println("["+rm.v + "-" + rm.av + " @ "+ rm.wsf+"]");
            }

            for (Edge edge : graph[rm.v]){
                if(!visited[edge.nbr]) {
                    q.add(new Pair(edge.nbr,rm.v,edge.wt));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int av;
        int wsf;

        Pair(int v,int av,int wsf) {
            this.v = v;
            this.av = av;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
}
