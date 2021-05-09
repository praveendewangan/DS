import java.util.*;
public class _3GenericStack {
    static class Stack<T> {
        private List<T> list;

        public Stack() {
            list = new ArrayList<>();
        }
        public void push(T data) {
                list.add(data);
        }
        public T peek() {
            if(size() == 0) {
                System.out.println("underflow");
                return null;
            } else {
                return list.get(size() - 1);
            }
        }
        public T pop() {
            if(size() == 0) {
                System.out.println("underflow");
                return null;
            } else {
                T val = peek();
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
        Stack<Double> st = new Stack<>();
        st.push(10.5D);
        st.push(20.2D);
        System.out.println(st);

        System.out.println(Calendar.getInstance().getWeekYear());
    }

}
