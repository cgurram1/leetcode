class LRUCache:
    class DLL:
        class Node:
            def __init__(self, left, right, val, key):
                self.val = val
                self.key = key
                self.right = right
                self.left = left

        def __init__(self):
            self.head = self.Node(None, None, None, None)
            self.tail = self.Node(None, None, None, None)
            self.head.right = self.tail
            self.tail.left = self.head

        def remove(self):
            deletedKey = self.tail.left.key
            prev = self.tail.left.left
            prev.right = self.tail
            self.tail.left = prev
            return deletedKey

        def add(self, value, key):
            node = self.Node(None, None, value, key)
            nextNode = self.head.right
            self.head.right = node
            node.left = self.head
            node.right = nextNode
            nextNode.left = node
            return node

        def removeNode(self, node):
            nextNode = node.right
            prevNode = node.left
            prevNode.right = nextNode
            nextNode.left = prevNode

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.m = {}
        self.DLL = self.DLL()

    def get(self, key: int) -> int:
        if key not in self.m:
            return -1
        node = self.m[key]
        self.DLL.removeNode(node)
        newNode = self.DLL.add(node.val, node.key)
        self.m[key] = newNode

        return newNode.val

    def put(self, key: int, value: int) -> None:
        if key in self.m:
            self.m[key].val = value
            self.DLL.removeNode(self.m[key])
            newNode = self.DLL.add(value, key)
            self.m[key] = newNode
            return

        if len(self.m) == self.capacity:
            deletedKey = self.DLL.remove()
            del self.m[deletedKey]

        newNode = self.DLL.add(value, key)
        self.m[key] = newNode