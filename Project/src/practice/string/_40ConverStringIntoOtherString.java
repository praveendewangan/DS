package practice.string;

public class _40ConverStringIntoOtherString {
    // O(n),O(1)
    public static void main(String[] args) {
        String A = "EACBD";
        String B = "EABCD";
        int res = 0;

        int i=A.length()-1;
        int j=B.length()-1;
        while(i>=0) {
            if(A.charAt(i) != B.charAt(j)) {
                res++;
            } else {
                j--;
            }
            i--;

        }
        System.out.println(res);
    }
}
