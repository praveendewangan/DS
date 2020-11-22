package linkedlist;


/*Question
        1. You are required to complete the code of our LLToQueueAdapter class.
        2. As data members, you've a linkedlist available in the class.
        3. Here is the list of functions that you are supposed to complete
        3.1. add -> Should accept new data in FIFO manner
        3.2. remove -> Should remove and return data in FIFO manner. If not available,
        print "Queue underflow" and return -1.
        3.3. peek -> Should return data in FIFO manner. If not available, print "Queue
        underflow" and return -1.
        3.4. size -> Should return the number of elements available in the queue
        4. Input and Output is managed for you.

        Note -> The intention is to use linked list functions to achieve the purpose of a queue. All the functions should work in constant time.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _12LinkedListToQueueAdapter {

    public static class LLToQueueAdapter {
        LinkedList<Integer> list;

        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if(size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int peek() {
            if(size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToQueueAdapter qu = new LLToQueueAdapter();

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
