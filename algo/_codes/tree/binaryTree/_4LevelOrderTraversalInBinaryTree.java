
import java.io.*;
import java.util.*;

public class _4LevelOrderTraversalInBinaryTree {
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

  //  Level order traversal using size
  public List<List<Integer>> levelOrderSizeWise(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    Queue<Node> mq = new ArrayDeque<>();
    mq.add(root);
    List<Integer> list = new ArrayList<>();
    while(mq.size() > 0) {
        int s = mq.size();
        while(s-- > 0) {
          Node rm = mq.remove();
            list.add(rm.data);
            if(rm.left != null){
                mq.add(rm.left);   
            }

            if(rm.right != null){
                mq.add(rm.right);   
            }
        }
        
        res.add(list);
        list = new ArrayList<>();
    }
    return res;
}

//  Level order traversal using two queues
  public static void levelOrder(Node node) {
    Queue<Node> q = new ArrayDeque<>();
    Queue<Node> cq = new ArrayDeque<>();
    q.add(node);
    while(q.size() > 0) {
        Node rm = q.remove();
        System.out.print(rm.data + " ");
        
        if(rm.left != null) {
            cq.add(rm.left);
        }
        if(rm.right != null) {
            cq.add(rm.right);
        }
        if(q.size() == 0) {
            System.out.println();
            q = cq;
            cq = new ArrayDeque<>();
        }
    }
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
    levelOrder(root);
  }

}
