public class _29EulerCircuitOrPath {
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int odd = 0;

        for(int i = 0; i < V; i++) {
            if(adj.get(i).size()%2!=0){
                odd++;
            }
        }
        if(odd==0) {
            // Euler circuit exist
            return 2;
        } else if(odd==2) {
            // Euler path exist
            return 1;
        } else {
            return 0;
        }
    }
}
