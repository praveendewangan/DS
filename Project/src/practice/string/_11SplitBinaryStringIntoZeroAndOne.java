package practice.string;

public class _11SplitBinaryStringIntoZeroAndOne {
    public static void main(String[] args) {
        String str = "0111100010";
        System.out.println(split(str));
    }
    // O(n)
    public static int split(String str) {
        if(str.length() == 0) {
            return 0;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '0' && count == 0){
                count++;
            } else if(str.charAt(i) == '0' && str.charAt(i-1) == '1') {
                sb.append(str.substring(i));
                break;
            }
        }
        int c = split(sb.toString());
        return c + count;
    }
//  O(n)
    static int maxSubStr(String str, int n) 
{ 
  
    // To store the count of 0s and 1s 
    int count0 = 0, count1 = 0; 
  
    // To store the count of maximum 
    // substrings str can be divided into 
    int cnt = 0; 
    for (int i = 0; i < n; i++) 
    { 
        if (str.charAt(i) == '0')  
        { 
            count0++; 
        } 
        else 
        { 
            count1++; 
        } 
        if (count0 == count1)  
        { 
            cnt++; 
        } 
    } 
  
    // It is not possible to 
    // split the string 
    if (count0 != count1)  
    { 
        return -1; 
    } 
    return cnt; 
} 
}
