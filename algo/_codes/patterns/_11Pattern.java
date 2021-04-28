package _codes.patterns;

public class _11Pattern {    
    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        int num = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= star; j++) {
                System.out.print(num+"\t");
                num++;
            }
            System.out.println();
            star++;
        }
    }
}
