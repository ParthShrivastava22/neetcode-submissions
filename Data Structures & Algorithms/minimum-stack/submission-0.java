class MinStack {

    Node head;
    Node min;

    public MinStack() {
        head = null;
        min = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node();
            head.data = val;
            head.next = null;

            min = new Node();
            min.data = val;
            min.next = null;
        }
        else {
            Node newNode = new Node();
            newNode.data = val;
            newNode.next = head;
            head = newNode;

            if (min == null || val <= min.data) {
                Node minNode = new Node();
                minNode.data = val;

                minNode.next = min;
                min = minNode;
            }
        }
    }
    
    public void pop() {
        int headData = head.data;

        if (head.data == min.data) {
            min = min.next;
        }
        
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return min.data;
    }
}

class Node {
    int data;
    Node next;
}