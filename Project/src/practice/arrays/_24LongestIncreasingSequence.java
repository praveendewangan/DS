package practice.arrays;

public enum _24LongestIncreasingSequence {
    static int findLongestConseqSubseq(int arr[], int n)
	{
	   Set<Integer> set = new HashSet<>();
	   int res = 0;
	   for(int a : arr){
	       set.add(a);
	   }
	   
	   for(int a : arr){
	       if(!set.contains(a-1)){
	           int cur = a;
	           int count = 1;
	           while(set.contains(cur+1)) {
	               cur += 1; 
	               count++;
	           }
	           res = Math.max(res,count);
	       }
	   }
	   return res;
	   
	}   
}
