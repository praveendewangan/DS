package _codes.patterns;

public class _10Pattern {
    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        int space = n/2;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for(int j = 1; j <= star; j++) {
                if(j == 1 || j == star){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
            if(i <= n/2){
                star += 2;
                space--;
            } else {
                star -= 2;
                space++;
            }
        }
    }
}
