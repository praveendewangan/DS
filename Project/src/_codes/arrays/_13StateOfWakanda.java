package _codes.arrays;

public class _13StateOfWakanda {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        for(int i = 0; i < a[0].length; i++) {
            if(i % 2 == 0){
                for(int j = 0; j < a.length; j++) {
                    System.out.println(a[j][i]);
                }
            } else {
                for(int j = a.length; j >= 0; j--) {
                    System.out.println(a[j][i]);
                }
            }
        }
    }
}
