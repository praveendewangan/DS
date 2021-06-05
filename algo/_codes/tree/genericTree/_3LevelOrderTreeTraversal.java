
import java.io.*;
import java.util.*;

public class _3LevelOrderTreeTraversal {
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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrder(Node node){
    Queue<Node> q = new ArrayDeque<>();
    q.add(node);
    while(q.size() > 0) {
        Node top = q.remove();
        System.out.print(top.data + " ");
        for(Node child : top.children) {
            q.add(child);
        }
    }
    System.out.println(".");
  }
  
  public List<List<Integer>> levelOrder1(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null){
        return res;
    }
    Queue<Node> mq = new ArrayDeque<>();
    Queue<Node> cq = new ArrayDeque<>();
    mq.add(root);
    List<Integer> list = new ArrayList<>();
    while(mq.size() > 0) {
        Node rm = mq.remove();
        if(mq.size() == 0){
            list.add(rm.val);
            res.add(list);
            list = new ArrayList<>();
        } else {
            list.add(rm.data);
        }
        for(Node child : rm.children){
            cq.add(child);
        }
        if(mq.size() == 0){
            mq = cq;
            cq = new ArrayDeque<>();
        }
    }
    return res;
}
  
  public List<List<Integer>> levelOrder2(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null){
        return res;
    }
    Queue<Node> mq = new ArrayDeque<>();
    mq.add(root);
    while(mq.size() > 0) {
        int size = mq.size();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Node rm = mq.remove();
            list.add(rm.data);
            for(Node child : rm.children){
                mq.add(child);
            }
        }
        res.add(list);
    }
    return res;
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
    levelOrder(root);
  }

}
