public class _11SmallestDistinctWindow {
    // For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca”.
    
    final static String EMPTY = "";
    public String findSubString( String str) {
        if(str == null || str.length() == 0) return EMPTY;
        Map<Character,Integer> fp = new HashMap<>();
        Map<Character,Integer> fs = new HashMap<>();
        int pcount = 0;
        int count = 0;
        int start = 0;
        int sIdx = 0;
        int min = Integer.MAX_VALUE;
        int n = str.length();
        int winSize = 0;
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(!fp.containsKey(ch)){
                pcount++;
                fp.put(ch,0);
            }
        }
        
        for(int i=0; i < n; i++) {
            char ch = str.charAt(i);
            fs.put(ch,fs.getOrDefault(ch,0)+1);
            if(fp.get(ch) == 0) {
                fp.put(ch,1);
                count++;
            }
            
            if(count == pcount) {
                char sch = str.charAt(start);
                while(fs.get(sch) > 1) {
                    fs.put(sch,fs.get(sch)-1);
                    start++;
                    sch = str.charAt(start);
                }
                // System.out.println("i -> " +i +", start -> "+start+", winsize -> "+winSize );
                winSize = i - start + 1;
                // System.out.println("i -> " +i +", start -> "+start+", winsize -> "+winSize );
                if(winSize < min) {
                    min = winSize;
                    sIdx = start;
                }
            }
        }
        // System.out.println("sIdx -> " + sIdx);
        // System.out.println("min -> " + min);
        // System.out.println("str -> " + str.substring(sIdx,sIdx+min));
        return sIdx == -1 ? "" : str.substring(sIdx,sIdx+min);
    }
}
