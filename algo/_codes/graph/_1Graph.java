import java.util.ArrayList;

public class _1Graph {
    
    public static class Edge {
        int v1;
        int v2;
        int wt;

        public Edge(int v1,int v2,int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph,int v1,int v2,int wt) {
        graph[v1].add(new Edge(v1,v2,wt));
        graph[v2].add(new Edge(v2,v1,wt));
    }

    public static void display(ArrayList<Edge>[] graph) {
        for (int v = 0; v < graph.length; v++) {
            System.out.print("[ "+v+" ] -> ");
            ArrayList<Edge> edges = graph[v];
            for(Edge edge : edges) {
                System.out.print("( "+edge.v1+" - "+edge.v2+" @ "+edge.wt+" ),");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] data = {
            {0,1,10},
            {0,3,10},
            {1,2,10},
            {2,3,10},
            {3,4,2},
            {4,5,3},
            {5,6,3},
            {6,4,8},
        };
        ArrayList<Edge>[] graph = new ArrayList[7]; 
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] a : data) {
            addEdge(graph, a[0], a[1], a[2]);
        }
        display(graph);

    }
}
