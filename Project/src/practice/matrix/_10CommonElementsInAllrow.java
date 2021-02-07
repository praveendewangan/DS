package practice.matrix;

import java.util.HashMap;
import java.util.Map;

public class _10CommonElementsInAllrow {
    // O(n*m),O(n*m)
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                        };
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<mat[0].length;i++) {
            hm.put(mat[0][i], 1);
        }
        for(int i=1;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(hm.get(mat[i][j]) != null && hm.get(mat[i][j]) == i) {
                    hm.put(mat[i][j], i+1);

                    if(i == mat.length-1){
                        System.out.print(mat[i][j] + " ");
                    }
                }
            }
        }
    }
}
