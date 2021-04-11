package _codes.patterns;

public class _1Pattern {
    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            star++;
        }
    }
}
