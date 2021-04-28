package _codes.stringandarrayList;

public class _4CompressString {

    public static void main(String[] args) {
        String str = "aaaadffdgghhiaaabb";
        System.out.println(compress(str));
    }   
    private static String compress(String str) {
        if(str == null || str.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        sb.append(prev);
        int n = str.length();
        for(int i = 1; i < n; i++) {
            char ch = str.charAt(i);
            if(prev != ch){
                sb.append(ch);
                prev = ch;
            }
        }
        return sb.toString();
    }
}
