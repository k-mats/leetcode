/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    Queue<TreeNode> queue = new LinkedList<>();
    String serializedBST = String.valueOf(root.val);
    addChildrenToQueueIfNotNull(queue, root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      serializedBST += "," + String.valueOf(node.val);
      addChildrenToQueueIfNotNull(queue, node);
    }

    return serializedBST;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("")) {
      return null;
    }

    String[] splitData = data.split(",");
    TreeNode root = new TreeNode(Integer.valueOf(splitData[0]));

    for (int i = 1; i < splitData.length; i++) {
      TreeNode ithNode = new TreeNode(Integer.valueOf(splitData[i]));
      TreeNode current = root;
      TreeNode prev = null;
      boolean isLeft = false;
      while (current != null) {
        prev = current;
        if (ithNode.val <= current.val) {
          current = current.left;
          isLeft = true;
        } else {
          current = current.right;
          isLeft = false;
        }
      }
      if (isLeft) {
        prev.left = ithNode;
      } else {
        prev.right = ithNode;
      }
    }

    return root;
  }

  private void addChildrenToQueueIfNotNull(Queue<TreeNode> queue, TreeNode node) {
    if (node.left != null) {
      queue.add(node.left);
    }
    if (node.right != null) {
      queue.add(node.right);
    }
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
