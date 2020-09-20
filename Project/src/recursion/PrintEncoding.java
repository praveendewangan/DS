package recursion;

public class PrintEncoding {
    public static void main(String[] args) {
        print("123" +
                "","");
    }
    private static void print(String ques,String ans) {
        if(ques.length() == 0){
            System.out.println(ans);
            return ;
        } else if(ques.length() == 1){
            char ch = ques.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char)('a'+chv-1);
                System.out.println(ans + code);
            }
        } else {
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if(ch == '0'){
                return;
            } else {
                int chv = ch - '0';
                char code = (char)('a'+chv-1);
                print(roq,ans+code);
            }
            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26){
                char code = (char)('a'+ch12v-1);
                print(roq12,ans+code);
            }
        }
    }
}
