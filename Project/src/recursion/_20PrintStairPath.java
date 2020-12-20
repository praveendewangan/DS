package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintStairPath {
    public static void main(String[] args) {
        getPath(4,"");
    }
    private static void getPath(int n,String path) {
        if(n == 0){
            System.out.println(path);
            return;
        } else if(n < 0) {
            return;
        }
        getPath(n-1,path+1);
        getPath(n-2,path+2);
        getPath(n-3,path+3);
    }
}
