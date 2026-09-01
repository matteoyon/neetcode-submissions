/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p!=null && q == null) || (p == null && q != null)) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> stackP = new LinkedList<>();
        List<TreeNode> stackQ = new LinkedList<>();

        stackP.addLast(p);
        stackQ.addLast(q);

        while(!stackP.isEmpty() || !stackQ.isEmpty()){
            p = stackP.removeLast();
            q = stackQ.removeLast();
            if(p == null && q == null) continue;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;

            stackP.addLast(p.left);
            stackP.addLast(p.right);

            stackQ.addLast(q.left);
            stackQ.addLast(q.right);
        }

        if(stackP.size() != stackQ.size()) return false;

        return true;

    }
}

//Complexity: T: O(min(n,m)) S: O(min(h,k)) aux (bc O(log(min(n,m))) aux, wc O(min(n,m)) aux)
