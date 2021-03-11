package practice.binarysearchtree;

public class _4PredecessorAndSuccessor {
    // O(n),O(1)
    static class Res {
        Node pre;
        Node succ;
    }
    public static void findPreSuc(Node node, Res p, Res s, int key)
    {
       if(node == null) return;
       if(node.data == key) {
           if(node.left != null) {
               Node temp = node.left;
               while(temp.right != null) {
                   temp = temp.right;
               }
               p.pre = temp;
           }
           
           if(node.right != null) {
               Node temp = node.right;
               while(temp.left != null) {
                   temp = temp.left;
               }
               s.succ = temp;
           }
           return;
       }
       if(node.data < key) {
               p.pre = node;
           findPreSuc(node.right,p,s,key);
       } else{
            s.succ = node;
            findPreSuc(node.left,p,s,key);
       }
    }
}
