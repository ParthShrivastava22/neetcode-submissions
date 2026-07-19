/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node newHead = new Node(head.val);
        nodeMap.put(head, newHead);

        Node i = head, j = newHead;

        while(i.next != null) {
            i = i.next;
            Node newNode = new Node(i.val);
            j.next = newNode;
            j = j.next;
            nodeMap.put(i, j);
        }

        i = head; j = newHead;
        while(i != null) {
            j.random = nodeMap.get(i.random);
            i = i.next;
            j = j.next;
        }

        return newHead;
    }
}