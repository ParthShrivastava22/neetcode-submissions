class LRUCache {
    Node head, tail;
    HashMap<Integer, Node> map;
    int size, capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.previous = head;

        size = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        if (size == capacity) {
            map.remove(tail.previous.key);
            removeNode(tail.previous);
            size--;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);
        size++;
    }

    private void addNode(Node node) {
        node.next = head.next;
        head.next.previous = node;

        node.previous = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node previous;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        previous = null;
    }
}
