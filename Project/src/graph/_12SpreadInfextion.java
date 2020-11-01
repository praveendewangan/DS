package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _12SpreadInfextion {
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
        int time = Integer.parseInt(br.readLine());
        int[] visited = new int[vtces];
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,1));
        int count = 0;
        while (q.size() > 0) {
            Pair rm = q.removeFirst();
            if(visited[rm.v] > 0) {
                continue;
            }
            visited[rm.v] = rm.time;
            if(rm.time > time) {
                break;
            }
            count++;

            for (Edge edge : graph[rm.v]){
                if(visited[edge.nbr] == 0) {
                    q.add(new Pair(edge.nbr,rm.time + 1));
                }
            }
        }
        System.out.println(count);
    }

    static class Pair implements Comparable<graph.Pair> {
        int v;
        int time;

        Pair(int v,int time) {
            this.v = v;
            this.time = time;
        }

        public int compareTo(graph.Pair o) {
            return this.v - o.wsf;
        }
    }
}
