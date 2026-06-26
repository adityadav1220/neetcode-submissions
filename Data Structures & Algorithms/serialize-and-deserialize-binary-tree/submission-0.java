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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        s(root,sb);
        return sb.toString();
    }

    public void s(TreeNode root, StringBuilder sb){
        if(root==null){sb.append("n").append("_");return;}
        sb.append(root.val).append("_");
        s(root.left,sb);
        s(root.right,sb);
        return;
    }

    int i=0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("_");
        i=0;
        if(arr[0].equals("n")){return null;}
        TreeNode root=new TreeNode();
        d(arr,root);
        return root;
    }

    public void d(String[] arr,TreeNode root){
        if(i<arr.length-1){
            if(arr[i].equals("n")){root=null;i++;return;}
            int val=Integer.parseInt(arr[i]);
            root.val=val;
            i++;
            if(!arr[i].equals("n")){
                TreeNode x=new TreeNode();
                root.left=x;
            }
            d(arr,root.left);

            if(!arr[i].equals("n")){
                TreeNode y=new TreeNode();
                root.right=y;
            }
            d(arr,root.right);
        }
        else{return;}
    }
}
