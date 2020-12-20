package recursion;

import java.util.ArrayList;
import java.util.List;

public class _16GetStairPath {
    public static void main(String[] args) {
        System.out.println(getPath(4));
    }
    private static List<String> getPath(int n) {
        if(n == 0){
            List<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        } else if(n < 0) {
            return new ArrayList<>();
        }
        List<String> path1 = getPath(n-1);
        List<String> path2 = getPath(n-2);
        List<String> path3 = getPath(n-3);
        List<String> paths = new ArrayList<>();
        for (String  s : path1) {
            paths.add(1+s);
        }
        for (String  s : path2) {
            paths.add(2+s);
        }
        for (String  s : path3) {
            paths.add(3+s);
        }
        return paths;
    }
}
