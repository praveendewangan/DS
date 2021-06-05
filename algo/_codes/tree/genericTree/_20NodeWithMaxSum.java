import java.io.*;
import java.util.*;

public class _20NodeWithMaxSum {
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
    private static int print(Node node) {
        int s = node.data;
        for(Node child : node.children){
            s += print(child);
        }
        System.out.println(node.data + " -> " + s);
        return s;
    }
    static int nodeData = -1;
    static int sum = node.data;
    private static int maxSum(Node node) {
        int total = node.data;
        for(Node child : node.children){
            total += maxSum(child);
        }
        if(total > sum){
            sum = total;
            nodeData = node.data;
        }
        return  total;
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
    // write your code here
    maxSum(root);
    System.out.println(nodeData + "@" + sum);
  }

}
