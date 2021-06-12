import java.io.*;
import java.util.*;

public class _7TargetSumPair {
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
//   O(nh) - o(h)
    public static void tsp1(Node node,Node root,int data) {
        if(node == null) return;
        int n1 = node.data;
        int n2 = data - n1;
        tsp1(node.left,root,data);
        if(n1 < n2 && find(root,n2)) {
            System.out.println(n1 + " " + n2);
        }
        tsp1(node.right,root,data);
    }
    
    private static boolean find(Node node,int tar) {
        if(node == null) return false;
       
        if(node.data > tar) {
            return find(node.left,tar);
        } else if(node.data < tar) {
            return find(node.right,tar);
        } else {
            return true;
        }
    }
    
//  O(n) - O(h)
     public static void tsp2(Node node,int tar) {
         List<Integer> list = new ArrayList<>();
         inorder(node,list);
         int l = 0;
         int r = list.size() - 1;
         while(l < r) {
             int sum = list.get(l) + list.get(r);
             if(sum > tar) {
                 r--;
             } else if(sum < tar) {
                 l++;
             } else {
                 System.out.println(list.get(l) + " " + list.get(r));
                 l++;
                 r--;
             }
         }
     }
     
     private static void inorder(Node node,List<Integer> list) {
         if(node == null) return;
         inorder(node.left,list);
         list.add(node.data);
         inorder(node.right,list);
     }

     // method 3, time : O(n), space : O(h), h-> height
    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    public static int inorderItr(Stack<Pair> st) {
        while(st.size() > 0) {
            Pair p = st.peek();

            if(p.state == 0) {
                // left child
                if(p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
            } else if(p.state == 1) {
                // right child
                if(p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
                return p.node.data;
            } else {
                // pop
                st.pop();
            }
        }
        return -1;
    }

    public static int revInorderItr(Stack<Pair> st) {
        while(st.size() > 0) {
            Pair p = st.peek();

            if(p.state == 0) {
                // right child
                if(p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
            } else if(p.state == 1) {
                // left child
                if(p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
                return p.node.data;
            } else {
                // pop
                st.pop();
            }
        }
        return -1;
    }


    public static void printTargetSumPair3(Node node, int target) {
        Stack<Pair> ls = new Stack<>();
        Stack<Pair> rs = new Stack<>();

        ls.push(new Pair(node, 0));
        rs.push(new Pair(node, 0));


        int left = inorderItr(ls);
        int right = revInorderItr(rs);

        while(left < right) {
            int sum = left + right;
            if(sum > target) {
                right = revInorderItr(rs);
            } else if(sum < target) {
                left = inorderItr(ls);
            } else {
                System.out.println(left + " " + right);
                left = inorderItr(ls);
                right = revInorderItr(rs);
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    // tsp1(root,root,data);
    tsp2(root,data);
  }

}
