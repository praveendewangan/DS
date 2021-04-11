package _codes.patterns;

public class _17Pattern {
    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        int space = n/2;
        for(int i=1; i <= n; i++) {
            for(int j=1; j <= space; j++){
                System.out.print("\t");
            }
            for (int j = 1; j <= star; j++) {
                if(star != n && j <= star/2){
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
                
            }
            System.out.println();
            if(i <= n/2) {
                star += 2;
                space--;
            } else {
                star -= 2;
                space++;
            }

        }
    }
}
