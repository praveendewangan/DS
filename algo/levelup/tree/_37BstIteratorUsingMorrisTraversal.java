import java.util.*;
public class _37BstIteratorUsingMorrisTraversal {
    private TreeNode res = null;
        private TreeNode curr = null;
        public TreeNode getRightMostNode(TreeNode temp, TreeNode curr) {
            while(temp.right != null && temp.right != curr) {
                temp = temp.right;
            }
            return temp;
        }
        
        public void morrisInTraversal(TreeNode node) {
            this.curr = node;
            while(curr != null) {
                TreeNode leftNode = curr.left;
                if(leftNode != null) {
                    TreeNode rightMostNode = getRightMostNode(leftNode, curr);
                    if(rightMostNode.right != curr) {
                        rightMostNode.right = curr;
                        curr = curr.left;
                    } else {
                        this.res = curr;
                        rightMostNode.right = null;
                        curr = curr.right;
                        break;
                    }
                } else {
                    this.res = curr;
                    curr = curr.right;
                    break;
                }
            }
        }
        
        public BSTIterator_3(TreeNode root) {
            this.curr = root;
        }
        
        public int next() {
            morrisInTraversal(this.curr);
            int val = res.val;
            return val;
        }
        
        public boolean hasNext() {
            return this.curr != null;
        }
}
