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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode root=new TreeNode();
        if(preorder.length!=0){
            root=rec(0,preorder,inorder);
        }
        else{return null;}
        return root;


    }

    public TreeNode rec(int x, int[] preorder,int[] inorder){

        TreeNode root=new TreeNode(preorder[x]);
        int i=find(preorder[x],inorder);
        int[] left=Arrays.copyOfRange(inorder,0,i);
        int[] right=Arrays.copyOfRange(inorder,i+1,inorder.length);
        if(left.length!=0){
            root.left=rec(x+1,preorder,left);
        }
        if(right.length!=0){
            root.right=rec(x+1+left.length,preorder,right);
        }
        
        return root;

    }

    public int find(int x,int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            if(x==arr[i]){return i;}
        }
        return 0;
    }
}
