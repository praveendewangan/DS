package practice.matrix;

public class _8Rotate90degree {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                      { 5, 6, 7, 8 },
                      { 9, 10, 11, 12 },
                      { 13, 14, 15, 16 } };

        rotate90degree(arr);
        for(int i=0;i<arr.length;i++){
            swap(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void swap(int[] m) {
        int i = 0;
        int j = m.length-1;
        while(i < j) {
            int t = m[i];
            m[i] = m[j];
            m[j] = t;
            i++;
            j--;
        }
    }
    public static void rotate90degree(int[][] a) {
        for(int i=0;i < a.length;i++){
            for(int j=i;j < a[0].length;j++){
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    } 
}
