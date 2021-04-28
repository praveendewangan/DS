package _codes.stringAndArrayList;

import java.util.List;

public class _1RemovePrimeFromList {
    
    private static void removePrime(List<Integer> list) {
        if(list == null || list.isEmpty()){
            return;
        }
        int n = list.size() - 1;
        int i = n;
        while(i >= 0) {
            if(isPrime(list.get(i))){
                n = list.size() - 1;
                list.set(i, list.get(n));
                list.remove(i);
            }
            i--;
        }
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
