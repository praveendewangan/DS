import java.util.*;

public class _22MaxSwapLC670 {

  // ~~~~~~~~~~User Section~~~~~~~~~~~
  public static String maximumSwap(String num) {
        char[] arr = num.toCharArray();
        int[] lastIdxDigit = new int[10];
        for(int i = 0; i < arr.length; i++) {
            lastIdxDigit[arr[i]-'0'] = i;
        }
        
        for(int i = 0; i < arr.length; i++) {
            int digit = arr[i]-'0';
            int idx = i;
            for(int j = 9; j > digit; j--){
                if(lastIdxDigit[j] > i){
                    idx = lastIdxDigit[j];
                    break;
                }
            }
            if(idx != i) {
                swap(arr,i,idx);
                break;
            }
        }
        return String.valueOf(arr);
    }
    
    private static void swap(char[] arr,int i,int j) {
        char val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
    }

  // ~~~~~~~~Input Management~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}