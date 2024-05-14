package Home_Work.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Homework6_1 {

    // Definition for a Node.
    public static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null");
        } else {
            int maxChildDepth = 0;
            for (Node child : root.children) {
                int childDepth = maxDepth(child);
                maxChildDepth = Math.max(maxChildDepth, childDepth);
            }
            return maxChildDepth + 1;
        }
    }
}
