package practice.string;

public class _22CountStringIn2DArray {
    public static void main(String[] args) {
        char[][] a ={
            {'D','D','D','G','D','D'},
            {'B','B','D','E','B','S'},
            {'B','S','K','E','B','K'},
            {'D','D','D','D','D','E'},
            {'D','D','D','D','D','E'},
            {'D','D','D','D','D','G'}
           };
        String str= "GEEKS";
        int count = 0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                count += find(i,j,str,a,0);
            }
        }
        System.out.println(count);
    }
    private static int find(int i,int j,String s,char[][] a,int idx) {
        int found = 0;
        if(i >= 0 && j >= 0 && i < a.length && j < a[0].length && a[i][j] == s.charAt(idx)){
            char temp = a[i][j];
            a[i][j] = 0;
            idx += 1;
            if(idx == s.length()) {
                found = 1;
            } else {
                found += find(i+1, j, s, a, idx);
                found += find(i-1, j, s, a, idx);
                found += find(i, j+1, s, a, idx);
                found += find(i, j-1, s, a, idx);
            }
            a[i][j] = temp;
        }
        return found;
    }
}
