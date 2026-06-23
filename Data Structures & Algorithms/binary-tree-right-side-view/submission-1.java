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
    List<Integer> list=new ArrayList<>();
    int d=0;
    public List<Integer> rightSideView(TreeNode root) {
        a(root,d);
        return list;
    }

    void a(TreeNode root, int d){
        if(root==null){return;}
        if(list.size()<=d){list.add(root.val);}

        if(root.right != null){
            a(root.right,d+1);
            
        }
        //else{return list;}

        if(root.left!=null){
            a(root.left,d+1);
            
        }
        return;
    }

}

//first find all the right side nodes and calc their length
//root-->right-->left
//then according to that skip that many lefts and then again do the same















