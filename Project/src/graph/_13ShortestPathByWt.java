package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13ShortestPathByWt {
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

        int src = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        Queue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(src,src + "",0));

        while (q.size() > 0) {
            Pair rm = q.remove();
            if(visited[rm.v]) {
                continue;
            }
            visited[rm.v] = true;
            System.out.println(rm.v + " via " + rm.psf + " @ "+ rm.wsf);

            for (Edge edge : graph[rm.v]){
                if(!visited[edge.nbr]) {
                    q.add(new Pair(edge.nbr,rm.psf + edge.nbr,rm.wsf+edge.wt));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;

        Pair(int v,String psf,int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
}
