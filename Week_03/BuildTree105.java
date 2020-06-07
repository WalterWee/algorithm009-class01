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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder,0,n-1,map,0,n-1);
    }

    TreeNode buildTree(int[] preorder, int pStart, int pEnd, HashMap<Integer,Integer> map, int iStart, int iEnd) {
        if (pStart > pEnd)
            return null;
        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);

        int iRoot = map.get(preorder[pStart]);
        int leftNum = iRoot - iStart;
        root.left = buildTree(preorder,pStart+1,pStart+leftNum,map,iStart,iRoot-1);
        root.right = buildTree(preorder,pStart+iRoot-iStart+1,pEnd,map,iRoot+1,iEnd);
        return root;
    }

    
}