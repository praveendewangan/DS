import java.util.*;

public class _29SieveOfEratosthenes {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        boolean[] arr = new boolean[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = true;
        }
        arr[0] = false;
        arr[1] = false;
        for(int i = 2; i * i <= n; i++){
            if(arr[i]){
                for(int j = 2*i; j <= n; j += i){
                    arr[j] = false;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(arr[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}