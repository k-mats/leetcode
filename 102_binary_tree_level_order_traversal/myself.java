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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> innerAnswer = new ArrayList<>();
            int layerSize = queue.size();

            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                innerAnswer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            answer.add(innerAnswer);
        }
        return answer;
    }
}
