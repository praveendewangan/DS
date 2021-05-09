public class _11DailyTemperature {
    // https://leetcode.com/problems/daily-temperatures/

    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
            int len = arr.length;
            int[] res = new int[len];
            st.push(0);
            for(int i = 1; i < len; i++){
                while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                    res[st.pop()] = i;
                }
                st.push(i);
            }
            while(!st.isEmpty()) {
                int idx = st.pop();
                res[idx] = idx;
            }
            for(int i = 0; i < arr.length; i++){
                res[i] =  res[i] - i ;
            }
            return res;
    }
}
