import java.util.*;
public class _0BFS {
    public static class BPair {
        int vtx;
        String psf;
        int wsf;

        public BPair(int vtx, int wsf, String psf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    public static boolean bfs(ArrayList<Edge>[] graph, int src,
         int dst, boolean[] vis) {
        Queue<BPair> qu = new LinkedList<>();
        qu.add(new BPair(src, 0, "" + src));
        boolean res = false;
        while(qu.size() > 0) {
            // 1. get + remove
            BPair rem = qu.remove();
            // 2. mark *
            if(vis[rem.vtx] == true)
                continue;
            vis[rem.vtx] = true;
            // 3. work
            System.out.println(rem.vtx + " " + rem.psf + " @ " + rem.wsf);
            if(src == dst) {
                res = true;
                break;
            }
            // 4. add neighbours
            for(Edge e : graph[rem.vtx]) {
                if(vis[e.nbr] == false) {
                    qu.add(new BPair(e.nbr, rem.wsf + e.wt, rem.psf + e.nbr));
                }
            }
        }
        return res;
    }
}
