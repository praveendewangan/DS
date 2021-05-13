public class _20MergeOverlappingInterval {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }
    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        public Pair(int st,int et) {
            this.st = st;
            this.et = et;
        }
        public int compareTo(Pair o) {
            if(this.st != o.st){
                return this.st - o.st;
            } else {
                return this.et - o.et;
            }
        }
    }
    public static void mergeOverlappingIntervals(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for(int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0],arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);

        for(int i = 1; i < arr.length; i++){
            Pair top = st.peek();
            if(pairs[i].st <= top.et){
                top.et = Math.max(pairs[i].et,top.et);
            } else {
                st.push(pairs[i]);
            }            
        }
        Stack<Pair> rst = new Stack<>();
        while(!st.empty()){
            rst.push(st.pop());
        }
        while(!rst.empty()) {
            Pair o = rst.pop();
            System.out.println(o.st +" " + o.et);
        }
    }    
}
