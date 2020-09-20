package recursion;

public class PrintAbbreviations {
    public static void main(String[] args) {
        print("pep","",0,0);
    }

    private static void print(String ques,String ans,int count,int pos) {
        if(pos == ques.length()) {
            if(count == 0) {
                System.out.println(ans);
                return;
            } else {
                System.out.println(ans+count);
                return;
            }
        }
        if(count > 0) {
            print(ques,ans+count+ques.charAt(pos),0,pos+1);
        } else {
            print(ques,ans+ques.charAt(pos),0,pos+1);
        }
        print(ques,ans,count+1,pos+1);
    }
}
