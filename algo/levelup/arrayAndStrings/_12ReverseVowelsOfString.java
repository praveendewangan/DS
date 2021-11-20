import java.util.*;

public class _12ReverseVowelsOfString {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        
        while(left < right) {
            while(left < right && !isVowel(arr[left])) {
                left++;
            }
            
            while(left < right && !isVowel(arr[right])) {
                right--;
            }
            
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
    
    public static boolean isVowel(char ch) {
        String s = "aeiouAEIOU";
        return s.contains(ch+"");
    }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}
