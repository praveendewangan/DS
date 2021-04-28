package _codes.patterns;

public class _13Pattern {
    public static void main(String[] args) {
        int n = 5;
        for(int i = 0; i < n; i++) {
            int ival = 1;
            for(int j = 0; j <= i; j++) {
                System.out.print(ival+"\t");
                ival = ival *(i-j)/(j+1);
            }
            System.out.println();
        }
    }
}
