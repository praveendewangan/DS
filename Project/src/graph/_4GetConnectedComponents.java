package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _4GetConnectedComponents {
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
        List<List<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
            if(!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                getComps(graph,i,visited,comp);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }

    private static void getComps(List<Edge>[] graph, int src, boolean[] visited,List<Integer> comp) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]) {
            if(visited[edge.nbr] == false) {
                getComps(graph,edge.nbr,visited,comp);
            }
        }
    }
}
