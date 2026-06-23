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
    int count = 0;
    public int goodNodes(TreeNode root) {
        
        int r=0;
        if(root != null){
            r=root.val;
        }
        int prevmax=Integer.MIN_VALUE;
        check(root,prevmax);
        return count;
    }

    public void check(TreeNode root,int prevmax){
        if(root==null){return;}
        
        if(root.val>=prevmax){count++;}
        prevmax=Math.max(root.val,prevmax);
        check(root.right,prevmax);
        check(root.left,prevmax);
        return;
    }
}
