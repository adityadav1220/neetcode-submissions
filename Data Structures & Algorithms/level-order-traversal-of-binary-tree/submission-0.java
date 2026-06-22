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
    List<List<Integer>> list=new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level=0;
        a(root,level);
        return list;

    }

    public void a(TreeNode root, int level){
        if(root==null){return;}
        if(list.size()<=level){
            List<Integer> l=new ArrayList<>();
            l.add(root.val);
            list.add(l);
        }
        else{
            list.get(level).add(root.val);
        }
        a(root.left,level+1);
        a(root.right,level+1);
        return;
    }
}
