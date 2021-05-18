public class _4AddOneToNumberIB {
    // https://www.interviewbit.com/problems/add-one-to-number/
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int n : A){
            sb.append(n);
        }
        // Long num = Long.parseLong(sb.toString());
        int[] nums = new int[sb.length() + 1];
        int idx = 1;
        for(char ch : sb.toString().toCharArray()){
            int val = ch - '0';
            nums[idx++] = val;
        }
        int data = nums[nums.length-1] + 1;
        int c = data / 10;
        data = data % 10;
        nums[nums.length-1] = data;
        for(int i = nums.length - 2; i >= 0; i--){
            int sum = nums[i] + c ;
            c = sum / 10;
            sum %= 10;
            nums[i] = sum;
        }
        boolean flag = false;
        for(int i = 0; i < nums.length; i++) {
            if(!flag && nums[i] > 0) {
                flag = true;
                list.add(nums[i]);
            } else if(flag) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
