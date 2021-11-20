import java.util.*;

public class _7NextGreaterElement3 {
    
    //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        if(str.length() == 1) {
            return "-1";
        }
        return getNextPermutation(str);
    }
    
    private static String getNextPermutation(String str) {
        int idx1 = -1;
        for(int i = str.length()-2; i >= 0; i--){
            int n1 = (int) (str.charAt(i) - '0');
            int n2 = (int)(str.charAt(i+1) - '0');
            if(n1 < n2) {
                idx1 = i;
                break;
            }
        }
        if(idx1 == -1) {
            return "-1";
        }
        int idx2 = -1;
        int val = (int) (str.charAt(idx1) - '0');
        for(int i = str.length()-1; i >= 0; i--){
            int n1 = (int) (str.charAt(i) - '0');
            if(val < n1) {
                idx2 = i;
                break;
            }
        }
        char[] arr = str.toCharArray();
        swap(arr,idx1,idx2);
        rotate(arr,idx1+1,arr.length-1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        Long n1 = Long.parseLong(str);
        Long n2 = Long.parseLong(sb.toString());
        if(n2 > n1) {
            return sb.toString();
        } else {
            return "-1";
        }
    }
    
    private static void swap(char[] arr,int i,int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
    
    private static void rotate(char[] arr,int i,int j) {
        while(i < j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}