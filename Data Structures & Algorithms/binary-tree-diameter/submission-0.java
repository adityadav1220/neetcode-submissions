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
    int res=0;

    public int diameterOfBinaryTree (TreeNode root) {
        ht(root);
        return res;
    }
    public int ht(TreeNode root) {
        if(root==null){return 0;}

        int l=ht(root.left);
        int r=ht(root.right);

        int d=l+r;
        res=Math.max(res,d);
        return 1+Math.max(l,r);
    }
}
