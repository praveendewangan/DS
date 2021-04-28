package _codes.patterns;

// 4       4       4       4       4       4       4
// 4       3       3       3       3       3       4
// 4       3       2       2       2       3       4
// 4       3       2       1       2       3       4
// 4       3       2       2       2       3       4
// 4       3       3       3       3       3       4
// 4       4       4       4       4       4       4
public class _21Pattern {
    public static void main(String[] args) {
        int n = 4;
        int star = n;
        for(int i=1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                    int min = i < j ? i : j;
                    System.out.print(n - min+1+"\t");
            }    

            for (int j = n-1; j >= 1; j--) {
                int min = i < j ? i : j;
                System.out.print(n - min+1+"\t");
        }
            System.out.println();
        }
        
        for(int i=n-1; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                    int min = i < j ? i : j;
                    System.out.print(n - min+1+"\t");
            }    

            for (int j = n-1; j >= 1; j--) {
                int min = i < j ? i : j;
                System.out.print(n - min+1+"\t");
        }
            System.out.println();
        }
    }
}
