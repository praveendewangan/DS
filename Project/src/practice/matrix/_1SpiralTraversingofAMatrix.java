package practice.matrix;

import java.util.ArrayList;

public class _1SpiralTraversingofAMatrix {
    // O(m*n) - O(1)
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int total = r*c;
        int minr = 0;
        int minc = 0;
        int maxr = r-1;
        int maxc = c-1;
        
        while(count < total) {
            for(int i=minr,j=minc;j<=maxc && count < total;j++,count++){
                list.add(matrix[i][j]);
            }
            minr++;
            
            for(int i=minr,j=maxc;i<=maxr && count < total;i++,count++){
                list.add(matrix[i][j]);
            }
            maxc--;
            
            for(int i=maxr,j=maxc;j>=minc && count < total;j--,count++){
                list.add(matrix[i][j]);
            }
            maxr--;
            
            for(int i=maxr,j=minc;i>=minr && count < total;i--,count++) {
                list.add(matrix[i][j]);
            }
            minc++;
        }
        return list;
    }
}
