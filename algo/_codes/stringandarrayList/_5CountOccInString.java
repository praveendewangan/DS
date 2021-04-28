package _codes.stringandarrayList;
public class _5CountOccInString {
    public static void main(String[] args) {
        String str = "aaaadffdgghhiaaabb";
        System.out.println(solution(str));
    }   
    private static String solution(String str) {
        if(str == null || str.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        sb.append(prev);
        int n = str.length();
        for(int i = 1; i < n; i++) {
            char ch = str.charAt(i);
            if(prev != ch){
                if(count == 0 || count == 1) {
                    sb.append(ch);
                } else {
                    sb.append(count).append(ch);
                }
                prev = ch;
                count = 0;
            }
            count++;
        }
        if(count > 1){
            sb.append(count);
        }
        return sb.toString();
    }
}
