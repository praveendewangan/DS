import java.util.*;

public class _51MinimumDominoRotationsForEqualRowLC1007 {

  //~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
  private static int setCount(int[] arr1, int[] arr2, int val, int count, int indx) {
        if(count != Integer.MAX_VALUE) {
            if(arr1[indx] == val) {
                // nothing to do
            } else if(arr2[indx] == val) {
                // rotation required
                count++;
            } else {
                count = Integer.MAX_VALUE;
            }
        }
        return count;
    }
   
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int val1 = tops[0];
        int val2 = bottoms[0];

        int count1 = 0; // Rotations for Top as val1
        int count2 = 0; // Rotations for Top as val2
        int count3 = 0; // Rotations for Bottom as val1
        int count4 = 0; // Rotations for Bottom as val2

        for(int i = 0; i < tops.length; i++) {
            count1 = setCount(tops, bottoms, val1, count1, i);
            count2 = setCount(tops, bottoms, val2, count2, i);
            count3 = setCount(bottoms, tops, val1, count3, i);
            count4 = setCount(bottoms, tops, val2, count4, i);
        }
        int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

  //~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] top = new int[n];
    int[] bottom = new int[n];

    // read top
    for (int i = 0; i < top.length; i++) {
      top[i] = scn.nextInt();
    }
    // read bottom
    for (int i = 0; i < bottom.length; i++) {
      bottom[i] = scn.nextInt();
    }

    int rotation = minDominoRotations(top, bottom);
    System.out.println(rotation);
  }
}