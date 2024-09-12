# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        
        # Find the node to be deleted
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            # Node to be deleted is found
            
            # Case 1: Node has no children (leaf node)
            if not root.left and not root.right:
                return None
            
            # Case 2: Node has only one child
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            
            # Case 3: Node has two children
            # Find the in-order successor (smallest in the right subtree)
            min_larger_node = self.findMin(root.right)
            # Replace the value of the current node with the in-order successor's value
            root.val = min_larger_node.val
            # Delete the in-order successor
            root.right = self.deleteNode(root.right, min_larger_node.val)
        
        return root
    
    def findMin(self, node: TreeNode) -> TreeNode:
        # Helper function to find the minimum value node in a subtree
        while node.left:
            node = node.left
        return node
