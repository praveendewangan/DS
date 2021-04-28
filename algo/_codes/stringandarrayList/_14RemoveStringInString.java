public class _14RemoveStringInString {
    // Q - hihithithithihitttihithi
    // A - hithithithitttihit
    public static String solve(String str){
		if(str.length() == 0) return "";
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < n) {
		    char a = str.charAt(i);
		    char b = str.charAt(i+1);
		    if(i < n - 1 && a == 'h' && b == 'i') {
		        if(i < n - 2 && a == 'h' && b == 'i' && str.charAt(i+2) == 't'){
		            sb.append("hit");
		            i+=3;
		        } else {
		            i+=2;
		        }
		    } else {
	            sb.append(a);
		        i++;
		    }
		}
		return sb.toString();
	}
}
