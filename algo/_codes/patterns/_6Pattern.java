package _codes.patterns;

public class _6Pattern {
    
    public static void main(String[] args) {
        int n = 5;
        int star = n + 1;
        int space = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= star/2; j++) {
                System.out.print("*\t");
            }
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for(int j = 1; j <= star/2; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            if(i <= n/2) {
                star -= 2;
                space += 2;
            } else {
                star += 2;
                space -= 2;

            }
        }
    }
}
