public class _6CountCharacterSwtich {
    public static void main(String[] args) {
        String str = "aaaadffdgghhiaaabb";
        System.out.println(solution(str));
    }   
    private static int solution(String str) {
        if(str == null || str.isEmpty()){
            return 0;
        }
        char prev = str.charAt(0);
        int count = 0;
        int n = str.length();
        for(int i = 1; i < n; i++) {
            char ch = str.charAt(i);
            if(prev != ch){
                prev = ch;
                count++;
            }
        }
        return count;
    }
}
