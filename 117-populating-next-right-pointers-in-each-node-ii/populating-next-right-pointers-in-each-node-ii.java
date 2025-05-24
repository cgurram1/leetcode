class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        fun(root);               // populate next pointers
        return root;
    }

    private void fun(Node parent) {
        if (parent == null) return;

        Node curr;

        /* ---------- case: parent has ONLY left child ---------- */
        if (parent.right == null && parent.left != null) {
            curr = parent.next;
            /* FIX #1: skip nodes that have NO children */
            while (curr != null && curr.left == null && curr.right == null) {
                curr = curr.next;
            }
            parent.left.next = (curr == null) ? null
                              : (curr.left != null ? curr.left : curr.right);
        }

        /* ---------- case: parent has right child ---------- */
        else if (parent.right != null) {              // covers both-kids or only-right
            if (parent.left != null) {                // link siblings if left exists
                parent.left.next = parent.right;
            }
            curr = parent.next;
            while (curr != null && curr.left == null && curr.right == null) {
                curr = curr.next;                     // FIX #1 repeated
            }
            parent.right.next = (curr == null) ? null
                              : (curr.left != null ? curr.left : curr.right);
        }

        /* ---------- recurse: RIGHT first, then LEFT ---------- */
        fun(parent.right);    // ensures next chain exists for left-side lookups
        fun(parent.left);
    }
}
