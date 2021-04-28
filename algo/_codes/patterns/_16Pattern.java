package _codes.patterns;

public class _16Pattern {
    public static void main(String[] args) {
        int n = 7;
        int star = 1;
        int space = 2 * n - 3;
        for(int i=1; i <= n; i++) {
            for (int j = 1; j <= star; j++) {
                System.out.print(j+"\t");
            }
            for(int j=1; j <= space; j++){
                System.out.print("\t");
            }
            if(i == n){
                star--;
            }
            for (int j = star; j >= 1; j--) {
                System.out.print(j+"\t");
            }
            System.out.println();
            star++;
            space -= 2;

        }
    }
}
