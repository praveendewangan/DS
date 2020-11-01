package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15TopoLogicalSort {
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
        }

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();

        for (int v = 0; v < vtces; v++) {
            if(!visited[v]) {
                topologicalSort(graph,v,visited,st);
            }
        }
        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }
    private static void topologicalSort(List<Edge>[] graph,int v,boolean[] visited,Stack<Integer> st) {
        visited[v] = true;
        for (Edge e : graph[v]) {
            if(!visited[e.nbr]) {
                topologicalSort(graph,e.nbr,visited,st);
            }
        }
        st.push(v);
    }
}
