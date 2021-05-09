
public class _1NormalStack {
    static class Stack {
        private int size = 0;
        private int[] arr;

        public Stack(int capacity) {
            arr = new int[capacity];
        }
        public void push(int data) {
            if(size == arr.length) {
                System.out.println("stack overflow");
            } else {
                arr[size] = data;
                size++;
            }
        }
        public int peek() {
            if(size() == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                return arr[size-1];
            }
        }
        public int pop() {
            if(size() == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                int val = peek();
                size--;
                return val;
            }
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }
    public static void main(String[] args) {
        
    } 
}
