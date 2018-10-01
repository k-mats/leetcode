/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
  Stack<TreeNode> stack = new Stack<>();

  public BSTIterator(TreeNode root) {
    pushNodeAndAllLeftChildren(root);
  }

  /**
   * @return whether we have a next smallest number
   * TC: O(1), SC: O(h)
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /**
   * @return the next smallest number
   * TC: O(h), SC: O(h)
   */
  public int next() {
    TreeNode node = stack.pop();
    pushNodeAndAllLeftChildren(node.right);
    return node.val;
  }

  /**
   * TC: O(h), SC: O(h)
   */
  private void pushNodeAndAllLeftChildren(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
