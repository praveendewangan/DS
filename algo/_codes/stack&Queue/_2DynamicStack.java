import java.util.*;

public class _2DynamicStack {
    static class Stack {
        private List<Integer> list;

        public Stack() {
            list = new ArrayList<>();
        }
        public void push(int data) {
                list.add(data);
        }
        public int peek() {
            if(size() == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                return list.get(size() - 1);
            }
        }
        public int pop() {
            if(size() == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                int val = peek();
                return val;
            }
        }
        public int size() {
            return list.size();
        }
        public boolean isEmpty() {
            return size() == 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for(int i = 0; i < size() - 1; i++) {
                sb.append(list.get(i)).append(",");
            }
            sb.append(list.get(size() - 1)).append("]");
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        System.out.println(st);
    }
}
