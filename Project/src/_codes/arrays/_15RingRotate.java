package _codes.arrays;

public class _15RingRotate {
    public static void main(String[] args) {
        int[][] a = {
            {11,12,13,14,15,16,17},
            {21,22,23,24,25,26,27},
            {31,32,33,34,35,36,37},
            {41,42,43,44,45,46,47},
            {51,52,53,54,55,56,57}
        };
        int s = 2;
        int k = 3;
        ringRoate(a,s,k);
        display(a);
    }
    private static void ringRoate(int[][] a,int s,int k) {
        int[] els = fill1DFrom2D(a,s);
        rotate(els,k);
        fill2DFrom1D(a,els,s);
    }
    private static int[] fill1DFrom2D(int[][] a,int s) {
        int rmin = s-1;
        int cmin = s-1;
        int rmax = a.length - s;
        int cmax = a[0].length - s;
        int size = 2 * (rmax - rmin + cmax - cmin);
        int[] els = new int[size];
        int idx = 0;
        for(int i = rmin,j = cmin; i <= rmax;i++) {
            els[idx++] = a[i][j];
        }
        cmin++;
        
        for(int i = rmax,j = cmin; j <= cmax;j++) {
            els[idx++] = a[i][j];
        }
        rmax--;
        
        for(int i = rmax,j = cmax; i >= rmin;i--) {
            els[idx++] = a[i][j];
        }
        cmax--;
        
        for(int i = rmin,j = cmax; j >= cmin;j--) {
            els[idx++] = a[i][j];
        }
        rmin++;
        return els;
    }

    public static void rotate(int[] a,int k) {
        int len = a.length;
        reverse(a,len-k,len-1);
        reverse(a,0,len-k-1);
        reverse(a,0,len-1);
    }
    public static void reverse(int[] a, int i, int j) {
        while(i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    private static void fill2DFrom1D(int[][] a,int[] els,int s) {
        int rmin = s-1;
        int cmin = s-1;
        int rmax = a.length - s;
        int cmax = a[0].length - s;
        int idx = 0;
        for(int i = rmin,j = cmin; i <= rmax;i++) {
            a[i][j] = els[idx++];
        }
        cmin++;
        
        for(int i = rmax,j = cmin; j <= cmax;j++) {
            a[i][j] = els[idx++];
        }
        rmax--;
        
        for(int i = rmax,j = cmax; i >= rmin;i--) {
            a[i][j] = els[idx++];
        }
        cmax--;
        
        for(int i = rmin,j = cmax; j >= cmin;j--) {
            a[i][j] = els[idx++];
        }
        rmin++;
    }
    private static void display(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
