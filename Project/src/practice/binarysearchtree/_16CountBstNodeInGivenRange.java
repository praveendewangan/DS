package practice.binarysearchtree;

public class _16CountBstNodeInGivenRange {
    // O(n),O(1)
    int getCount(Node root,int l, int h) {
        if(root == null) {
            return 0;
        }
        int sn = getCount(root.left,l,h);
        if(root.data >= l && root.data <= h){
            sn++;
        }
        sn += getCount(root.right,l,h);
        return sn;
    }
}
