/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelp(result,root);
        return result;
    }

    public void inorderTraversalHelp(List<Integer> list, TreeNode root){
        if(root != null){
            if(root.left != null)
                inorderTraversalHelp(list,root.left);
            list.add(root.val);
            if(root.right != null)
                inorderTraversalHelp(list,root.right);
        }
        
    }
}