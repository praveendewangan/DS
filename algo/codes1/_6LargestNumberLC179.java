public class _6LargestNumberLC179 {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        if(nums.length == 1) return String.valueOf(nums[0]);
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
		    }
	     };
        Arrays.sort(arr,comp);
        if(arr[0].charAt(0) == '0')
			return "0";
        for(String val : arr) {
            sb.append(val);
        }
        return sb.toString();
    }
}
