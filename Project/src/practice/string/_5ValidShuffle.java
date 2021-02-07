package practice.string;

public class _5ValidShuffle {
    public static void main(String[] args) {
        String s1 = "XY";
        String s2 = "12";
        String que = "Y12X";

        
    }
    static boolean checkValidShuffle(String s1,String s2,String res) {
        if(s1.length() + s2.length() != res.length() ){
            return false;
        }
        int i=0;
        int j=0;
        int k=0;

        while(k != res.length()) {
            if(i < s1.length() && s1.charAt(i) == res.charAt(k)){
                i++;
            } else if(j < s2.length() && s2.charAt(j) == res.charAt(k) ) {
                j++;
            } else {

            }
            k++;
        }
        if(i < s1.length() || j < s2.length() ) {
            return false;
        } else {
            return true;
        }
    }
}
