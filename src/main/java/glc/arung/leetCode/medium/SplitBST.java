package glc.arung.leetCode.medium;

import glc.arung.leetCode.medium.TreeNode;

public class SplitBST{
    public TreeNode[] splitBST(TreeNode root, int v) {
        TreeNode[] result = new TreeNode[2];
        if( root != null ){
            
            dfs(root, v, result);
            
        }
        return result;
    }
    
    void dfs(TreeNode root, int v, TreeNode[] result) {
        if(root == null ) {
            
        }
            
        else if(root.val == v) {
            result[1] = root.right;
            root.right = null;
            result[0] = root;
        } else if (root.val > v) {
            dfs(root.left, v, result);
            root.left = result[1];
            result[1] = root;
        } else if (root.val < v) {
            dfs(root.right, v, result);
            root.right = result[0];
            result[0] = root;
        }
    }
}