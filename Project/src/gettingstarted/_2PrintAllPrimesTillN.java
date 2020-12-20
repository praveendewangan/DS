package gettingstarted;


/*Sample Input
        6
        24
Sample Output
        7
        11
        13
        17
        19
        23*/
public class _2PrintAllPrimesTillN {
    public static void main(String[] args) {
        int start = 7;
        int end = 24;
        for (int i = 7; i < 24; i++) {
            isPrime(i);
        }
    }
    public static void isPrime(int num){
        for (int j = 2; j * j <= num; j++) {
            if(num % j == 0) {
//                System.out.println("not prime");
                return;
            }
        }
        System.out.println(num);
    }
}


