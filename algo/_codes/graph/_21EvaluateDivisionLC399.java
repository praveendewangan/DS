import java.util.*;

class _21EvaluateDivisionLC399 {
    class Edge {
        String nbr;
        double wt;
        Edge(String nbr,double wt) {
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public void addEdge(Map<String,List<Edge>> graph,String v1,String v2,double wt) {
        if(!graph.containsKey(v1)) {
            graph.put(v1,new ArrayList<>());
        }
        graph.get(v1).add(new Edge(v2,wt)); 
        
        if(!graph.containsKey(v2)) {
            graph.put(v2,new ArrayList<>());
        }
        graph.get(v2).add(new Edge(v1,1/wt)); 
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Edge>> graph = new HashMap<>(); 
        
        for(int e = 0; e < equations.size(); e++) {
            String v1 = equations.get(e).get(0);
            String v2 = equations.get(e).get(1);
            double wt = values[e];
            addEdge(graph,v1,v2,wt);
        }
        
        double[] res = new double[queries.size()];
        for(int qi = 0; qi < queries.size(); qi++) {
            String v1 = queries.get(qi).get(0);
            String v2 = queries.get(qi).get(1);
            if(!graph.containsKey(v1) || !graph.containsKey(v1)) {
                res[qi] = -1.0;
            } else if(v1.equals(v2)) {
                res[qi] = 1.0;
            } else {
                Set<String> set = new HashSet<>();
                if(!bfs(graph,v1,v2,set,res,qi,1.0)) {
                    res[qi] = -1.0;
                }
                // if(!dfs(graph,v1,v2,set,res,qi,1.0)) {
                //     res[qi] = -1.0;
                // }
            }
        }
        return res;
    }
    
//     Using bfs 
class Pair {
    String src;
    double wt;
    Pair(String src,double wt) {
        this.src = src;
        this.wt = wt;
    }
}
private boolean bfs(Map<String,List<Edge>> graph,String src,String dest,Set<String> set,double[] res,int idx,double cost) {
    
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(src,cost));
    while(q.size() > 0) {
        Pair rm = q.remove();
        if(rm.src.equals(dest)) {
            res[idx] = rm.wt;
            return true;
        }
        set.add(rm.src);
        for(Edge e : graph.get(rm.src)) {
            if(!set.contains(e.nbr)) {
                q.add(new Pair(e.nbr,e.wt*rm.wt));
            }
        }

    }
        return false;
}

// Using dfs
    private boolean dfs(Map<String,List<Edge>> graph,String src,String dest,Set<String> set,double[] res,int idx,double cost) {
        if(src.equals(dest)) {
            res[idx] = cost;
            return true;
        }
        set.add(src);
        for(Edge e : graph.get(src)) {
            if(!set.contains(e.nbr)) {
                if(dfs(graph,e.nbr,dest,set,res,idx,cost * e.wt)) {
                    return true;
                }
            }
        }
        return false;
    }
}
