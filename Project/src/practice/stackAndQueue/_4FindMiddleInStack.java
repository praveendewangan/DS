package practice.stackAndQueue;

public class _4FindMiddleInStack {
    // O(1) for middle element 
    static class DLL {
        DLL prev;
        int data;
        DLL next;
        DLL(int data) {
            this.data = data;
        }
    }
    static class MyStack {
        DLL head;
        DLL mid;
        int count;

        void push(int data) {
            DLL node = new DLL(data);
            node.prev = null;
            node.next = this.head;
            this.count++;

            if(this.count == 1) {
                this.mid = node;
            } else {
                this.head.prev = node;
                if(this.count % 2 != 0) {
                    this.mid = this.mid.prev;
                }
            }
            this.head = node;
        }

        int pop() {
            if(this.count == 0) {
                return -1;
            } else {
                DLL node = this.head;
                int data = node.data;
                this.head = node.next;
                if(this.head == null) {
                    this.head.prev = null;
                }
                this.count--;

                if(this.count % 2 != 0) {
                    this.mid = this.mid.next;
                }
                return data;
            }
        }
        int getMiddle() {
            if(this.count == 0) {
                return -1;
            } else {
                return this.mid.data;
            }
        }
    }
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        st.push(55);
        st.push(66);
        st.push(77);
        System.out.println("Item popped is " + st.pop());
        System.out.println("Item popped is " + st.pop());
        System.out.println("Middle Element is " + st.getMiddle());
    }
}
