import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
      if(ci > ti) {
          for(int val : boxes) {
              if(val == 0) {
                  System.out.print("-");
              } else {
                  System.out.print("i");
              }
          }
              System.out.println();
          return;
      }
        for(int i = lb+1; i < boxes.length; i++){
                boxes[i] = 1;
                combinations(boxes,ci+1,ti,i);
                boxes[i] = 0;
        }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}