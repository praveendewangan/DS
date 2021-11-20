import java.io.*;
import java.util.*;

class _4BusRoutes {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    String[] st1 = br.readLine().split(" ");
    int src = Integer.parseInt(st1[0]);
    int dest = Integer.parseInt(st1[1]);
    System.out.println(numBusesToDestination(arr, src, dest));

  }

      public static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        makeMapWithStandAndBus(routes,map);
        
        HashSet<Integer> visBus = new HashSet<>();
        HashSet<Integer> visStand = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int level = -1;
        
        while(q.size() > 0) {
            int size = q.size();
            level++;
            while(size-- > 0) {
                int rm = q.remove();
                if(rm == target) return level;
                for(int busNum : map.get(rm)){
                    if(visBus.contains(busNum)) {
                        continue;
                    } else {
                        for(int busStand : routes[busNum]){
                            if(!visStand.contains(busStand)) {
                                visStand.add(busStand);
                                q.add(busStand);
                            }
                        }
                        visBus.add(busNum);
                    }
                }
            }
        }
        return -1;
    }
    
    private static void makeMapWithStandAndBus(int[][] routes, Map<Integer,List<Integer>> map) {
        for(int r = 0; r < routes.length; r++){
            for(int c = 0; c < routes[r].length; c++) {
                int stand = routes[r][c];
                if(map.containsKey(stand)) {
              
                    // key is already present, so just add value i.e. bus number with that bus stop
                    map.get(stand).add(r);
                } else {
                    List<Integer> busNo = new ArrayList<>();
                    busNo.add(r);
                    map.put(stand,busNo);
                }
            }
        }
    }

}
