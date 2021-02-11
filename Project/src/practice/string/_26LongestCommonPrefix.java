package practice.string;

public class _26LongestCommonPrefix {
    // l = length of smallest string in the array
    // O(l*number of string),O(1)
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = strs.length;
        if(len == 0 || strs[0].isEmpty()) {
            return "";
        }
        while(i < strs[0].length()) {
            char ch = strs[0].charAt(i);
            for(int j=0;j<len;j++){
                if(i == strs[j].length()) {
                    return sb.toString();
                } else if(strs[j].charAt(i) != ch){
                    return sb.toString();
                } else {
                    if(j == len-1) {
                        sb.append(strs[j].charAt(i));
                        i++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
