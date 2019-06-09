package glc.arung.leetCode.medium;

import glc.arung.leetCode.medium.TreeNode;

public class DeleteTreeNode{

    TreeNode deleteNode(TreeNode root, int key) {
        if ( root == null )
          return null;
       return deleteHelper(root, key);
    }

    TreeNode deleteHelper(TreeNode root, int key) {
        if(root == null) {
            /// default return handles this
        }
        else if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            root = left!=null ? left : right;
            addNode(root, left!=null ? right : left);

        } else if (root.val < key) {
            root.right = deleteHelper(root.right, key);
        } else {
            root.left =  deleteHelper(root.left, key);
        }

        return root;
    }

    void addNode(TreeNode root, TreeNode nodeToAdd) {
        if(root == null || nodeToAdd == null)
           return;

        if ( root.val <= nodeToAdd.val ) {
            if(root.right == null) {
                root.right = nodeToAdd;
            } else {
                addNode(root.right, nodeToAdd);
            }
        } else {
            if ( root.left == null ) {
                root.left = nodeToAdd;
            } else {
                addNode(root.left, nodeToAdd);
            }
        }
    }


}

