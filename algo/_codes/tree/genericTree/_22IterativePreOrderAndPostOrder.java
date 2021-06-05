
import java.io.*;
import java.util.*;

public class _22IterativePreOrderAndPostOrder {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }


  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
    static class Pair{
        Node node;
        int state;
        public Pair(Node node,int state) {
            this.node = node;
            this.state = state;
        }
    }    
  public static void IterativePreandPostOrder(Node node) {
      Stack<Pair> st = new Stack<>();
      st.push(new Pair(node,0));
      String pre = "";
      String post = "";
      while(!st.empty()) {
          Pair rm = st.peek();
          if(rm.state == 0) {
              pre += rm.node.data + " ";
          } else if(rm.state <= rm.node.children.size()) {
              Node child = rm.node.children.get(rm.state-1);
              st.push(new Pair(child,0));
          } else {
              post += rm.node.data + " ";
              st.pop();
          }
              rm.state++;
      }
      
          System.out.println(pre);
          System.out.println(post);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
  }

}