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
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (!checkBSTByInOrderTraversal(root)) {
      return false;
    } else {
      return isValidBST(root.left) && isValidBST(root.right)
    }
  }

  private boolean checkBSTByInOrderTraversal(TreeNode node) {
    
  }
}
