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
    /**
     * Check layer by layer using BFS
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) {
                    queue.add(left);
                    layer.add(left.val);
                } else {
                    layer.add(null);
                }

                if (right != null) {
                    queue.add(right);
                    layer.add(right.val);
                } else {
                    layer.add(null);
                }
            }

            // Check if the layer is symmetric
            for (int i = 0; i < layer.size() / 2; i++) {
                if (layer.get(i) != layer.get(layer.size() - 1 - i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
