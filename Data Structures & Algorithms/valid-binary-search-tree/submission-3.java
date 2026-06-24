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
    public boolean isValidBST(TreeNode root) {

        long a=Integer.MAX_VALUE;
        long b=Integer.MIN_VALUE;
        return check(root.right,root.val,a) && check(root.left,b,root.val);

    }

    public boolean check(TreeNode root, long x,long y){
        if(root==null){return true;}
        int z=root.val;
        //z>x and z<y
        if(z<=x || z>=y){return false;}
        return check(root.left,x,z) && check(root.right,z,y);
    }
}
//i need to create a range 
