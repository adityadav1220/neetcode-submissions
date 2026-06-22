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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int a=root.val;
        int b=p.val;
        int c=q.val;

        if(a>b && a>c){return lowestCommonAncestor(root.left,p,q);}
        if(a<b && a<c){return lowestCommonAncestor(root.right,p,q);}
        return root;

    }
}
