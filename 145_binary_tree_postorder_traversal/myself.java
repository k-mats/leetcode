/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
  * Reverse the steps of preorder (normal DFS)
  *   - Use LinkedList as List with `addFirst`
  *   - Push the left node first into Stack
  */
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if (root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      list.addFirst(node.val);
      if (node.left != null) stack.push(node.left);
      if (node.right != null) stack.push(node.right);
    }
    return list;
  }
}
