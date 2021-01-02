/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Follow up: Solve the problem if repeated values on the tree are allowed.

 */
//Solution approach: A classic node to node compare and preOrderTraversal.
public class Day2_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public TreeNode targetCopy;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode root = original;
        TreeNode copy = cloned;
        getTargetCopyUtil(root, copy, target);
        
        return targetCopy;
    }
    
    public void getTargetCopyUtil(final TreeNode root, final TreeNode copy, final TreeNode target) {
        // if (root == null && target == null) {
        //     return copy;
        // }
        
        if (root == target) {
            targetCopy = copy;
            return;
        }
        
        if (root.left != null)
            getTargetCopyUtil(root.left, copy.left, target);
            
        if (root.right != null)
            getTargetCopyUtil(root.right, copy.right, target);
        
        return; 
    }
}