package practice.string;

public class _6CountAndSay {
    // O((n-1)*(val.length))
    public String countAndSay(int n) {
        // if(n == 0) return "";
        if(n == 1) return "1";
        // int c = 1;
        String val = "1";
        String t = "";
        for(int i=1;i<n;i++) {
            char c = val.charAt(0);
            StringBuilder s = new StringBuilder(); 
            int count = 1;
            for(int j = 1; j <val.length();j++) {
                if(c != val.charAt(j)){
                    s.append(count);
                    s.append(c);
                    count = 0;
                    c = val.charAt(j);
                }
                count++;
            } 
            s.append(count);
            s.append(c);
            val = s.toString();
        }
        return val;
    }    
}
