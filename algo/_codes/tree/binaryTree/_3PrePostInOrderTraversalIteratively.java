import java.io.*;
import java.util.*;

public class _3PrePostInOrderTraversalIteratively {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  private static void preorder(Node node) {
      Stack<Node> st = new Stack<>();
      st.push(node);
      while(!st.empty()) {
          Node rm = st.pop();
          System.out.print(rm.data + " ");
          if(rm.right != null) {
              st.push(rm.right);
          }
          if(rm.left != null) {
              st.push(rm.left);
          }
      }
      System.out.println();
  }
  static class Pair1{
      Node node;
      int state;
      public Pair1(){}
      public Pair1(Node node,int state) {
          this.node = node;
          this.state = state;
      }
  }
  private static void intorder(Node node) {
      Stack<Pair1> st = new Stack<>();
      st.push(new Pair1(node,0));
      while(!st.empty()) {
          Pair1 p = st.pop();
          if(p.state == 0) {
              if(p.node.right != null){
                  st.push(new Pair1(p.node.right,0));
              }
              p.state++;
              st.push(p);
              if(p.node.left != null) {
                  st.push(new Pair1(p.node.left,0));
              }
              p.state++;
              
          } else {
            System.out.print(p.node.data + " ");
            // st.pop();
          }
      }
      System.out.println();
  }
  private static void postorder(Node node) {
      Stack<Pair1> st = new Stack<>();
      st.push(new Pair1(node,0));
      while(!st.empty()) {
          Pair1 p = st.peek();
          if(p.state == 0) {
              if(p.node.right != null){
                  st.push(new Pair1(p.node.right,0));
              }
              p.state++;
              if(p.node.left != null) {
                  st.push(new Pair1(p.node.left,0));
              }
              p.state++;
              
          } else {
            System.out.print(p.node.data + " ");
            st.pop();
          }
      }
      System.out.println();
  }

  public static void iterativePrePostInTraversal(Node node) {
    preorder(node);
    intorder(node);
    postorder(node);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    iterativePrePostInTraversal(root);
  }

}
