package _codes.patterns;

public class _4Pattern {
    
    public static void main(String[] args) {
        int n = 5;
        int star = n;
        int space = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for(int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            star--;
            space++;
        }
    }
}
