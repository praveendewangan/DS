package practice.string;

public class _10PrintAllPermutation {

    // O(n*fcat),O(1)
	public static void print(String s) {
	    int n = s.length();
	    int fact = getfact(n);
	    for(int i=0;i<fact;i++){
	        StringBuilder sb = new StringBuilder(s);
	        int temp = i;
	        for(int div = n;div>=1;div--){
	            int r = temp % div;
	            temp = temp / div;
	            System.out.print(sb.charAt(r));
	            sb.deleteCharAt(r);
	        }
	        System.out.print(" ");
        }
    }

	public static int getfact(int n) {
	    int res = 1;
	    for(int i=2;i<=n;i++){
	        res*=i;
	    }
	    return res;
	}

    // O(n^2),O(1)
	public static void print(String s,String asf) {
	    if(s.length() == 0) {
	        System.out.print(asf+" ");
	        return;
	    }
	    for(int i=s.length()-1;i>=0;i--){
	        char ch = s.charAt(i);
	        String pre = s.substring(0,i);
	        String post = s.substring(i+1);
	        String roq = post+pre;
	        print(roq,asf+ch);
	    }
	}
}
