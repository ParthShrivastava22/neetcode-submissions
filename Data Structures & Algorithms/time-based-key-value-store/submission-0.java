class TimeMap {
    HashMap<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Node(timestamp, value));
        } else {
            List<Node> list = new ArrayList<>();
            list.add(new Node(timestamp, value));
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> list = map.get(key);
        int left = 0, right = list.size() - 1;

        while(left <= right) {
            int mid = (right - left) / 2 + left;

            Node node = list.get(mid);
            if (node.timestamp == timestamp) return node.value;
            else if (node.timestamp < timestamp) left = mid + 1;
            else right = mid - 1;
        }

        return (right < 0) ? "" : list.get(right).value;
    }
}

class Node {
    int timestamp;
    String value;

    public Node(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
