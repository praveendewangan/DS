package practice.string;

public class _17RabinKarpAlgo2 {
    static final int prime = 3;
    static int createNewHash(String str,int n){
        int result = 0;
        for(int i=0;i<n;i++) {
            result += ((int)str.charAt(i)) * Math.pow(prime, i);
        }
        return result;
    }

    static int recalculatehash(String str,int oldidx,int newidx,int oldhash,int patlen){
        int newhash = oldhash - ((int)str.charAt(oldidx));
        newhash /= prime;
        newhash += ((int)str.charAt(newidx)) * Math.pow(prime, patlen-1);
        return newhash;
    }

    static boolean checkequal(String str1,String str2,int start1,int end1,int start2,int end2) {
        if(end1-start1 != end2-start2) {
            return false;
        }
        while(start1<=end1 && start2<=end2) {
            if(str1.charAt(start1) != str2.charAt(start2)){
                    return false;
            }
            start1++;
            start2++;
        }
        return true;
    }
    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS"; 
        String pat = "GEEK"; 
        int patHash = createNewHash(pat,pat.length());
        int txtHash = createNewHash(txt,pat.length());
        // System.out.println(patHash);
        // System.out.println(txtHash);
        // System.exit(0);

        for(int i=0;i<=txt.length()-pat.length();i++) {
            if(patHash == txtHash && checkequal(txt, pat, i, i+pat.length()-1, 0, pat.length()-1)) {
                System.out.println(i);
                // return;
            }
            if(i < txt.length()-pat.length()){
                txtHash = recalculatehash(txt, i, i+pat.length(), txtHash, pat.length());
            }
        }
    }
}
