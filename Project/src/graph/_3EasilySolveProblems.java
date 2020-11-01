package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _3EasilySolveProblems {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] paths = br.readLine().split(" ");
            int v1 = Integer.parseInt(paths[0]);
            int v2 = Integer.parseInt(paths[1]);
            int wt = Integer.parseInt(paths[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        multiSolver(graph,src,dest,visited,criteria,k,src + "",0);
        System.out.println(" Smallest path " + spath + "@"+spathwt);
        System.out.println(" Longest path " + lpath + "@"+lpathwt);
        System.out.println(" just Larger path than " + criteria + " = "+ cpath + "@"+cpathwt);
        System.out.println(" just Smaller path than " + criteria + " = "+ fpath + "@"+fpathwt);
        System.out.println( k +"th largest path " + pq.peek().psf + "@"+pq.peek().wsf);
    }
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    private static void multiSolver(List<Edge>[] graph,int src,int dest,boolean[] visited,int criteria,
                                   int k,String asf,int wt) {
        if(src == dest) {
            if(wt < spathwt) {
                spathwt = wt;
                spath = asf;
            }
            if(wt > lpathwt) {
                lpathwt = wt;
                lpath = asf;
            }
            if(wt > criteria && wt < cpathwt) {
                cpathwt = wt;
                cpath = asf;
            }

            if(wt < criteria && wt > fpathwt) {
                fpathwt = wt;
                fpath = asf;
            }
            if(pq.size() < k) {
                pq.add(new Pair(wt,asf));
            } else {
                if(wt > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wt,asf));
                }
            }
            return;
        }
        visited[src] = true;
        for (Edge edge: graph[src]) {
            if (!visited[edge.nbr]) {
                multiSolver(graph,edge.nbr,dest,visited,criteria,k,asf + edge.nbr,edge.wt + wt);
            }
        }
        visited[src] = false;
    }
}
