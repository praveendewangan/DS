package _codes;

public class Test {
    public static void main(String[] args) {
        boolean flag = false;
        int[] ans = {0,0,0,1,0,3};
        
        for(int i = 0; i < ans.length; i++){
            if(ans[i] != 0) {
                flag = true;
            }
            
            if(flag) {
                System.out.println(ans[i]);
            }
        }
    }
}
