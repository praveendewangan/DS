package _codes.patterns;

public class _8Pattern {    
    public static void main(String[] args) {
        int n = 5;
        int space = n-1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            System.out.println("*\t");
            space--;
        }
    }   
}
