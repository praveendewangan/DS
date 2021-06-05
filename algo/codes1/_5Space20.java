public class _5Space20 {
    public static void main(String[] args) {
        String str = "Hello, World!";
        int spaces = 0;
        for(char ch : str.toCharArray()){
            if(ch == ' ') {
                spaces++;
            }
        }
        String filler = "%20";
        int extraSpaces = spaces*3 - spaces;
        char[] array = new char[str.length() + extraSpaces];
        int qi = str.length()-1;
        int ai = array.length-1;
        for(int i = qi; i >= 0; i--){
            if(str.charAt(i) == ' '){
                for(int n = 2; n >= 0; n--){
                    array[ai--] = filler.charAt(n);
                }
            } else {
                array[ai--] = str.charAt(i);
            }
        }
        
        System.out.println(String.valueOf(array)); 
    }
}
