package practice.string;

public class _23SearchWordIn2DGrid {
    
    static int count = 0;
	public static void main (String[] args) throws Exception {
		
        char[][] a = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' }, 
        { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' }, 
        { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } }; 
        // patternSearch(grid, "GEEKS"); 
            int n = a.length ,m = a[0].length;
            String input = "GEEKS";
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++) {
                    if(a[i][j] == input.charAt(0)) {
                        find(i,j,input,input.length(),a,0,-1,-1);
                    }
		        }
            }
            if(count == 0){
                System.out.println(-1);
            }
	}
	private static void find(int i,int j,String input,int size,char[][] a,int idx,int start,int end) {
        
        if(i >= 0 && j >= 0 && i < a.length && j < a[0].length && a[i][j] == input.charAt(idx)) {
	        char temp = a[i][j];
	        a[i][j] = 0;
            idx += 1;
            start = start == -1 ? i : start;
            end = end  == -1 ? j : end;
	        if(idx == size) {
                count++;
                System.out.println(start + "," + end);
	        } else {
	            find(i+1,j,input,size,a,idx,start,end);
	            find(i-1,j,input,size,a,idx,start,end);
	            find(i,j+1,input,size,a,idx,start,end);
	            find(i,j-1,input,size,a,idx,start,end);
            }
            start = -1;
            end = -1;
	        a[i][j] = temp;
	    }
	}
}
