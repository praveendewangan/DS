package _codes.patterns;

public class _15Pattern {
    public static void main(String[] args) {
        int n = 5;
        int star = 1;
        int space = n/2;
        int val = 1;
        for(int i=1; i <= n; i++) {
            int ival = val;
            for(int j=1; j <= space; j++){
                System.out.print("\t");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print(ival+"\t");
                if(j <= star/2){
                    ival++;
                } else {
                    ival--;
                }
            }
            System.out.println();
            if(i <= n/2) {
                star += 2;
                space--;
                val++;
            } else {
                star -= 2;
                space++;
                val--;
            }

        }
    }
}
