
import java.io.*;
import java.util.*;

public class _21DiameterOfGenericTreeEfficient {
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
  private static int height(Node node) {
      int ht = -1;
      for(Node child : node.children) {
          ht = Math.max(ht,height(child));
      }
      return ht + 1;
  }
  static int dia = 0;
  private static int diameter(Node node){
      int mh = -1;
      int smh = -1;
      for(Node child : node.children){
          int ht = diameter(child);
          if(ht >= mh) {
              smh = mh;
              mh = ht;
          } else if(ht > smh) {
              smh = ht;
          }
      }
      dia = Math.max(dia,mh+smh+2);
      return mh + 1;
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
    diameter(root);
    System.out.println(dia);
  }

}
