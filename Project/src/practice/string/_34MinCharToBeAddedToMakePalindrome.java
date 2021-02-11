package practice.string;

public class _34MinCharToBeAddedToMakePalindrome {
    public static void main (String[] args) {
		String str = "AACECAAAA";
		int i=0;
		int j = str.length()-1;
		int count = 0;
		while(i < j) {
		    if(str.charAt(i) != str.charAt(j)){
		        i=0;
		        j = str.length()-1-(++count);
		    } else {
		        i++;
		        j--;
		    }
		}
		System.out.println(count);
	}
}
