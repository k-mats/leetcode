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
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    traverse(root, list);
    return list;
  }

  private void traverse(TreeNode node, List<Integer> list) {
    if (node != null) {
      list.add(node.val);
      traverse(node.left, list);
      traverse(node.right, list);
    }
  }
}
