package _codes.arrays;

public class _14SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = {
                    {11,12,13,14},
                    {21,22,23,24},
                    {31,32,33,34},
        };
        display(a);
    }
    private static void display(int[][] a) {
        int rmin = 0;
        int cmin = 0;
        int rmax = a.length - 1;
        int cmax = a[0].length - 1;
        int total = a.length * a[0].length;
        int t = 0;
        while(t < total) {
            for(int i = rmin,j = cmin; i <= rmax && t < total;i++,t++) {
                System.out.println(a[i][j]);
            }
            cmin++;
            
            for(int i = rmax,j = cmin; j <= cmax && t < total;j++,t++) {
                System.out.println(a[i][j]);
            }
            rmax--;
            
            for(int i = rmax,j = cmax; i >= rmin && t < total;i--,t++) {
                System.out.println(a[i][j]);
            }
            cmax--;
            
            for(int i = rmin,j = cmax; j >= cmin && t < total;j--,t++) {
                System.out.println(a[i][j]);
            }
            rmin++;
        }
    }
}
