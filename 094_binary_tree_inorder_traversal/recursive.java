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
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    traverse(root, list);
    return list;
  }

  private void traverse(TreeNode node, List<Integer> list) {
    if (node != null) {
      traverse(node.left, list);
      list.add(node.val);
      traverse(node.right, list);
    }
  }
}
