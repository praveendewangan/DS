package practice.string;

public class _17RabinKarpAlgo {
    public static void main(String[] args) {
        String str = "";
        String ptn = "";

        String txt = "GEEKS FOR GEEKS"; 
        String pat = "GEEK"; 
            
          // A prime number 
        int q = 101;  
        
          // Function Call 
        search(pat, txt, q); 
    }   
    static final int d = 256;
    private static void search(String pat,String txt,int q) {
        int m = pat.length();
        int n = txt.length();
        int p = 0;
        int t = 0;
        int h = 1;

        for(int i = 0;i<m-1;i++) {
            h = (h*d)%q;
        }

        for(int i=0;i<m;i++){
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        for(int i=0;i<=n-m;i++){
            if(p == t){
                int j = 0;
                for(j=0;j<m;j++) {
                    if(pat.charAt(j) != txt.charAt(i+j)) {
                        break;
                    }
                }
                if(j == m) {
                    System.out.println("Pattern found at index " + i); 
                }
            } else {
                if(i < n - m) {
                    t = (d * (t-txt.charAt(i) * h) + txt.charAt(i+m))%q;
                    if(t < 0) {
                        t += q;
                    }
                }
            }
        }
    }
}
