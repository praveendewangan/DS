package recursion;

public class TargetSubSubset {
    public static void main(String[] args) {
        int len = 5;
        int[] arr = {1,2,3,4,5};
        int target = 7;
        printSubset(arr,0,"",0,target);
    }
    private static void printSubset(int[] arr,int idx,String set,int sum,int target) {
        if(idx == arr.length) {
            if(sum == target) {
                System.out.println(set);
            }
            return;
        }
        printSubset(arr,idx+1,set+arr[idx]+",",sum + arr[idx],target);
        printSubset(arr,idx+1,set,sum,target);
    }
}
