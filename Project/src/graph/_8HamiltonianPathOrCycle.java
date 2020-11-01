package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _8HamiltonianPathOrCycle {
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

        Set<Integer> visited = new HashSet<>();
        hamiltonian(graph,src,visited,src,src + "");
    }
    private static void hamiltonian(List<Edge>[] graph,int src,Set<Integer> visited,int osrc,String asf) {
        if(visited.size() == graph.length - 1) {
            System.out.print(asf);
            boolean isPath = true;
            for (Edge edge : graph[src]) {
                if(edge.nbr == osrc) {
                    isPath = false;
                    break;
                }
            }
            if(isPath) {
                System.out.println(".");
            } else {
                System.out.println("*");
            }
            return;
        }
        visited.add(src);
        for (Edge edge : graph[src]) {
            if(!visited.contains(edge.nbr)) {
                hamiltonian(graph,edge.nbr,visited,osrc,asf+edge.nbr);
            }
        }
        visited.remove(src);
    }
}
