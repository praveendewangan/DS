
import java.io.*;
import java.util.*;

public class _17LargestBstSubTree {
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
//   Using global variable
static int sz = 0;
static Node bstnode = null;
public static BPair largestBst(Node node) {
    if(node == null) return new BPair();
    BPair lr = largestBst(node.left);
    BPair rs = largestBst(node.right);
    boolean status = lr.max < node.data && rs.min > node.data;
    BPair res = new BPair();
    res.min = Math.min(node.data, Math.min(lr.min, rs.min));
    res.max = Math.max(node.data, Math.max(lr.max, rs.max));
    res.isBst = lr.isBst && rs.isBst && status;
    res.count = lr.count + rs.count + 1;
    if(res.isBst && res.count > sz) {
        bstnode = node;
        sz = res.count;
    }
    return res;
}
// Without using global variable
  static class BPair {
       boolean isBst;
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
       int count = 0;
       Node node;
       public BPair() {
           this.isBst = true;
       }
   } 
   
    private static BPair lbst(Node node) {
        if(node == null) return new BPair();
        BPair lp = lbst(node.left);
        BPair rp = lbst(node.right);
        BPair p = new BPair();
        p.max = Math.max(node.data,Math.max(lp.max,rp.max));
        p.min = Math.min(node.data,Math.min(lp.min,rp.min));
        int c = 0;
        Node nn = null;
        if(lp.isBst && rp.isBst) {
            c = lp.count + rp.count;
        } else if(lp.isBst) {
            nn = lp.node;
            c = lp.count;
        } else if(rp.isBst) {
            nn = rp.node;
            c = rp.count;
        }
        p.isBst = lp.isBst && rp.isBst && node.data > lp.max && node.data < rp.min;
        if(p.isBst) {
            p.count = c + 1;
            p.node = node;
        } else {
            p.count = c;
            p.node = nn;
        }
        return p;
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
    
    BPair p = lbst(root);
    System.out.println(p.node.data + "@" + p.count);
  }

}
