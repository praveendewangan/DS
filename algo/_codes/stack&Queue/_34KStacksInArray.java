public class _34KStacksInArray {
    class Stack {
        int[] top;
        int[] data;
        int[] next;
        int free = 0;
        int k,n;
        Stack(int k,int n){
            this.k = k;
            this.n = n;
            top = new int[k];
            data = new int[n];
            next = new int[n];
            for(int i = 0; i < k; i++) {
                top[i] = -1;
            } 
            
            for(int i = 0; i < n-1; i++) {
                next[i] = i+1;
            } 
            next[n-1] = -1;
        }

        public boolean isFull(){
            return free == -1;
        }

        public boolean isEmpty(int i){
            return top[i] == -1;
        }

        public void push(int val, int idx){
            if(isFull()) {
                System.out.println("Stack Overflow");
                return;
            }
            int i = free;
            free = next[i];
            next[i] = top[idx];
            top[idx] = i;
            data[i] = val;
        }
        
        public int pop(int val, int idx){
            if(isEmpty(idx)) {
                System.out.println("Stack underflow");
                return -1;
            }
            int i = top[idx];
            top[idx] = next[i];
            next[i] = free;
            free = i;
            return data[i];
        }
    }
}
