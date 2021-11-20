import java.util.*;
public class _13NumberOfWaysToArriveAtDestinationLC1976 {
    class Edge {
        int v;
        int wt;
        Edge(int v,int wt) {
            this.v = v;
            this.wt = wt;
        }
    }
    class Pair  implements Comparable<Pair>{
        int v;
        int d;
        Pair(int v,int d) {
            this.v = v;
            this.d = d;
        }
        public int compareTo(Pair obj){
            return this.d - obj.d;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        long MOD = 1_000_000_007;
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i < roads.length; i++){
            graph.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            graph.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue();
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int[] ways = new int[n];
        dis[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));
        while(pq.size() > 0) {
            Pair rm = pq.remove();
            if(rm.d > dis[rm.v]) continue;
            for(Pair p : graph.get(rm.v)){
                if(dis[p.v] > rm.d + p.d) {
                    dis[p.v] = rm.d + p.d;
                    ways[p.v] = ways[rm.v];
                    pq.add(new Pair(p.v,dis[p.v]));
                } else if(dis[p.v] == rm.d + p.d) {
                    ways[p.v] = (int) ((ways[p.v] + ways[rm.v]) % MOD); 
                }
            }
        }
        return ways[n-1];
    }
}