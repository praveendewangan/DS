public class _10MinWindowSubstringLC76 {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        int count = 0;
        int start = 0;
        int startIdx = -1;
        int min = Integer.MAX_VALUE;
        int winSize = 0;
        
        Map<Character,Integer> fp = new HashMap<>();
        Map<Character,Integer> fs = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i); 
            fp.put(ch,fp.getOrDefault(ch,0)+1);
        }
        // System.out.println(fp);
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            fs.put(ch,fs.getOrDefault(ch,0)+1);
            if(fp.containsKey(ch) && fs.get(ch) <= fp.get(ch)) {
                count++;
            }
            
            if(count == t.length()) {
                char sch = s.charAt(start);
                while(!fp.containsKey(sch) || fs.get(sch) > fp.get(sch)) {           
                    fs.put(sch,fs.get(sch) - 1);
                    start++;
                    sch = s.charAt(start);
                }
                
                winSize = i - start + 1;
                if(winSize < min) {
                    min = winSize;
                    startIdx = start;
                }
            }
            
        }
        return startIdx == -1 ? "" : s.substring(startIdx,startIdx+min);
    }

}
