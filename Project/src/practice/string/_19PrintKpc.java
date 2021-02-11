package practice.string;

public class _19PrintKpc {
    /**
     * 
     * O(m^n)
     * where m = length of the input
     * n = numbers of available character for each input character
     */
    public static void main(String[] args) {
        String input = "78";
        printKPC(input,"");
    }
    static String[] kp = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String restStr = str.substring(1);
        int i = ch - '0';
        String kpcstr = kp[i];
        for(int j = 0;j<kpcstr.length();j++){
            printKPC(restStr, asf+kpcstr.charAt(j));
        }
    }
}
