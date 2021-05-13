public class _19CelebrityProblem {
    // O(n)
// 4
// 0000
// 1011
// 1101
// 1110

// 0
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }
    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i < arr.length; i++) {
            st.push(i);
        }
        while(!st.empty() && st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }
        int idx = st.pop();
        for(int i = 0; i < arr.length; i++){
            if(i != idx && arr[i][idx] == 0 || arr[idx][i] == 1){
                System.out.println("none");
                return;
            }
        }
        System.out.println(idx);
    }
}
