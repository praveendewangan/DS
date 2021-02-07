package practice.string;

public class _4CheckStringisReverseofOther {
    public static void main(String[] args) {
        String s = "ABCD";
        String test = "ACBD";
        String str = s.concat(s);
        if(str.contains(test)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
         /**
          * Other Way
          * (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
          */
    }
}
