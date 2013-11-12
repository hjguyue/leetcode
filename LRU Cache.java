public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }
    
    public void print(){
    	if (head == null) {
			System.out.println("nothing...");
		}
    	Node cursor = head;
    	while (cursor != null){
    		System.out.print("("+cursor.key + ", " + cursor.val +") ");
    		cursor = cursor.next;
    	}
    	System.out.println();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        if (node == head) {
            return node.val;
        }
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        node.next = head;
        head.prev = node;
        head = node;

        return node.val;
    }

    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            if (capacity == 0)
                return;

            if (map.size() < capacity) {
                // whether head == null:
                if (map.size() == 0) {
                    head = node;
                    tail = node;
                } else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
            }
            if (map.size() == capacity) {
                map.remove(tail.key);
                // delete tail:
                if (capacity == 1) {
                    head = node;
                    tail = node;
                } else {
                    Node tailPrev = tail.prev;
                    tail = tailPrev;
                    tail.next = null;
                }
                // update head:
                node.next = head;
                head.prev = node;
                head = node;
            }
            map.put(key, node);
        } else {
            Node node = map.get(key);
            node.val  = value;
            get(key);
        }
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}