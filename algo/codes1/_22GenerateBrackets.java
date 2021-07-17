public class _22GenerateBrackets {
    public static void main(String[] args) {
        int n = 2;
        int open  = 0;
        int close = 0;
        String res = "";
        int i = 0;
        generateBrackets(res,n,open,close,i);
    }

    private static void generateBrackets(String res,int n,int open, int close, int i) {
        if(i == 2*n) {
            System.out.println(res);
            return;
        }
        if(open < n) {
            generateBrackets(res+"(", n, open+1, close, i+1);
        }

        if(close < open) {
            generateBrackets(res+")", n, open, close+1, i+1);
        }

    }
}
