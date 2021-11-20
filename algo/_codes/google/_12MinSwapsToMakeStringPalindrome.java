public class _12MinSwapsToMakeStringPalindrome {
    
    public static void main(String[] args) {
        System.out.println(getMinCount("nitin"));
    }    

    private static int getMinCount(String s) {
        if(s == null || s.isEmpty()) return -1;
        // check if we can make string palindrome or not
        if(isPossiblePalindrome(s)) {
            int count = 0;
            int l = 0;
            int r = s.length()-1;
            char[] chars = s.toCharArray();
            while(l < r) {
                if(chars[l] != chars[r]) {
                    int k = r;
                    while(l < k && chars[l] != chars[k]) {
                        k--;
                    }
                    if(l == k) {
                        swap(chars,k,k+1);
                        count++;
                    } else {
                        while(k < r) {
                            swap(chars,k,k+1);
                            count++;
                            k++;
                        }
                        l++;
                        r--;
                    }
                } else {
                    l++;
                    r--;
                }
            }
            return count;
        } else {
            return -1;
        }
    }

    private static boolean isPossiblePalindrome(String str) {
        int oddCount = 0;
        char[] chars = new char[26];
        for(int i = 0; i< str.length(); i++) {
            chars[str.charAt(i)-'a']++;
        }
        for(int i = 0; i< str.length(); i++) {
            if(chars[i] % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    private static void swap(char[] chars,int i,int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}
