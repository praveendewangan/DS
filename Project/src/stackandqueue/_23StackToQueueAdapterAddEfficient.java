package stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _23StackToQueueAdapterAddEfficient {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.add(val);
        }

        int remove() {
            if(size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.add(mainS.pop());
                }
                int val = mainS.pop();
                while (helperS.size() > 0) {
                    mainS.add(helperS.pop());
                }
                return val;
            }
        }

        int peek() {
            if(size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                while (mainS.size() > 1) {
                    helperS.add(mainS.pop());
                }
                int val = mainS.pop();
                helperS.add(val);
                while (helperS.size() > 0) {
                    mainS.add(helperS.pop());
                }
                return val;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
