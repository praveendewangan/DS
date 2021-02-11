package practice.string;

import java.util.ArrayList;
import java.util.List;

public class _31GenerateValidIpAddresses {
    // O(2^32) == O(1),O(1)
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135").toString());
    }
    private static List<String> restoreIpAddresses(String str) {
        List<String> list = new ArrayList<>();
        int n = str.length();
        if(n<4 || n>12) return list;
        int[] path = new int[4];
        generateIpAddress(list,str,0,path,0);
        return list;
    } 
    private static void generateIpAddress(List<String> list,String str,
                                int buildIdx,int[] path,int segment) {
        if(segment == 4 && buildIdx == str.length()){
            list.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        } else if(segment == 4 || buildIdx == str.length()) {
            return;
        }

        for(int len=1;len <= 3 && buildIdx+len <= str.length();len++) {
            String substr = str.substring(buildIdx, buildIdx+len);
            int value = Integer.parseInt(substr);
            if(value > 255 || len >= 2 && str.charAt(buildIdx) == '0'){
                break;
            }
            path[segment] = value;
            generateIpAddress(list, str, buildIdx+len, path, segment+1);
            path[segment] = -1;
        }
    }
}
