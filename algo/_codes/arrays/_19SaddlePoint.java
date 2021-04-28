package _codes.arrays;

public class _19SaddlePoint {
    public static void main(String[] args) {
        int[][] a = {
            {1,2,3,4},
            {11,12,13,14},
            {22,23,21,24}
        };
        findSaddlePoint(a);
    }
    private static void findSaddlePoint(int[][] a) {
        for(int i = 0; i < a.length; i++){
            int min = a[i][0];
            int idx = 0;
            for(int col = 1; col < a[0].length; col++) {
                if(a[i][col] < min){
                    min = a[i][col];
                    idx = col;
                }
            }

            boolean flag = true;
            for(int row = 0; row < a.length; row++) {
                if(a[row][idx] > min){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(min);
                return;
            }
        }
        System.out.println("Not found");
    }
}
