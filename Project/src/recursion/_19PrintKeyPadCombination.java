package recursion;

public class _19PrintKeyPadCombination {
    private static int count = 0;
    public static void main(String[] args) {
        String key = "567";
        printKPD("567","");
        System.out.println(count);
    }
    private static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrst","uv","wxyz"};
    private static void printKPD(String s,String ans) {
        if(s.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String sb = s.substring(1);
        String code = codes[ch-'0'];
        for (int i = 0; i < code.length(); i++) {
            count++;
            printKPD(sb,ans+code.charAt(i));
        }
    }
}
