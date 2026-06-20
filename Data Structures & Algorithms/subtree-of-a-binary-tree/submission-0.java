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

    public boolean check(TreeNode a,TreeNode b){
        if(a==null && b==null){return true;}
        if(a==null && b!=null){return false;}
        if(a!=null && b==null){return false;}

        if(a.val==b.val && check(a.left,b.left) && check(a.right,b.right)){return true;}
        return false;
    }

    boolean found =false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){return true;}

        if(root.val==subRoot.val && check(root,subRoot)){
            found=true;
        }

        isSubtree(root.left,subRoot);
        isSubtree(root.right,subRoot);

        if(found==true){return true;}
        return false;
    }
}
