import java.util.*;

class _23FirstNonRepeatingCharacter
{
    public String FirstNonRepeating(String s)
    {
        Queue<Character> q = new LinkedList<>();
        int[] f = new int[27];
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            q.add(ch);
            f[ch-'a']++;
            
            while(q.size()!= 0) {
                char front = q.peek();
                int c = f[front-'a'];
                if(c > 1) {
                    q.remove();
                } else {
                    sb.append(front);
                    break;
                }
            }
            if(q.size() == 0) {
                sb.append("#");
            }
        }
        return sb.toString();
    }
}