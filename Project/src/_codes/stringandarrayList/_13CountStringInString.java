public class _13CountStringInString {
    // Q - hihiiiihhhihihhihiiiihihi
    // A - 8
    public static String solve(String str){
		if(str.length() == 0) return "";
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int count = 0;
		while(i < n) {
		    char a = str.charAt(i);
		    char b = str.charAt(i+1);
		    if(i < n - 1 &&a == 'h' && b == 'i') {
		        count++;
		        i+=2;
		    } else {
	            sb.append(a);
		        i++;
		    }
		}
    System.out.println(count);
		return sb.toString();
	}
}
