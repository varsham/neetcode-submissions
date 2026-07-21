/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // key: old node
        // value: new node
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>(); // allows nodes to be connected
        if (node == null) return null;
        // for bfs, start with one starting node
        map.put(node, new Node(node.val));
        // add that starting node to the queue
        q.add(node);

        while (!q.isEmpty()) {
            // pop the top node
            // Queues are LIFO so it's like a line
            Node cur = q.poll();

            // loop through the current node's neighbors
            for (Node n : cur.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    // add each neighbor to the queue as well if it hasn't already been tracked
                    // ensures that each node only gets cloned once
                    q.add(n);
                }
                // add this neighbor to the current node's neighbors
                map.get(cur).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}