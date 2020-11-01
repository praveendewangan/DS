package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7PerfectFriends {
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
            int wt = 0;
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        List<List<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vtces];
        for (int i = 0; i < vtces; i++) {
            if(!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                getComponents(graph,i,comp,visited);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }
        System.out.println(pairs);
    }
    private static void  getComponents(List<Edge>[] graph,int src,List<Integer> comp,boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]) {
            if(!visited[edge.nbr]) {
                getComponents(graph,edge.nbr,comp,visited);
            }
        }
    }
}
