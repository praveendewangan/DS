
class _22CourseScheduleLC207 {
    private void create(Map<Integer,List<Integer>> graph, int[][] g) {
        for(int i = 0; i < g.length; i++){
            int v1 = g[i][0];
            int v2 = g[i][1];
            if(!graph.containsKey(v1)){
                graph.put(v1,new ArrayList<>());
            }
            graph.get(v1).add(v2);
        }
    }
    public boolean canFinish(int num, int[][] g) {
        // System.out.println(g.length);
        if(g.length == 1) {
            return true;
        }
        int[] v = new int[num];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        create(graph,g);
        for(int i=0; i < g.length; i++) {
            int v1 = g[i][0];
            int v2 = g[i][1];
            if(!graph.containsKey(v1)) {
                return false;
            }
            if(v[v1] == 0 && isCyclic(graph,v1,v2,v)) {
                return false;
            }
        }
        return true;
    }
    private boolean isCyclic(Map<Integer,List<Integer>> graph,int src,int dest,int[] v) {
            if(v[src] == 2){
                return true;
            }
            v[src] = 2;
            for(int nbr : graph.get(src)) {
                if(v[nbr] != 1) {
                    if(graph.get(nbr) != null && isCyclic(graph,nbr,dest,v)) {
                        return true;
                    }
                }
            }
            v[src] = 1;
        return false;
    }
}