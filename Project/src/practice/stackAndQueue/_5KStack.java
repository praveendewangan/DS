package practice.stackAndQueue;

public class _5KStack {
    public static void main(String[] args) {
        int k = 3, n = 10;
          
        KStack ks = new KStack(k, n);
  
        ks.push(15, 2);
        ks.push(45, 2);
  
        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
  
        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
  
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));        

    }
    static class KStack {
        int[] top;
        int[] data;
        int[] next;

        int n , k;
        int free;

        KStack(int k,int n) {
            this.k = k;
            this.n = n;
            data = new int[n];
            next = new int[n];
            top = new int[k];

            for(int i=0;i < k;i++) {
                top[i] = -1;
            }
            free = 0;
            for(int i=0;i<n-1;i++) {
                next[i] = i+1;
            }
            next[n-1] = -1;
        }

        boolean isFull() {
            return (free == -1);
        }
        boolean isEmpty(int i) {
            return (top[i] == -1);
        }
        void push(int item, int sn) {
            // Overflow check
            if (isFull()) 
            {
                System.out.println("Stack Overflow");
                return;
            }
  
            int i = free; // Store index of first free slot
  
            // Update index of free slot to index of next slot in free list
            free = next[i];
  
            // Update next of top and then top for stack number 'sn'
            next[i] = top[sn];
            top[sn] = i;
  
            // Put the item in array
            data[i] = item;
        }
  
        // To pop an from stack number 'sn' where sn is from 0 to k-1
        int pop(int sn) {
            // Underflow check
            if (isEmpty(sn)) 
            {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }
  
            // Find index of top item in stack number 'sn'
            int i = top[sn];
  
            top[sn] = next[i]; // Change top to store next of previous top
  
            // Attach the previous top to the beginning of free list
            next[i] = free;
            free = i;
  
            // Return the previous top item
            return data[i];
        }
  
    }
}
