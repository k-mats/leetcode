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
    Stack<TreeNode> stack = new Stack<>();
    pushAllLeftNodes(stack, root);
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      pushAllLeftNodes(stack, node.right);
    }
    return list;
  }

  private void pushAllLeftNodes(Stack<TreeNode> stack, TreeNode node) {
    TreeNode current = node;
    while (current != null) {
      stack.push(current);
      current = current.left;
    }
  }
}
