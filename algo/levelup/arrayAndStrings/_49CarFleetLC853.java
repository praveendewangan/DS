public class _49CarFleetLC853 {
    
    class Pair implements Comparable<Pair> {
        int pos;
        int speed;
        Pair(int pos,int speed) {
            this.pos = pos;
            this.speed = speed;
        }
        public int compareTo(Pair o) {
            return this.pos - o.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < position.length; i++){
            p.add(new Pair(position[i],speed[i]));
        }
        double maxT = 0D;
        int fleets = 0;
        while(p.size() > 0) {
            Pair rm = p.remove();
        
            double t = (target - rm.pos) / (rm.speed * 1.0);
            if(maxT < t) {
                maxT = t;
                fleets++;
            }
        }
        return fleets;
    }
}