import java.util.*;

public class _15SerializeAndDeserializeNArrytree {
  public static Scanner scn = new Scanner(System.in);

  static class Node {
    public int val;
    public ArrayList<Node> children;

    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }
  
  public static void serialize_1(Node node, StringBuilder sb) {
        sb.append(node.val + "#");
        for(Node child : node.children) {
            serialize_1(child, sb);
        }
        sb.append("null#");
    }

  // Encodes a tree to a single string.
  public static String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    serialize_1(root,sb);
    return sb.toString(); 
  }

  // Decodes your encoded data to tree.
  public static Node deserialize(String str) {
    if(str.equals("node#")) return null; 
    
    String[] data = str.split("#");
    Node root = new Node(Integer.parseInt(data[0]));
    Stack<Node> st = new Stack<>();
    st.push(root);
    for(int i = 1; i < data.length; i++) {
        if(data[i].equals("null")) {
            st.pop();
        } else {
            Node nn = new Node(Integer.parseInt(data[i]));
            st.peek().children.add(nn);
            st.push(nn);
        }
    }
        return root;
  }

  // input_Section=================================================
  public static void display(Node node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append(node.val + " -> ");
    for (Node child : node.children) {
      sb.append(child.val + " ");
    }
    System.out.println(sb.toString());

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node createTree(String[] arr) {
    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length - 1; i++) {
      String s = arr[i];
      if (s.equals("null")) {
        Node node = st.pop();
        st.peek().children.add(node);
      } else {
        Node node = new Node(Integer.parseInt(s));
        st.push(node);
      }
    }

    return st.size() != 0 ? st.pop() : null;
  }

  public static void solve() {
    String str = scn.nextLine();
    String[] arr = str.split(" ");

    Node root = createTree(arr);
    String s = serialize(root);
    display(deserialize(s));
  }

  public static void main(String[] args) {
    solve();
  }
}