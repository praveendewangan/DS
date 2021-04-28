package _codes.patterns;

public class _12Pattern {
    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        int a = 0;
        int b = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= star; j++) {
                System.out.print(a+"\t");
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
            star++;
        }
    }
}
