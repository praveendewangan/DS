
import java.io.*;
import java.util.*;

public class _5LcaInBST {
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
    private static List<Integer> path(Node node,int data) {
        if(node == null) {
            return new ArrayList<>();
        }
        if(node.data == data) {
            List<Integer> list = new ArrayList<>();
            list.add(data);
            return list;
        }
        if(node.data > data){
            List<Integer> list = path(node.left,data);
            if(list.size() > 0) {
                list.add(node.data);
            }
            return list;
        } else {
            List<Integer> list = path(node.right,data);
            if(list.size() > 0) {
                list.add(node.data);
            }
            return list;
        }
    }
  public static int lca(Node node, int d1, int d2) {
    List<Integer> p1 = path(node,d1);
    List<Integer> p2 = path(node,d2);
    int res = 0;
    int i = p1.size() -1;
    int j = p2.size() -1;
    while(i >= 0 && j >= 0 && p1.get(i).equals(p2.get(j))) {
        res = p1.get(i);
        i--;
        j--;
    }
    return res;
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

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int lca = lca(root, d1, d2);
    System.out.println(lca);
  }

}
