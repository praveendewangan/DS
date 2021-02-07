package practice.matrix;

public class _4RowWithMax1s {
    //
    int rowWithMax1s(int arr[][], int n, int m) {
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(arr[j][i] == 1){
                    return j;
                }
            }
        }
        return -1;
    }
    
    
}
