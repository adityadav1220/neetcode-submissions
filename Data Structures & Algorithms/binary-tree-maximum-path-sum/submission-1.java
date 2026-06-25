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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxP(root);

        return sum;
    }

    public int maxP(TreeNode root) {
        if(root==null){return 0;}
        int a=maxP(root.left);
        if(a<0){a=0;}
        int b=maxP(root.right);
        if(b<0){b=0;}
        sum=Math.max(sum,root.val+a+b);

        return root.val+Math.max(a,b);
    }
}
