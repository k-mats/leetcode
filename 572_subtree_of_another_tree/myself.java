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
  public boolean isSubtree(TreeNode s, TreeNode t) {
    List<TreeNode> candidates = findSubTreeRootCandidates(s, t);
    if (candidates.size() == 0) return false;

    for (TreeNode candidate : candidates) {
      Queue<TreeNode> queueS = new LinkedList<>();
      Queue<TreeNode> queueT = new LinkedList<>();
      queueS.add(candidate);
      queueT.add(t);
      boolean match = true;
      while (!queueS.isEmpty() && !queueT.isEmpty()) {
        TreeNode nodeS = queueS.poll();
        TreeNode nodeT = queueT.poll();
        if (bothNodesAreNull(nodeS.left, nodeT.left)) {
          // do nothing
        } else if (bothNodesHaveSameValue(nodeS.left, nodeT.left)) {
          queueS.add(nodeS.left);
          queueT.add(nodeT.left);
        } else {
          match = false;
          break;
        }
        if (bothNodesAreNull(nodeS.right, nodeT.right)) {
          // do nothing
        } else if (bothNodesHaveSameValue(nodeS.right, nodeT.right)) {
          queueS.add(nodeS.right);
          queueT.add(nodeT.right);
        } else {
          match = false;
          break;
        }
      }
      if (match && queueS.isEmpty() && queueT.isEmpty()) {
        return true;
      }
    }

    return false;
  }

  private List<TreeNode> findSubTreeRootCandidates(TreeNode s, TreeNode t) {
    List<TreeNode> candidates = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.val == t.val) {
        candidates.add(node);
      }
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
    return candidates;
  }

  private boolean bothNodesAreNull(TreeNode s, TreeNode t) {
    return s == null && t == null;
  }

  private boolean bothNodesHaveSameValue(TreeNode s, TreeNode t) {
    return s != null && t != null && s.val == t.val;
  }
}
