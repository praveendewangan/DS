package graph;

public class Pair implements Comparable<Pair> {
    int wsf;
    String psf;

    Pair(int wsf,String psf) {
        this.psf = psf;
        this.wsf = wsf;
    }

    public int compareTo(Pair o) {
        return this.wsf - o.wsf;
    }
}
