# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        treeMap = defaultdict(int)
        maxDepth = 0
        def depth(currNode,currDepth):
            nonlocal maxDepth
            if(currNode == None):
                return
            maxDepth = max(maxDepth,currDepth)
            treeMap[currNode] = currDepth
            depth(currNode.left, currDepth + 1)
            depth(currNode.right, currDepth + 1)
        
        depth(root,0)

        def commonAncestor(currNode, maxDepth):
            if(currNode == None):
                return None
            if(treeMap[currNode] == maxDepth):
                return currNode
            leftAns = commonAncestor(currNode.left, maxDepth)
            rightAns = commonAncestor(currNode.right, maxDepth)
            
            if leftAns != None and rightAns != None:
                return currNode
            elif(leftAns != None or rightAns != None):
                if(rightAns):
                    return rightAns
                else:
                    return leftAns
            
            return None
        
        # for node in treeMap:
        #     print(node.val,treeMap[node])
        return commonAncestor(root,maxDepth)