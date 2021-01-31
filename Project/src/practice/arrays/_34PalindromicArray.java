package practice.arrays;

public class _34PalindromicArray {
    public static int palinArray(int[] a, int n)
    {
          for(int i=0;i<n;i++){
              if(!isPalindrome(a[i])){
                  return 0;
              }
          }
          return 1;
    }
    public static boolean isPalindrome(int n){
        int o = n;
        int sum = 0;
        while(n > 0){
            int r = n % 10;
            sum = (sum*10)+r;
            n = n/10;
        }
        if(sum == o) return true;
        return false;
    }
}
