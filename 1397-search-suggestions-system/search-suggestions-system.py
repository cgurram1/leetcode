class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isWord = False
class Trie:
    def __init__(self):
        self.node = TrieNode()
    def addWord(self,word):
        currNode = self.node
        for i,ch in enumerate(word):
            if currNode.children[ord(ch) - ord('a')] == None:
                currNode.children[ord(ch) - ord('a')] = TrieNode()
            currNode = currNode.children[ord(ch) - ord('a')]
            if i == len(word)-1:
                currNode.isWord = True

class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        trie = Trie()
        for product in products:
            trie.addWord(product)
        result = []
        currNode = trie.node

        prefix = []
        for ch in searchWord:
            prefix.append(ch)

            if not currNode:
                result.append([])
                continue

            currNode = currNode.children[ord(ch) - ord('a')]
            suggestions = []

            def DFS(node, curr):
                if len(suggestions) == 3:
                    return
                if not node:
                    return
                if node.isWord:
                    suggestions.append(''.join(curr))
                for i in range(26):
                    if node.children[i]:
                        curr.append(chr(i + ord('a')))
                        DFS(node.children[i], curr)
                        curr.pop()

            DFS(currNode, prefix[:])
            result.append(suggestions)

        return result