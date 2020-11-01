package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9BFS {
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
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src,src+""));
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if(visited[rem.wsf]) {
                continue;
            }
            visited[rem.wsf] = true;
            System.out.println(rem.wsf + "@" + rem.psf);
            for (Edge edge : graph[rem.wsf]) {
                if (!visited[edge.nbr]) {
                    queue.add(new Pair(edge.nbr,rem.psf+edge.nbr));
                }
            }
        }
    }
}
