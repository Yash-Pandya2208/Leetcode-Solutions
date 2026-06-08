/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children=new HashSet<>();
        Map<Integer , TreeNode>map=new HashMap<>();
        for(int node[]:descriptions){
         int parent=node[0];
         int child=node[1];
         int isleft=node[2];
         children.add(child);

         TreeNode Parentnode=map.computeIfAbsent(parent,TreeNode::new);
         TreeNode Childnode=map.computeIfAbsent(child,TreeNode::new);

         if(isleft==1){
            Parentnode.left=Childnode;
         }
         else{
            Parentnode.right=Childnode;
        }
        }
        for(int node[]:descriptions){
            if(!children.contains(node[0])){
                return map.get(node[0]);
            }
        }
            return null;

    }
}
